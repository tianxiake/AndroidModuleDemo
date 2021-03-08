package com.snail.common

import android.util.Log

object HiLogger {
    
    @JvmStatic
    fun d(tag: String, message: String) {
        Log.d(tag, message)
    }

    @JvmStatic
    fun d(tag: String, message: String, throwable: Throwable) {
        Log.d(tag, message, throwable)
    }

    @JvmStatic
    fun i(tag: String, message: String) {
        Log.i(tag, message)
    }

    @JvmStatic
    fun i(tag: String, message: String, throwable: Throwable) {
        Log.i(tag, message, throwable)
    }

    @JvmStatic
    fun w(tag: String, message: String, throwable: Throwable) {
        Log.w(tag, message, throwable)
    }

    @JvmStatic
    fun e(tag: String, message: String, throwable: Throwable) {
        Log.e(tag, message, throwable)
    }

    @JvmStatic
    fun e(tag: String, message: String) {
        Log.e(tag, message)
    }
}