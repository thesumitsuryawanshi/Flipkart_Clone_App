package com.example.flipkartcloneapp.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.flipkartcloneapp.Model.entities.ProductList
import javax.inject.Inject

class repository
@Inject constructor(private var dataSource: com.example.flipkartcloneapp.Model.dataSource.productDatabase) {

    private val mutableLivedata = MutableLiveData<List<ProductList>>()

    val ProductListData: LiveData<List<ProductList>>
        get() = mutableLivedata

    suspend fun getProductListData() {
        val _data = dataSource.getProductsData()
        mutableLivedata.postValue(_data)
    }
}