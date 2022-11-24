package com.pezesha.marveluniverse.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pezesha.marveluniverse.adapters.CharactersListAdapter
import com.pezesha.marveluniverse.databinding.FragmentHomeBinding
import com.pezesha.marveluniverse.models.Character
import com.pezesha.marveluniverse.models.Thumbnail
import com.pezesha.marveluniverse.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()
    




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val recyclerview = binding.recyclerCharacters

        viewModel.characters.observe(viewLifecycleOwner){

        }
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