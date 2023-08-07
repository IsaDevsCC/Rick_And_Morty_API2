package com.example.rickandmorty.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.databinding.FragmentListCharactersBinding
import com.example.rickandmorty.domain.model.CharacterModel


class ListCharactersFragment : Fragment() {

    private lateinit var binding: FragmentListCharactersBinding
    private val viewModel : CharacterListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListCharactersBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.data.observe(viewLifecycleOwner){
            getStart(it)
        }

        viewModel.getData()
    }

    private fun getStart(it: List<CharacterModel>) = with(binding){
        rvFragmentCharacterList.adapter = ListCharactersAdapter(it)
    }

}