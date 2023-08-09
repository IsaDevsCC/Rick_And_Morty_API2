package com.example.rickandmorty.presentation.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
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
        addListeners()
    }

    private fun addListeners() = with(binding) {
        etSearch.addTextChangedListener {
            viewModel.data.observe(viewLifecycleOwner) {
                getByNames(it)
            }
            viewModel.getData(etSearch.text.toString())
        }
    }

    private fun getByNames(it: List<CharacterModel>) = with(binding){
        rvFragmentCharacterList.adapter = ListCharactersAdapter(it){
            findNavController().navigate(
                ListCharactersFragmentDirections.actionListCharactersFragmentToCharacterDetailFragment(it.id)
            )
        }
    }
}