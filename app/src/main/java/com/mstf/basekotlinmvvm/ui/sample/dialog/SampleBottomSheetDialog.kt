package com.mstf.basekotlinmvvm.ui.sample.dialog

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.mstf.basekotlinmvvm.BR
import com.mstf.basekotlinmvvm.R
import com.mstf.basekotlinmvvm.databinding.DialogBottomSheetSampleBinding
import com.mstf.basekotlinmvvm.ui.base.BaseBottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleBottomSheetDialog :
    BaseBottomSheetDialog<DialogBottomSheetSampleBinding, SampleBottomSheetDialogViewModel>(),
    SampleBottomSheetDialogNavigator {

    override val viewModel: SampleBottomSheetDialogViewModel by viewModels()
    override val bindingVariable: Int get() = BR.viewModel
    override val layoutId: Int get() = R.layout.dialog_bottom_sheet_sample

    companion object {
        const val TAG = "SampleBottomSheetDialog"
        fun newInstance(): SampleBottomSheetDialog {
            val args = Bundle()
            val fragment = SampleBottomSheetDialog()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
    }

    override fun goBack() {
    }
}