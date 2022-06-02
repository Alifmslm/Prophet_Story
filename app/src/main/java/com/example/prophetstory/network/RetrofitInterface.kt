package com.example.prophetstory.network

import com.example.prophetstory.model.ResponseItem
import com.example.prophetstory.model.ResponseRasulItem
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("v1/nabi")
    fun getDataNabi() : retrofit2.Call<List<ResponseItem>>

    @GET("v1/Rasul")
    fun getDataRasul() : retrofit2.Call<List<ResponseRasulItem>>

}