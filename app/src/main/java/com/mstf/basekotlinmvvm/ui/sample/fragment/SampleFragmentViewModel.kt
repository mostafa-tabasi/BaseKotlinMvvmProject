package com.mstf.basekotlinmvvm.ui.sample.fragment

import com.mstf.basekotlinmvvm.data.DataManager
import com.mstf.basekotlinmvvm.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleFragmentViewModel @Inject constructor(dataManager: DataManager) :
    BaseViewModel<SampleFragmentNavigator?>(dataManager) {

    fun onNavBackClick() {
        navigator?.goBack()
    }
}