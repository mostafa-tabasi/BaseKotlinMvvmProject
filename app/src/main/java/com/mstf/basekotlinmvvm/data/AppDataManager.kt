package com.mstf.basekotlinmvvm.data

import android.content.Context
import com.google.gson.Gson
import com.mstf.basekotlinmvvm.data.local.db.DbHelper
import com.mstf.basekotlinmvvm.data.local.prefs.PreferencesHelper
import com.mstf.basekotlinmvvm.data.remote.ApiHeader
import com.mstf.basekotlinmvvm.data.remote.ApiHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(
    private val mContext: Context,
    private val dbHelper: DbHelper,
    private val preferencesHelper: PreferencesHelper,
    private val apiHelper: ApiHelper,
    private val gson: Gson
) : DataManager {

    override var currentUserId: String?
        get() = preferencesHelper.currentUserId
        set(value) {
            preferencesHelper.currentUserId = value
            getApiHeader().protectedApiHeader.userId = value!!
        }

    override var accessToken: String?
        get() = preferencesHelper.accessToken
        set(accessToken) {
            preferencesHelper.accessToken = accessToken
            getApiHeader().protectedApiHeader.accessToken = accessToken
        }

    override fun getApiHeader(): ApiHeader = apiHelper.getApiHeader()

    companion object {
        private const val TAG = "AppDataManager"
    }
}