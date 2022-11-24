package com.pezesha.marveluniverse.viewmodels

import androidx.lifecycle.ViewModel
import com.pezesha.marveluniverse.repo.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MarvelRepository) : ViewModel() {
}