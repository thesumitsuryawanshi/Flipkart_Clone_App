package com.example.flipkartcloneapp.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.flipkartcloneapp.Model.entities.ProductList
import productsDatabase

class repository(val database: productsDatabase) {


    private val mutableLivedata = MutableLiveData<List<ProductList>>()

    val ProductListData: LiveData<List<ProductList>>
        get() = mutableLivedata


    suspend fun getProductListData() {
        val _data = database.getProductsData()
        mutableLivedata.postValue(_data)
    }
}