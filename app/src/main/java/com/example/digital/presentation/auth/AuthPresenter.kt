package com.example.digital.presentation.auth

import android.content.SharedPreferences
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.digital.Screens
import com.example.digital.model.AuthInteractor
import com.example.digital.model.entity.ServerResponse
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class AuthPresenter @Inject constructor(
    private val interactor: AuthInteractor,
    private val router: Router,
    private val preferences: SharedPreferences
) : MvpPresenter<AuthView>() {

    private var disposable: Disposable? = null

    fun login(login: String, password: String) {
        disposable = interactor.login(login, password)
            .doOnSubscribe { viewState.showProgress(true) }
            .doFinally { viewState.showProgress(false) }
            .subscribe(
                {
                checkResponse(it)
            }, {
                    Timber.e(it)
                    viewState.showToast(it.toString())
            })
    }

    private fun checkResponse(response: ServerResponse) {
        if (response.api_token.isNotEmpty()) {
            saveToken(response.api_token)
            router.navigateTo(Screens.MainScreen)
        }
    }

    private fun saveToken(token: String) {
        preferences.edit().putString("TOKEN", token).apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}