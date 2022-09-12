package com.hatim.photoplay.data.services

import com.hatim.photoplay.data.entities.Document
import com.hatim.photoplay.data.entities.Documents
import com.hatim.photoplay.data.entities.Payload
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DocumentsService {
    @POST("query")
    suspend fun getDocuments(@Body payload: Payload): Response<Documents>
}