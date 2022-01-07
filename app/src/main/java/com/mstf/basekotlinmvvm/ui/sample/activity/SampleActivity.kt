package com.mstf.basekotlinmvvm.ui.sample.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.mstf.basekotlinmvvm.BR
import com.mstf.basekotlinmvvm.R
import com.mstf.basekotlinmvvm.databinding.ActivitySampleBinding
import com.mstf.basekotlinmvvm.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleActivity : BaseActivity<ActivitySampleBinding, SampleActivityViewModel>(),
    SampleActivityNavigator {

    override val viewModel: SampleActivityViewModel by viewModels()
    override val bindingVariable: Int get() = BR.viewModel
    override val layoutId: Int get() = R.layout.activity_sample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.sample_nav_host_fragment) as NavHostFragment
    }

    companion object {
        private const val TAG = "SampleActivity"
        fun newIntent(context: Context) = Intent(context, SampleActivity::class.java)
    }
}