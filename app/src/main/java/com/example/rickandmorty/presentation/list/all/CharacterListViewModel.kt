package com.example.rickandmorty.presentation.list.all

import androidx.compose.ui.text.toUpperCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.DeleteCharacterByIdUseCase
import com.example.rickandmorty.domain.usecase.GetCharacterListUseCase
import com.example.rickandmorty.domain.usecase.ResetListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class CharacterListViewModel(
    private val getUseCase : GetCharacterListUseCase,
    private val deleteUseCase : DeleteCharacterByIdUseCase,
    private val resetUseCase : ResetListUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel(){

    private val _data : MutableLiveData<List<CharacterModel>> = MutableLiveData<List<CharacterModel>>(listOf())
    val data : LiveData<List<CharacterModel>> get() = _data

    private val _delete : MutableLiveData<Unit> = MutableLiveData<Unit>()
    val delete : MutableLiveData<Unit> get() = _delete

    // TODO --> ARREGLAR EL USECASE DE FILTRADO
    init {
        getData()
    }
    // TODO --> RETRY

    fun getFilter(name: String) = viewModelScope.launch(dispatcher) {
        _data.postValue(getUseCase.getCharacters().filter { it.name.contains(name) })
    }

    fun getData() = viewModelScope.launch(dispatcher) {
        _data.postValue(getUseCase.getCharacters())
    }

    fun deleteData(id : Int) = viewModelScope.launch(dispatcher) {
        _delete.postValue(deleteUseCase.deletebyId(id))
    }

    fun getReset() = viewModelScope.launch(dispatcher) {
        _data.postValue(resetUseCase.resetList())
    }
}