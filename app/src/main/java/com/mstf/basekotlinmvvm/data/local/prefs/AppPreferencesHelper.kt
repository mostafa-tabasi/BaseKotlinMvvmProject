package com.mstf.basekotlinmvvm.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.mstf.basekotlinmvvm.di.annotation.PreferenceInfo
import javax.inject.Inject

class AppPreferencesHelper @Inject constructor(
    context: Context,
    @PreferenceInfo prefFileName: String?
) : PreferencesHelper {

    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override var currentUserId: String?
        get() = mPrefs.getString(PREF_KEY_CURRENT_USER_ID, null)
        set(value) {
            mPrefs.edit().putString(PREF_KEY_CURRENT_USER_ID, value).apply()
        }

    override var accessToken: String?
        get() = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null)
        set(value) {
            mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, value).apply()
        }

    companion object {
        private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }
}