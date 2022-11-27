package com.pezesha.marveluniverse.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.pezesha.marveluniverse.R
import com.pezesha.marveluniverse.databinding.CharacterItemBinding
import com.pezesha.marveluniverse.models.Character

class CharactersPagingDataAdapter :
    PagingDataAdapter<Character, CharactersPagingDataAdapter.CharacterViewHolder>(
        diffCallback = object :
            DiffUtil.ItemCallback<Character>() {
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

        fun bind(character: Character) {
            binding.apply {

                Glide.with(itemView).setDefaultRequestOptions(RequestOptions().placeholder(R.drawable.ic_baseline_home_24).error(R.drawable.ic_baseline_home_24))
                    .load("${character.thumbnail!!.path}.jpg").centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade()).error(
                    R.drawable.ic_baseline_home_24
                ).into(imgCharacterThumbnail)
               // Picasso.get().load("https://i.annihil.us/u/prod/marvel/i/mg/9/30/535feab462a64.jpg").resize(75,75).centerCrop().into(imgCharacterThumbnail)


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