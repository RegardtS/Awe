package com.regi.awe.service

import com.regi.awe.constants.URLConstants
import com.regi.awe.model.Pic
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PicsumApiService{

    @GET("/list")
    fun getPicList(): Observable<List<Pic>>

    companion object Factory{
        fun create(): PicsumApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(URLConstants.PICSUM_URL)
                    .build()
            return retrofit.create(PicsumApiService::class.java)
        }
    }
}