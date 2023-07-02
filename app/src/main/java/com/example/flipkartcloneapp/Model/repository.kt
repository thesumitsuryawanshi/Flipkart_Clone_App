package com.example.flipkartcloneapp.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.flipkartcloneapp.Model.entities.BrandDealsList
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

    //------------------------------------------------------------------------------------------------
    private val _BDmutableLivedata = MutableLiveData<List<BrandDealsList>>()

    val BrandDealsListData: LiveData<List<BrandDealsList>>
        get() = _BDmutableLivedata


    suspend fun getBrandListData() {
        val _BDdata = dataSource.getBrandDeals()
        _BDmutableLivedata.postValue(_BDdata)
    }

    //------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------


}