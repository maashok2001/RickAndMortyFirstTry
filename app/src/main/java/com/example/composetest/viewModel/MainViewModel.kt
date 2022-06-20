package com.example.composetest.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetest.apiService.ApiService
import com.example.composetest.model.Pers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var charactersListResponse: List<Pers> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getCharactersList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val characterList = apiService.getCharacters()
                charactersListResponse = characterList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}
