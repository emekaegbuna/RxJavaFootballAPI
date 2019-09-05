package com.example.starwarsapi.network

import com.example.starwarsapi.model.StarWarsModel
import io.reactivex.Observable
import retrofit2.http.GET

interface StarWarsInterface {

    @GET("people")
    fun getStarWars(): Observable<StarWarsModel>
}