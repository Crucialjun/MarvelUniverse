package com.pezesha.marveluniverse.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pezesha.marveluniverse.databinding.CharacterItemBinding

class CharactersListAdapter(private val data: List<com.pezesha.marveluniverse.models.Character>) :
    RecyclerView.Adapter<CharactersListAdapter.CharacterHolder>() {


    inner class CharacterHolder(var binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val binding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CharacterHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        with(holder) {
            with(data[position]) {
                binding.txtCharacterName.text = this.name
                binding.txtCharacterDescription.text = this.description
                Glide.with(itemView).load(this.thumbnail).into(binding.imgCharacterThumbnail)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}