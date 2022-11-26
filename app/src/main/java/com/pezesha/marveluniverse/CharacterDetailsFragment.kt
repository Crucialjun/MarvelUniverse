package com.pezesha.marveluniverse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.pezesha.marveluniverse.databinding.FragmentCharacterDetailsBinding
import com.pezesha.marveluniverse.models.Extension


class CharacterDetailsFragment : Fragment() {

    private var _binding : FragmentCharacterDetailsBinding? = null

    private val binding get() = _binding!!

    private val args by navArgs<CharacterDetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater,container,false)

        binding.textView3.text = args.character.name


        if(args.character.description.isEmpty()){
            binding.txtDescription.text = "No description"
        }else{
            binding.txtDescription.text = args.character.description
        }


        var comicListitems = ArrayList<String>()

        for (item in args.character.comics!!.items){
            comicListitems.add(item.name)
        }

        val comicsArrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,
            comicListitems
        )

        var seriesListitems = ArrayList<String>()

        for (item in args.character.series!!.items){
            seriesListitems.add(item.name)
        }

        val seriesArrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,
            seriesListitems
        )

        var storiesListitems = ArrayList<String>()

        for (item in args.character.stories!!.items){
            storiesListitems.add(item.name)
        }

        val storiesArrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,
            storiesListitems
        )



        binding.comicsListView.adapter = comicsArrayAdapter

        binding.seriesListView.adapter = seriesArrayAdapter

        binding.storiesListView.adapter = storiesArrayAdapter

        if(args.character.thumbnail?.extension == Extension.GIF){
            Glide.with(requireContext()).setDefaultRequestOptions(
                RequestOptions().placeholder(R.drawable.ic_baseline_home_24).error(
                    R.drawable.ic_baseline_home_24)).asGif()
                .load("${args.character.thumbnail!!.path}.gif")
                .transition(DrawableTransitionOptions.withCrossFade()).error(
                    R.drawable.ic_baseline_home_24
                ).into(binding.imageView)
        }else{
            Glide.with(requireContext()).setDefaultRequestOptions(
                RequestOptions().placeholder(R.drawable.ic_baseline_home_24).error(
                    R.drawable.ic_baseline_home_24))
                .load("${args.character.thumbnail!!.path}.jpg")
                .transition(DrawableTransitionOptions.withCrossFade()).error(
                    R.drawable.ic_baseline_home_24
                ).into(binding.imageView)
        }
        return  binding.root
    }


}