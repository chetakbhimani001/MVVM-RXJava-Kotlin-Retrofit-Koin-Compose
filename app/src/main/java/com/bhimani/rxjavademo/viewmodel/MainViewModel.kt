package com.bhimani.rxjavademo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bhimani.rxjavademo.model.UserResponse
import com.bhimani.rxjavademo.repository.network.NetworkRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repository: NetworkRepository) : ViewModel() {

    val user = MutableLiveData<UserResponse>()
    val errorMessage = MutableLiveData<String>()
    lateinit var disposable: Disposable

    fun getAllMovies() {
        //observer subscribing to observable
        val response = repository.fetchUsers()
        response?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(getUserObserver())
    }

    private fun getUserObserver(): Observer<UserResponse?> {
        return object : Observer<UserResponse?> {
            override fun onComplete() {
                //hide progress indicator .
            }

            override fun onError(e: Throwable) {
                user.postValue(null)
            }

            override fun onNext(t: UserResponse) {
                user.postValue(t)
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
                //start showing progress indicator.
            }
        }
    }
}