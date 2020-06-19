package com.example.digital.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.digital.R
import com.example.digital.di.Scopes
import com.example.digital.presentation.auth.AuthPresenter
import com.example.digital.presentation.auth.AuthView
import toothpick.Toothpick

class AuthFragment : MvpAppCompatFragment(), AuthView {
    private val currentTabFragment: MvpAppCompatFragment?
        get() = childFragmentManager.fragments.firstOrNull { !it.isHidden } as? MvpAppCompatFragment

    @InjectPresenter
    lateinit var presenter: AuthPresenter

    @ProvidePresenter
    fun providePresenter() = Toothpick.openScopes(Scopes.SERVER_SCOPE, "auth scope")
        .getInstance(AuthPresenter::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.auth_fragment_layout, container, false)

    override fun registration() {

    }

    override fun auth() {

    }

    override fun showProgress() {

    }

    override fun showError() {

    }

}