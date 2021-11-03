package com.example.projectlist.screens.main.model

import com.google.gson.annotations.SerializedName

data class SpeciesPhotoModel(

    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("src")
    val src: String = ""
)