package com.pezesha.marveluniverse.viewmodels

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.pezesha.marveluniverse.api.ApiResponse
import com.pezesha.marveluniverse.api.MarvelApi
import com.pezesha.marveluniverse.repo.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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