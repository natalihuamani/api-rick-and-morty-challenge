package com.apirickmorty.infrastructure
import com.apirickmorty.domain.LocationName
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(
    value = "RickyAndMortyApi",
    url = "https://rickandmortyapi.com/api"
)
interface RickMortyClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["/location/{ids}"])
    fun getLocations(@PathVariable("ids")ids: String) : List<LocationName>
}
