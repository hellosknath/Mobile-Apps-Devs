package com.sriidea.udemyandroidlearning.data


import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val results: List<Artist>
)