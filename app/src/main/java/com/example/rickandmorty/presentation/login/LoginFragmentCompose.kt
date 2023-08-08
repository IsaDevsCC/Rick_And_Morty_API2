package com.example.rickandmorty.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentLoginComposeBinding


class LoginFragmentCompose : Fragment() {

    lateinit var binding : FragmentLoginComposeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginComposeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cvContainerLogin.setContent {
            MakeCompose()
        }
    }

    @Composable
    private fun MakeCompose() {
        Text("Hola")
    }

}