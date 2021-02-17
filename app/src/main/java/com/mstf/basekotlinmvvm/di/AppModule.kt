package com.mstf.basekotlinmvvm.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mstf.basekotlinmvvm.BuildConfig
import com.mstf.basekotlinmvvm.data.AppDataManager
import com.mstf.basekotlinmvvm.data.DataManager
import com.mstf.basekotlinmvvm.data.local.db.AppDatabase
import com.mstf.basekotlinmvvm.data.local.db.AppDbHelper
import com.mstf.basekotlinmvvm.data.local.db.DbHelper
import com.mstf.basekotlinmvvm.data.local.prefs.AppPreferencesHelper
import com.mstf.basekotlinmvvm.data.local.prefs.PreferencesHelper
import com.mstf.basekotlinmvvm.data.remote.ApiHeader.ProtectedApiHeader
import com.mstf.basekotlinmvvm.data.remote.ApiHelper
import com.mstf.basekotlinmvvm.data.remote.AppApiHelper
import com.mstf.basekotlinmvvm.di.annotation.ApiInfo
import com.mstf.basekotlinmvvm.di.annotation.DatabaseInfo
import com.mstf.basekotlinmvvm.di.annotation.PreferenceInfo
import com.mstf.basekotlinmvvm.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @ApiInfo
    fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @Singleton
    fun provideAppDatabase(
        @DatabaseInfo dbName: String,
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()   //TODO: migrations
            .build()

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String = AppConstants.DB_NAME

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper = appDbHelper

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper =
        appPreferencesHelper

    @Provides
    @Singleton
    fun provideProtectedApiHeader(
        @ApiInfo apiKey: String,
        preferencesHelper: PreferencesHelper
    ): ProtectedApiHeader = ProtectedApiHeader(
        apiKey,
        preferencesHelper.currentUserId,
        preferencesHelper.accessToken
    )
}