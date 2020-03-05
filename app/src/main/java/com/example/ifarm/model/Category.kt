package com.example.ifarm.model

data class Category(
    val result: ArrayList<CategoryResult>,
    val status: Boolean
)

data class CategoryResult(
    val _id: String,
    var categoryName: String
)