package com.mstf.basekotlinmvvm.data.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper @Inject constructor(private val mApiHeader: ApiHeader) : ApiHelper {

    override fun getApiHeader(): ApiHeader = mApiHeader
}