package com.hatim.photoplay.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hatim.photoplay.data.entities.Document
import com.hatim.photoplay.data.repositories.DocumentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val documentsRepository: DocumentsRepository
): ViewModel() {

    private val _documents = MutableLiveData<List<Document>>().apply {
        false
    }
    val documents: LiveData<List<Document>> = _documents

    fun getDocuments() =
        viewModelScope.launch(IO) {
            val documents = documentsRepository.getDocuments()
            _documents.postValue(documents.body()?.docs)
        }

}