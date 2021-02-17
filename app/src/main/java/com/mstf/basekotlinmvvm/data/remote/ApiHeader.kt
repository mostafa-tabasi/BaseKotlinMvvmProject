package com.mstf.basekotlinmvvm.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mstf.basekotlinmvvm.di.annotation.ApiInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHeader @Inject constructor(
    val publicApiHeader: PublicApiHeader,
    val protectedApiHeader: ProtectedApiHeader
) {

    class ProtectedApiHeader(
        @SerializedName("api_key") @Expose var apiKey: String?,
        @SerializedName("user_id") @Expose var userId: String?,
        @SerializedName("access_token") @Expose var accessToken: String?
    )

    class PublicApiHeader @Inject constructor(@SerializedName("api_key") @Expose @ApiInfo var apiKey: String)
}