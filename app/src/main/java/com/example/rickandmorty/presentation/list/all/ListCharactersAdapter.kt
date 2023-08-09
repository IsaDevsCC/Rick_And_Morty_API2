package com.example.rickandmorty.presentation.list.all

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.CellViewBinding
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.presentation.list.all.CellViewHolder

class ListCharactersAdapter(
    private val list : List<CharacterModel>,
    private val clicked : (CharacterModel) -> Unit,
    private val onDelete : (CharacterModel) -> Unit,
) : RecyclerView.Adapter<CellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        return CellViewHolder(
            CellViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) { holder.getCell(list[position], clicked, onDelete) }

    override fun getItemCount(): Int = list.size
}