package com.example.ifarm.model

data class SubscriptionModel(
    val result: ArrayList<SubscriptionResult>,
    val status: Boolean
)

data class SubscriptionResult(
    val _id: String,
    var subscriptionPlan: String,
    var price:String,
    var isSelectedInterest:Boolean
)