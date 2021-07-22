package com.vti.rxjavawithretrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    companion object {
        var retrofit: Retrofit? = null
        var okHttpClient = OkHttpClient.Builder()
        var builder = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

         fun <T> createService(service: Class<T>): T = createService(service, null)

        private fun <T> createService(serviceClass: Class<T>, authToken: Map<String, String>?): T {
            authToken?.let {
                var interceptor = AuthenticationInterceptor(authToken)
                if (!okHttpClient.interceptors().contains(interceptor)) {
                    okHttpClient.addInterceptor(interceptor)
                    builder.client(okHttpClient.build())
                    retrofit = builder.build()

                }

            }
            retrofit = builder.build()
            return retrofit!!.create(serviceClass)
        }
    }

    class AuthenticationInterceptor(var authToken: Map<String, String>): Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original  = chain.request()
            val builder = original.newBuilder()
           for (key in authToken.keys ){
               builder.header(key, authToken.getValue(key))
           }
            val request = builder.build()
            return chain.proceed(request)
        }
    }
}