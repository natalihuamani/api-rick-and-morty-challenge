package com.apirickmorty

import com.apirickmorty.config.RickMortyConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(RickMortyConfig::class)
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
