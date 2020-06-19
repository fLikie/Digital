package com.example.digital.presentation.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.digital.model.AuthInteractor
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class AuthPresenter @Inject constructor(
    private val interactor: AuthInteractor,
    private val router: Router
) : MvpPresenter<AuthView>() {

    private val disposable: Disposable? = null

    fun login(login: String, password: String) {

    }
}