package com.apirickmorty.domain.usecase

import com.apirickmorty.config.RickMortyConfig
import com.apirickmorty.domain.LocationName
import com.apirickmorty.infrastructure.RickMortyClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import kotlin.random.Random

@Component
class RickAndMortyService(
    private val rickMortyClient: RickMortyClient,
    private val rickMortyConfig: RickMortyConfig
) {

    private val logger = LoggerFactory.getLogger(RickMortyConfig::class.java)

    fun getLocations(): String {
        val listNumber = List(rickMortyConfig.numberLocations) { Random.nextInt() }.toString()
        logger.info("listNumber: $listNumber")
        logger.info("Get locations with letter: ${rickMortyConfig.letters}")
        return getCharCounter(rickMortyClient.getLocations(listNumber), rickMortyConfig.letters).toString()
    }

    fun getCharCounter(locationsNames: List<LocationName>, letter: String): Int {
        return getOccurrences(locationsNames, letter)
            .sumOf { it }
    }

    fun getOccurrences(locationsNames: List<LocationName>, letter: String): List<Int> {
        val listOccurrencesWithUpperCase = locationsNames.map { StringUtils.countOccurrencesOf(it.name, letter.uppercase()) }
        val listOccurrencesWithLowerCase = locationsNames.map { StringUtils.countOccurrencesOf(it.name, letter.lowercase()) }
        return listOccurrencesWithLowerCase.plus(listOccurrencesWithUpperCase)
    }
}
