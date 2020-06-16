package com.example.digital.presentation.main

import com.arellomobile.mvp.MvpView

interface MainView : MvpView {
    fun showProgress()
    fun showError()
}