package com.example.flipkartcloneapp.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flipkartcloneapp.Model.productsDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel
@Inject
constructor(
    private val productsDatabase: productsDatabase
) : ViewModel() {




    suspend fun fetchingFlipkarrtProductData() {

        viewModelScope.launch {
            Log.d("mytag","VM method launched.")
            productsDatabase.getProductsData()
        }

    }
}
