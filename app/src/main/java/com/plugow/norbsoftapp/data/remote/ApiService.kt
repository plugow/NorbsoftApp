package com.plugow.norbsoftapp.data.remote

import com.plugow.norbsoftapp.data.local.YTSearchList
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("channels.json")
    fun getYTSearchList(): Single<YTSearchList>


}