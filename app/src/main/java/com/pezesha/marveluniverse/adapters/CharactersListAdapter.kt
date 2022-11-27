package com.pezesha.marveluniverse.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.pezesha.marveluniverse.R
import com.pezesha.marveluniverse.databinding.CharacterItemBinding
import com.pezesha.marveluniverse.models.Character
import com.pezesha.marveluniverse.models.Extension

class CharactersListAdapter(private val listener : OnItemClickListener) :
    ListAdapter<Character,CharactersListAdapter.CharacterHolder>(
        CharacterCompare()
    ) {


    inner class CharacterHolder(private val  binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            Log.d("TAG", "Item Clicked")
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if(position != RecyclerView.NO_POSITION){
                    val item = getItem(position)
                    if(item != null){
                        listener.onItemClick(item)
                    }
                }

            }
        }

        fun bind(character: Character) {
            binding.apply {

                if(character.thumbnail?.extension == Extension.GIF){
                    Glide.with(itemView).setDefaultRequestOptions(
                        RequestOptions().placeholder(R.drawable.ic_baseline_home_24).error(
                            R.drawable.ic_baseline_home_24)).asGif()
                        .load("${character.thumbnail.path}.gif")
                        .transition(DrawableTransitionOptions.withCrossFade()).error(
                            R.drawable.ic_baseline_home_24
                        ).into(imgCharacterThumbnail)
                }else{
                    Glide.with(itemView).setDefaultRequestOptions(
                        RequestOptions().placeholder(R.drawable.ic_baseline_home_24).error(
                            R.drawable.ic_baseline_home_24))
                        .load("${character.thumbnail!!.path}.jpg")
                        .transition(DrawableTransitionOptions.withCrossFade()).error(
                            R.drawable.ic_baseline_home_24
                        ).into(imgCharacterThumbnail)
                }

                // Picasso.get().load("https://i.annihil.us/u/prod/marvel/i/mg/9/30/535feab462a64.jpg").resize(75,75).centerCrop().into(imgCharacterThumbnail)


                txtCharacterName.text = character.name
                txtCharacterDescription.text = character.description

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val binding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CharacterHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val currentCharacter = getItem(position)

        if (currentCharacter != null){
            holder.bind(currentCharacter)
        }
    }

    interface OnItemClickListener{
        fun onItemClick(character : Character)
    }

    class CharacterCompare : DiffUtil.ItemCallback<Character>(){

            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }

        }




}