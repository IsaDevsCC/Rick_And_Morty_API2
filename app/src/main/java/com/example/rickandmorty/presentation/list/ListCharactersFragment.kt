package com.example.rickandmorty.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.findNavController
import com.example.rickandmorty.databinding.FragmentListCharactersBinding
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.GetCharacterListUseCase
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListCharactersFragment : Fragment() {

    private lateinit var binding: FragmentListCharactersBinding
    //private val viewModel : CharacterListViewModel = CharacterListViewModel(GetCharacterListUseCase())
    private val viewModel : CharacterListViewModel by viewModel()

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
        rvFragmentCharacterList.adapter = ListCharactersAdapter(it) {
            findNavController().navigate(
                ListCharactersFragmentDirections.actionListCharactersFragmentToCharacterDetailFragment(it.id)
            )
        }
    }

}