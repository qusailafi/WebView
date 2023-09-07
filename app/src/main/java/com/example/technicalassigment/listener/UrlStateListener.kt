package com.example.technicalassigment.listener

interface UrlStateListener {
    fun onUrlLoading()
    fun onUrlLoaded(newUrlLoaded: String)

}