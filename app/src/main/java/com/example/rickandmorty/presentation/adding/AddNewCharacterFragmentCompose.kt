package com.example.rickandmorty.presentation.adding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.databinding.FragmentAddNewCharacterBinding
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.theme.fonts
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNewCharacterFragmentCompose : Fragment() {

    private lateinit var binding : FragmentAddNewCharacterBinding
    private val viewModel : AddNewCharacterViewModelCompose by viewModel()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAddNewCharacterBinding.inflate(layoutInflater)
        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cvAdd.setContent { 
            PrintScreen()
        }
    }

    @Composable
    private fun PrintScreen() {
        var name by remember { mutableStateOf(TextFieldValue()) }
        var status by remember { mutableStateOf(TextFieldValue()) }
        var specie by remember { mutableStateOf(TextFieldValue()) }
        var gender by remember { mutableStateOf(TextFieldValue()) }

        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            GetText(string = "Name")
            Space()
            //GetTextField(name)
            TextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .alpha(0.8F)
                    .background(Color.White),
                placeholder = { Text(text = "Name") }
            )
            Space()
            GetText(string = "Status")
            Space()
            TextField(
                value = status,
                onValueChange = { status = it },
                modifier = Modifier
                    .alpha(0.8F)
                    .background(Color.White),
                placeholder = { Text(text = "Status") }
            )
            Space()
            GetText(string = "Specie")
            Space()
            TextField(
                value = specie,
                onValueChange = { specie = it },
                modifier = Modifier
                    .alpha(0.8F)
                    .background(Color.White),
                placeholder = { Text(text = "Specie") }
            )
            Space()
            GetText(string = "Gender")
            Space()
            TextField(
                value = gender,
                onValueChange = { gender = it },
                modifier = Modifier
                    .alpha(0.8F)
                    .background(Color.White),
                placeholder = { Text(text = "Gender") }
            )
            Space()
            Space()

            if (name.text.isNotEmpty() || status.text.isNotEmpty() || specie.text.isNotEmpty() || gender.text.isNotEmpty()) {
                val photo = "https://rickandmortyapi.com/api/character/avatar/183.jpeg"
                val character = CharacterModel(52, name.text, status.text, specie.text, gender.text, photo, false)
                ButtonRegister(character)
            }
        }
    }

    @Composable
    private fun Space() = Spacer(
        modifier = Modifier.height(15.dp)
    )

    @Composable
    private fun GetText(string : String) {
        Text(
            text = string,
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = fonts,
            )
        )
    }

    /*@Composable
    private fun GetTextField(string: TextFieldValue) {
        TextField(
            value = string,
            onValueChange = { string = it },
            modifier = Modifier
                .alpha(0.8F)
                .background(Color.White),
            placeholder = { Text(text = "Name") }
        )
    }*/

    @Composable
    fun ButtonRegister(characterModel: CharacterModel) = Box(
        modifier = Modifier
            .padding(40.dp, 0.dp, 40.dp, 0.dp)) {
        Button(onClick = {
            onClicked(characterModel)
        },
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                text = "Add",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = fonts,
                    textDecoration = TextDecoration.None,
                    color = Color.White
                )
            )
        }
    }

    private fun onClicked(characterModel: CharacterModel) {
        Log.i("PUSHED", "PRESIONADO DESDE COMPOSE")
        viewModel.character.observe(viewLifecycleOwner){
        }
        viewModel.addNewCharacter(characterModel)
    }
}