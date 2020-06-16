package com.example.digital

import androidx.fragment.app.Fragment
import com.example.digital.ui.AuthFragment
import com.example.digital.ui.MainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object MainScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = MainFragment()
    }

    object AuthScreen: SupportAppScreen() {
        override fun getFragment(): Fragment = AuthFragment()
    }
}