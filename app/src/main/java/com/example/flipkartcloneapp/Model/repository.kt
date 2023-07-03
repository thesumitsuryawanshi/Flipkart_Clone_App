package com.example.flipkartcloneapp.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.flipkartcloneapp.Model.dataSource.productDatabase
import com.example.flipkartcloneapp.Model.entities.BrandDealsList
import com.example.flipkartcloneapp.Model.entities.Offers
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.Model.entities.backToCityDeals
import javax.inject.Inject


class repository
@Inject constructor(private var dataSource: productDatabase) {

    private val mutableLivedata = MutableLiveData<List<ProductList>>()
    private val _BDmutableLivedata = MutableLiveData<List<BrandDealsList>>()
    private val _bTCmutableLivedata = MutableLiveData<List<backToCityDeals>>()
    private val _offermutableLivedata = MutableLiveData<List<Offers>>()


    val ProductListData: LiveData<List<ProductList>>
        get() = mutableLivedata
    val BrandDealsListData: LiveData<List<BrandDealsList>>
        get() = _BDmutableLivedata
    val btCListData: LiveData<List<backToCityDeals>>
        get() = _bTCmutableLivedata
    val offerListData: LiveData<List<Offers>>
        get() = _offermutableLivedata


    suspend fun getProductListData() {
        val _data = dataSource.getProductsData()
        mutableLivedata.postValue(_data)
    }

    suspend fun getBrandListData() {
        val _BDdata = dataSource.getBrandDealsList()
        _BDmutableLivedata.postValue(_BDdata)
    }

    suspend fun getbtcListData() {
        val _btCdata = dataSource.getBackToCityList()
        _bTCmutableLivedata.postValue(_btCdata)
    }

    suspend fun getOfferListData() {
        val _offerdata = dataSource.getOffersList()
        _offermutableLivedata.postValue(_offerdata)
    }


}