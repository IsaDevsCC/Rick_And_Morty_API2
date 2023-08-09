package com.example.rickandmorty.presentation.list.all

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentListCharactersBinding
import com.example.rickandmorty.domain.model.CharacterModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListCharactersFragment : Fragment() {

    private lateinit var binding: FragmentListCharactersBinding

    //private val viewModel : CharacterListViewModel = CharacterListViewModel(GetCharacterListUseCase())
    private val viewModel: CharacterListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        addListeners()
        addNavigationButton()
    }

    private fun addNavigationButton() = with(binding) {
        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.favs -> {
                    Log.i("NAV", it.toString())
                    findNavController().navigate(
                        ListCharactersFragmentDirections.actionListCharactersFragmentToFavsListFragmentCompose()
                    )
                    true
                }
                R.id.add -> {
                    Log.i("ADD", it.toString())
                    true
                }
                R.id.reset -> {
                    Log.i("RESET", it.toString())
                    resetAllList()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun resetAllList() {
        viewModel.data.observe(viewLifecycleOwner){
            addListeners()
        }
        viewModel.getReset()
    }

    private fun addListeners() = with(binding) {
        etSearch.addTextChangedListener {
            viewModel.data.observe(viewLifecycleOwner) {
                getByNames(it)
            }
            viewModel.getData(etSearch.text.toString())
        }
    }

    private fun getByNames(list: List<CharacterModel>) = with(binding) {
        rvFragmentCharacterList.adapter = ListCharactersAdapter(
            list = list,
            clicked = { value ->
            findNavController().navigate(
                ListCharactersFragmentDirections.actionListCharactersFragmentToCharacterDetailFragment(
                    value.id
                )
            )
        },
        onDelete = { value ->
            viewModel.delete.observe(viewLifecycleOwner){}
            viewModel.deleteData(value.id)
        })
    }
}