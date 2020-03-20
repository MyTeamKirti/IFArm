package com.example.ifarm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class HomeViewModel(
    val result: PostsResult,
    val status: Boolean
)

data class PostsResult(
    val postData: List<PostData>
)

data class PostData(
    val productList1: ArrayList<ProductData1>,
//    val productList2: ArrayList<ProductData1>,
//    val productList3: ArrayList<ProductData1>,
    val card_type: Int,
    val categoryName:String
)

data class ProductData1(
    val id: String,
    val name:String,
    val imageURL: Int,
    val quantity:String,
    val price:String
)
