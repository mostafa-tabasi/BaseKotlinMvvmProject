package com.mstf.basekotlinmvvm.data

import com.mstf.basekotlinmvvm.data.local.db.DbHelper
import com.mstf.basekotlinmvvm.data.local.prefs.PreferencesHelper
import com.mstf.basekotlinmvvm.data.remote.ApiHelper

interface DataManager : DbHelper, PreferencesHelper, ApiHelper {
}