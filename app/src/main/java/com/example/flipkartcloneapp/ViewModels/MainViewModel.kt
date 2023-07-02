package com.example.flipkartcloneapp.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.Model.repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: repository
) : ViewModel() {

    val pList: LiveData<List<ProductList>>
        get() = repository.ProductListData

    init {
        viewModelScope.launch {
            Log.d("mytag", "VM launched.")
            repository.getProductListData()
        }

    }
}