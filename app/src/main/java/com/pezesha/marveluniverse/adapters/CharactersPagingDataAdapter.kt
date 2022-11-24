package com.pezesha.marveluniverse.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.pezesha.marveluniverse.R
import com.pezesha.marveluniverse.databinding.CharacterItemBinding
import com.pezesha.marveluniverse.models.Character

class CharactersPagingDataAdapter :
    PagingDataAdapter<com.pezesha.marveluniverse.models.Character, CharactersPagingDataAdapter.CharacterViewHolder>(
        diffCallback = object :
            DiffUtil.ItemCallback<com.pezesha.marveluniverse.models.Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }

        }
    ) {
    inner class CharacterViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: com.pezesha.marveluniverse.models.Character) {
            binding.apply {
                Glide.with(itemView)
                    .load(character.thumbnail?.path ?: "https://picsum.photos/200/300").centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade()).error(
                    R.drawable.ic_baseline_home_24
                ).into(imgCharacterThumbnail)
                txtCharacterName.text = character.name
                txtCharacterDescription.text = character.description

            }
        }

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentCharacter = getItem(position)

        if (currentCharacter != null){
            holder.bind(currentCharacter)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CharacterViewHolder(binding)
    }


}