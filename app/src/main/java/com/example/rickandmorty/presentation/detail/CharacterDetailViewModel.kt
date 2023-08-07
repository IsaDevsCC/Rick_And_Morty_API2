package com.example.rickandmorty.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.GetCharacterDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val getCharacterDetailUseCase : GetCharacterDetailUseCase
) : ViewModel() {

    private val _detail : MutableLiveData<CharacterModel> = MutableLiveData<CharacterModel>()
    val data : MutableLiveData<CharacterModel> get() = _detail

    fun getDetail(id : Int) = viewModelScope.launch(Dispatchers.IO) {
        _detail.postValue(getCharacterDetailUseCase.getCharacterDetail(id))
    }
}