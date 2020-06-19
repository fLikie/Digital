package com.example.digital.presentation.auth

import com.arellomobile.mvp.MvpView

interface AuthView : MvpView {
    fun showProgress(show: Boolean)
    fun showError()
    fun showToast(text: String)
}