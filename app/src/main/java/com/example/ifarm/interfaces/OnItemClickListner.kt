package com.example.ifarm.interfaces

interface OnItemClickListner {
    fun onButtonMainClick( activity_name:String)
    fun onDataClick(text:String,pos:Int,key_text:String)
}