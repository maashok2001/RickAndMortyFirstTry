package com.example.composetest.apiService

import com.example.composetest.model.Pers
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20")
    suspend fun getCharacters() : List<Pers>

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://rickandmortyapi.com/api/character/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}