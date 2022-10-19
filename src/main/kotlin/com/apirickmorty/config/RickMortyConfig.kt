package com.apirickmorty.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "rick-morty-config")
@ConstructorBinding
data class RickMortyConfig (
    val letters: String,
    val numberLocations: Int
)


