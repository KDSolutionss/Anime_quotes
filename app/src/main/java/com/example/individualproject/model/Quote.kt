package com.example.individualproject.model

import com.squareup.moshi.Json

data class Quote(@Json(name = "anime")val anime:String,
                 @Json(name = "character")val character:String,
                 @Json(name ="quote")val quote:String)
