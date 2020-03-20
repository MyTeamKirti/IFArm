package com.example.ifarm.model

data class FilterOption(
    val result: ArrayList<FilterOptionResult>,
    val status: Boolean
)

data class FilterOptionResult(
    val `data`: ArrayList<FilterOptionData>,
    val type: Int
)

data class FilterOptionData(
    val id: String,
    val name: String,
    var isChecked:Boolean
)