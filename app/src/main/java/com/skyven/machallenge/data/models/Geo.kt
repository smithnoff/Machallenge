package com.skyven.machallenge.data.models

import com.google.gson.annotations.SerializedName

data class Geo (
	@SerializedName("lat") val lat : Double,
	@SerializedName("lng") val lng : Double
)