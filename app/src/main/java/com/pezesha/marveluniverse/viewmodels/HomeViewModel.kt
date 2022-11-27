package com.pezesha.marveluniverse.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pezesha.marveluniverse.repo.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: MarvelRepository) : ViewModel() {

//    private val charactersLiveData = MutableLiveData<ApiResponse>()
//    val characters: LiveData<ApiResponse> = charactersLiveData
//
//    init {
//        viewModelScope.launch {
//            val characters = api.loadCharacters()
//
//            charactersLiveData.value = characters
//        }
//    }


    val characters = repository.getCharacters().asLiveData()



}