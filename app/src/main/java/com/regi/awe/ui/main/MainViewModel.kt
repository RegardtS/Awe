package com.regi.awe.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.regi.awe.model.Pic
import com.regi.awe.repo.PicRepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private val picList = MutableLiveData<List<Pic>>()
    private val errorString = MutableLiveData<String>()

    fun initLoad(){
        val repository = PicRepositoryProvider.providePicRepository()
        repository.getPics()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result -> picList.value = result },
                        { error -> errorString.value = error.localizedMessage })
    }

    fun picList(): LiveData<List<Pic>> = picList
    fun error(): LiveData<String> = errorString

}