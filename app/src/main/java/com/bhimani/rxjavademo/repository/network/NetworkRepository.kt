package com.bhimani.rxjavademo.repository.network

import com.bhimani.rxjavademo.model.UserResponse
import com.bhimani.rxjavademo.utils.Constants.RANDOM_USER_URL
import io.reactivex.Observable

class NetworkRepository(private val userApi: ApiServices) {

    fun fetchUsers(): Observable<UserResponse?>?
    {
        return userApi.fetchUsers(RANDOM_USER_URL)
    }
}