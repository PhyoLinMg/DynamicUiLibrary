package com.elemental.dynamicui.ViewData


import com.google.gson.annotations.SerializedName

data class UiCollectionList(
    @SerializedName("UiCollection")
    val uiCollection: List<UiCollection>
) {
    data class UiCollection(
        @SerializedName("refDataType")
        var refDataType: String?="",
        @SerializedName("refLabel")
        var refLabel: String?="",
        @SerializedName("refName")
        var refName: String?="",
        @SerializedName("refRequire")
        var refRequire: Boolean?=false,
        @SerializedName("refType")
        var refType: String?="",
        @SerializedName("refValue")
        var refValue: String?=""
    )
}