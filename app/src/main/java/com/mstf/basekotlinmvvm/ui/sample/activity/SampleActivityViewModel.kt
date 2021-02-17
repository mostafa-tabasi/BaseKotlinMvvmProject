package com.mstf.basekotlinmvvm.ui.sample.activity

import com.mstf.basekotlinmvvm.data.DataManager
import com.mstf.basekotlinmvvm.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleActivityViewModel @Inject constructor(dataManager: DataManager) :
    BaseViewModel<SampleActivityNavigator>(dataManager) {
}