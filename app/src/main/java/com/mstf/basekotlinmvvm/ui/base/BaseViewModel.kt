package com.mstf.basekotlinmvvm.ui.base

import androidx.lifecycle.ViewModel
import com.mstf.basekotlinmvvm.data.DataManager
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(val dataManager: DataManager) : ViewModel() {

    private var mNavigator: WeakReference<N>? = null

    val navigator: N? get() = mNavigator!!.get()

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }
}