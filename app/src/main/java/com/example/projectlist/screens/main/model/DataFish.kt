package com.example.projectlist.screens.main.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

@Entity(tableName = "fish_table")
data class DataFish(
    @PrimaryKey
    var idPrimary: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "scientificName")
    @SerializedName("Scientific Name")
    var scientificName: String? = null,
    @ColumnInfo(name = "servingWeight")
    @SerializedName("Serving Weight")
    var servingWeight: String? = null,
    @ColumnInfo(name = "protein")
    @SerializedName("Protein")
    var protein: String? = null,
    @ColumnInfo(name = "selenium")
    @SerializedName("Selenium")
    var selenium: String? = null,
    @ColumnInfo(name = "specieName")
    @SerializedName("Species Name")
    var specieName: String? = null,
    @ColumnInfo(name = "texture")
    @SerializedName("Texture")
    var texture: String? = null,
    @ColumnInfo(name = "lastUpdate")
    @SerializedName("last_update")
    var lastUpdate: String? = null,
    @ColumnInfo(name = "biology")
    @SerializedName("Biology")
    var biology: String? = null,
    @ColumnInfo(name = "habitat")
    @SerializedName("Habitat")
    var habitat: String? = null,
    @ColumnInfo(name = "harvest")
    @SerializedName("Harvest")
    var harvest: String? = null,
    @ColumnInfo(name = "location")
    @SerializedName("Location")
    var location: String? = null,
    @ColumnInfo(name = "fishing Rate")
    @SerializedName("Fishing Rate")
    var fishingRate: String? = null,
    @Ignore
    @SerializedName("Species Illustration Photo")
    var imageList: SpeciesPhotoModel = SpeciesPhotoModel()
) : Serializable