package com.regi.awe.repo

import com.regi.awe.model.Pic
import com.regi.awe.service.PicsumApiService
import io.reactivex.Observable

class PicRepository(val picService : PicsumApiService){
    fun getPics(): Observable<List<Pic>>{
        return picService.getPicList()
    }
}