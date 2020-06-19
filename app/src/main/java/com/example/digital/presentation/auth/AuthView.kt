package com.example.digital.presentation.auth

import com.arellomobile.mvp.MvpView

interface AuthView : MvpView {
    fun registration()
    fun auth()
    fun showProgress()
    fun showError()
    fun showToast(text: String)
}