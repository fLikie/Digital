package com.example.digital.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.digital.model.AuthInteractor
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val interactor: AuthInteractor,
    private val router: Router
) : MvpPresenter<MainView>() {

}