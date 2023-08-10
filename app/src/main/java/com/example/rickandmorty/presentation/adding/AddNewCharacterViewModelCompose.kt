package com.example.rickandmorty.presentation.adding

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.GetNewCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewCharacterViewModelCompose(
    private val useCase : GetNewCharacterUseCase
) : ViewModel() {

    private val _character : MutableLiveData<CharacterModel> = MutableLiveData<CharacterModel>()
    val character : LiveData<CharacterModel> get() = _character

    // TODO HACER VALIDACIÓN DE ERRORES

    fun addNewCharacter(characterModel : CharacterModel) = viewModelScope.launch(Dispatchers.IO) {
        try {
            _character.postValue(characterModel)
            useCase.addNewCharacter(characterModel)
        } catch (exception : Error) {
            Log.i("error", "$exception")
        }
    }
}

