package com.vti.rxjavawithretrofit

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("android/jsonarray/")
    fun getAndroidVersion(): Observable<List<AndroidVersion>>
}