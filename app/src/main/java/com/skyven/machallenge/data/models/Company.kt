package com.skyven.machallenge.data.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "company_table")
data class Company (
	@SerializedName("name") val name : String,
	@SerializedName("catchPhrase") val catchPhrase : String,
	@SerializedName("bs") val bs : String
)