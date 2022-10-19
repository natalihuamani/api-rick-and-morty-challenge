package com.apirickmorty.application.controller

import com.apirickmorty.domain.usecase.RickAndMortyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rick-morty-api")
class RickMortyController (
    private val rickAndMortyService: RickAndMortyService
) {

    @GetMapping("/chars-counter")
    fun getCharCounter(): String {
       return rickAndMortyService.getLocations()
    }

}
