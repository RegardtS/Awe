package com.regi.awe.repo

import com.regi.awe.service.PicsumApiService

object PicRepositoryProvider{
    fun providePicRepository(): PicRepository {
        return PicRepository(PicsumApiService.create())
    }
}