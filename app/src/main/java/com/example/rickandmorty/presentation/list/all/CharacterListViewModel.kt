package com.example.rickandmorty.presentation.list.all

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.DeleteCharacterByIdUseCase
import com.example.rickandmorty.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val getUseCase : GetCharacterListUseCase,
    private val deleteUseCase : DeleteCharacterByIdUseCase
) : ViewModel(){

    private val _data : MutableLiveData<List<CharacterModel>> = MutableLiveData<List<CharacterModel>>(listOf())
    val data : LiveData<List<CharacterModel>> get() = _data

    private val _filter : MutableLiveData<List<CharacterModel>> = MutableLiveData<List<CharacterModel>>(listOf())
    val filter : LiveData<List<CharacterModel>> get() = _filter

    private val _delete : MutableLiveData<Unit> = MutableLiveData<Unit>()
    val delete : MutableLiveData<Unit> get() = _delete

    // TODO --> RETRY
    fun getData(name: String) = viewModelScope.launch(Dispatchers.IO) {
        _data.postValue(if (name.isNotEmpty()) { getUseCase.getCharacters().filter { it.name.contains(name) } }
                            else getUseCase.getCharacters())
    }

    fun deleteData(id : Int) = viewModelScope.launch(Dispatchers.IO) {
        _delete.postValue(deleteUseCase.deletebyId(id))
    }

}