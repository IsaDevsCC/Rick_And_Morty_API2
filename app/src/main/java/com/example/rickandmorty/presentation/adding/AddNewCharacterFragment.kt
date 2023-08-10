package com.example.rickandmorty.presentation.adding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout.Spec
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.databinding.FragmentAddNewCharacterBinding
import com.example.rickandmorty.presentation.login.LoginFragmentComposeDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNewCharacterFragment : Fragment() {

    private lateinit var binding : FragmentAddNewCharacterBinding
    private val viewModel : AddNewCharacterViewModel by viewModel()
    
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
            ButtonRegister()
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
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Monospace)
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
    fun ButtonRegister() = Box(
        modifier = Modifier
            .padding(40.dp, 0.dp, 40.dp, 0.dp)) {
        Button(onClick = {
            onClicked()
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
                    fontFamily = FontFamily.Monospace,
                    textDecoration = TextDecoration.None,
                    color = Color.White
                )
            )
        }
    }

    private fun onClicked() {
        findNavController().navigate(
            LoginFragmentComposeDirections.actionLoginFragmentComposeToListCharactersFragment()
        )
    }
}