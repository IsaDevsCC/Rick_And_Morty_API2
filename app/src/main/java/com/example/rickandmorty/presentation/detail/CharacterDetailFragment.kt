package com.example.rickandmorty.presentation.detail

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterDetailBinding
import com.example.rickandmorty.databinding.FragmentListCharactersBinding
import com.example.rickandmorty.domain.model.CharacterModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterDetailFragment : Fragment() {

    private val args : CharacterDetailFragmentArgs by navArgs()
    private val viewModel : CharacterDetailViewModel by viewModel()
    private lateinit var binding : FragmentCharacterDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.data.observe(viewLifecycleOwner) {
            getDetail(it)
        }

        viewModel.getDetail(args.characterId)
    }

    private fun getDetail(it: CharacterModel) = with(binding) {
        tvName.text = it.name
        tvStatus.text = it.status
        tvGenre.text = it.gender
        tvSpecie.text = it.specie

        Glide.with(root)
            .load(it.photo)
            .placeholder(R.drawable.ic_launcher_background)
            .into(ivPhoto)

    }

}