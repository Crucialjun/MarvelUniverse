package com.pezesha.marveluniverse.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pezesha.marveluniverse.Resource
import com.pezesha.marveluniverse.adapters.CharactersListAdapter
import com.pezesha.marveluniverse.databinding.FragmentHomeBinding
import com.pezesha.marveluniverse.models.Character
import com.pezesha.marveluniverse.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(),CharactersListAdapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerview = binding.recyclerCharacters

        val recyclerAdapter = CharactersListAdapter(this)

        viewModel.characters.observe(viewLifecycleOwner) {
            Log.d("TAG", "onViewCreatedDta is ${it.data} ")
            recyclerAdapter.submitList(it.data)

            binding.progressBarCharactersFragment.isVisible =
                it is Resource.Loading && it.data.isNullOrEmpty()

        }

        binding.apply {
            recyclerview.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = recyclerAdapter


            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(character: Character) {
        val action = HomeFragmentDirections.actionHomeFragmentToCharacterDetailsFragment(character)
        findNavController().navigate(action)
    }

}