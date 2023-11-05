package com.example.myinjectiondependency.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class MainResponse(@SerializedName("contract_id") val contractId: String) : Parcelable
