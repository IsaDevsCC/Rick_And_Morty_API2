package com.example.rickandmorty.presentation.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val getUseCase : GetCharacterListUseCase
) : ViewModel(){

    private val _data : MutableLiveData<List<CharacterModel>> = MutableLiveData<List<CharacterModel>>(listOf())
    val data : LiveData<List<CharacterModel>> get() = _data

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        _data.postValue(getUseCase.getCharacters())
        Log.i("NODE", data.toString())
    }
}