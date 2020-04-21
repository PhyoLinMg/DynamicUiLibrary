package com.elemental.dynamicui.ViewData

data class UiCollection(
    val refDataType: String? = "",
    val refLabel: String? = "",
    val refName: String? = "",
    val refRequire: Boolean? = false,
    val refType: String? = "",
    var refValue: String? = "",
    val refValueArray: List<UiValueArray?>? = listOf()
) {
    data class UiValueArray(
        val id: Int? = 0,
        val name: String? = "",
        var isSelected: Boolean = false
    )
}