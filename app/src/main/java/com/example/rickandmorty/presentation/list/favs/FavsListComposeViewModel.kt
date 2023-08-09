package com.example.rickandmorty.presentation.list.favs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.GetFavListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavsListComposeViewModel(
    private val useCase : GetFavListUseCase
) : ViewModel() {

    private val _data : MutableLiveData<List<CharacterModel>> = MutableLiveData<List<CharacterModel>>()
    val data : MutableLiveData<List<CharacterModel>> get() = _data

    fun getList() = viewModelScope.launch(Dispatchers.IO) {
        _data.postValue(useCase.getFavList())
    }

}