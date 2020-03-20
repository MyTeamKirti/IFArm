package com.example.ifarm.utils

import android.content.Context
import android.content.SharedPreferences


object AppPreferences {
    private const val PREF_NAME = "xyz app"
    private const val MODE = Context.MODE_PRIVATE

    fun writeBoolean(context: Context, key: String, value: Boolean): Boolean {
        getEditor(context).putBoolean(key, value).commit()
        return value
    }

    fun readBoolean(context: Context, key: String, defValue: Boolean): Boolean {
        return getPreferences(context).getBoolean(key, defValue)
    }

    fun writeInteger(context: Context, key: String, value: Int) {
        getEditor(context).putInt(key, value).commit()
    }

    fun readInteger(context: Context, key: String, defValue: Int): Int {
        return getPreferences(context).getInt(key, defValue)
    }

    fun writeString(context: Context, key: String, value: String) {
        getEditor(context).putString(key, value).commit()
    }

    fun readString(context: Context, key: String, defValue: String): String? {
        return getPreferences(context).getString(key, defValue)
    }


    fun writeLong(context: Context, key: String, value: Long) {
        getEditor(context).putLong(key, value).commit()
    }

    fun readLong(context: Context, key: String, defValue: Long): Long {
        return getPreferences(context).getLong(key, defValue)
    }

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, MODE)
    }

    private fun getEditor(context: Context): SharedPreferences.Editor {
        return getPreferences(context).edit()
    }


}
