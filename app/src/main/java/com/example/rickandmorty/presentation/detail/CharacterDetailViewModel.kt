package com.example.rickandmorty.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.AddToFavUseCase
import com.example.rickandmorty.domain.usecase.GetCharacterDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val getCharacterDetailUseCase : GetCharacterDetailUseCase,
    private val addToFav : AddToFavUseCase
) : ViewModel() {

    private val _detail: MutableLiveData<CharacterModel> = MutableLiveData<CharacterModel>()
    val data: MutableLiveData<CharacterModel> get() = _detail

    private val _set: MutableLiveData<Unit> = MutableLiveData<Unit>()
    val set: MutableLiveData<Unit> get() = _set

    fun getDetail(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        _detail.postValue(getCharacterDetailUseCase.getCharacterDetail(id))
    }

    fun addToFavCharacter(id: Int, fav: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        _set.postValue(addToFav.addCharacterToFav(id, fav))
    }

}
