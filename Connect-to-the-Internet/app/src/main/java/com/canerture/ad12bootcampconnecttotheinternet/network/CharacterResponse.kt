package com.canerture.ad12bootcampconnecttotheinternet.network

import com.squareup.moshi.Json

data class CharacterResponse (
    @Json(name = "harrypotter") var characters: List<CharacterModel>,
    var success: Int
)