package com.example.rickandmorty.presentation.adding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.model.CharacterModelAdd
import com.example.rickandmorty.domain.usecase.GetNewCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewCharacterViewModelCompose(
    private val useCase : GetNewCharacterUseCase
) : ViewModel() {

    private val _character : MutableLiveData<CharacterModelAdd> = MutableLiveData<CharacterModelAdd>()
    val character : LiveData<CharacterModelAdd> get() = _character

    // TODO HACER VALIDACIÓN DE ERRORES

    fun addNewCharacter(characterModel : CharacterModelAdd) = viewModelScope.launch(Dispatchers.IO) {
        try {
            _character.postValue(characterModel)
            useCase.addNewCharacter(characterModel)
        } catch (exception : Error) {
            Log.i("error", "$exception")
        }
    }
}

