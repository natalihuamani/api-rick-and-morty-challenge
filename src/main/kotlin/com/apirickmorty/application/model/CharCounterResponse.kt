package com.apirickmorty.application.model

data class CharCounterResponse(
    val exercise_name: String,
    val in_time: Boolean,
    val results: List<Result>,
    val time: String
)
