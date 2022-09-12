package com.hatim.photoplay.data.repositories

import com.hatim.photoplay.data.entities.Options
import com.hatim.photoplay.data.entities.Payload
import com.hatim.photoplay.data.entities.Query
import com.hatim.photoplay.data.entities.SortOptions
import com.hatim.photoplay.data.services.DocumentsService
import javax.inject.Inject

class DocumentsRepository @Inject constructor() {

    @Inject lateinit var documentsService: DocumentsService

    suspend fun getDocuments() = documentsService.getDocuments(
        Payload(
            Query(false),
            Options(
                SortOptions("desc"),
                listOf("payloads"),
                20
            )
        )
    )
}