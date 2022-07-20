package com.bhimani.rxjavademo.repository.network

import com.bhimani.rxjavademo.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiServices {
    @GET
    fun fetchUsers(@Url url: String?): Observable<UserResponse?>?
}