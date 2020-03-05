package com.example.ifarm.model

data class CartModel(
    val result: List<ChatResult>
)

data class CartResult(
    val _id: String,
    val productName:String,
    val sellerName:String,
    val quantity:String,
    val price:String,
    val image:Int,
    val orderDate:String,
    val orderTime:String
)