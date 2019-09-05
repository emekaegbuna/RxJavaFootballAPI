package com.example.starwarsapi.presenter

import com.example.starwarsapi.model.StarWarsModel

interface ViewInterface {

    fun recycle(starWarsModel:StarWarsModel)

    fun throwError()
}