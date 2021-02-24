package com.mstf.basekotlinmvvm.ui.sample.dialog

import com.mstf.basekotlinmvvm.data.DataManager
import com.mstf.basekotlinmvvm.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleBottomSheetDialogViewModel @Inject constructor(dataManager: DataManager) :
  BaseViewModel<SampleBottomSheetDialogNavigator?>(dataManager) {

  fun onNavBackClick() {
    navigator?.goBack()
  }
}