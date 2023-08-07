package com.example.rickandmorty.presentation.list

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.CellViewBinding
import com.example.rickandmorty.domain.model.CharacterModel

class CellViewHolder(
    private val cellview : CellViewBinding
) : RecyclerView.ViewHolder(cellview.root) {

    fun getCell(characterModel: CharacterModel, clicked: (CharacterModel) -> Unit) = with(cellview){
        tvName.text = characterModel.name
        tvStatus.text = characterModel.status
        tvGenre.text = characterModel.gender
        tvSpecie.text = characterModel.specie

        Glide.with(root)
            .load(characterModel.photo)
            .placeholder(R.drawable.ic_launcher_background)
            .into(ivPhoto)

        root.setOnClickListener {
            Log.i("CLICKED", "${characterModel.name} was clicked")
            clicked(characterModel)
        }
    }


}