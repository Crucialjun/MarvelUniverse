package com.pezesha.marveluniverse.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pezesha.marveluniverse.adapters.CharactersListAdapter
import com.pezesha.marveluniverse.databinding.FragmentHomeBinding
import com.pezesha.marveluniverse.models.Character
import com.pezesha.marveluniverse.models.Thumbnail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val characters: ArrayList<com.pezesha.marveluniverse.models.Character> =
        ArrayList<com.pezesha.marveluniverse.models.Character>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val recyclerview = binding.recyclerCharacters
        characters.add(
            Character(
                "This is one", "This is one description", null, null, null,
                Thumbnail(
                    "https://i.picsum.photos/id/239/200/300.jpg?hmac=jBV5mUiY1RXDAmu4rQXOdWeutyztlxqFSOVpnJ-QUb8",
                    null
                )
            )
        )
        characters.add(Character("This is one", "This is one description", null, null, null, null))
        characters.add(Character("This is one", "This is one description", null, null, null, null))
        characters.add(Character("This is one", "This is one description", null, null, null, null))
        recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CharactersListAdapter(characters)

        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}