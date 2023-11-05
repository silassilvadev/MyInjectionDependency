package com.example.simplifyinjections.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class ContractResponse(
    @SerializedName("contract_id") val contractId: String
) : Parcelable
