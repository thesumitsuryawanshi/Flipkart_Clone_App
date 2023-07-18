package com.example.flipkartcloneapp.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.flipkartcloneapp.Model.dataSource.productDatabase
import com.example.flipkartcloneapp.Model.entities.*
import javax.inject.Inject


class repository
@Inject constructor(private var dataSource: productDatabase) {

    private val mutableLivedata = MutableLiveData<List<ProductList>>()
    private val _BDmutableLivedata = MutableLiveData<List<BrandDealsList>>()
    private val _bTCmutableLivedata = MutableLiveData<List<backToCityDeals>>()
    private val _offermutableLivedata = MutableLiveData<List<Offers>>()

    private val _getCEList= MutableLiveData<List<AllProducts>>()
    private val _getCFList= MutableLiveData<List<AllProducts>>()
    private val _getCFurList= MutableLiveData<List<AllProducts>>()
    private val _getCGList= MutableLiveData<List<AllProducts>>()
    private val _getCMList= MutableLiveData<List<AllProducts>>()
    private val _getCTList= MutableLiveData<List<AllProducts>>()



    val ProductListData: LiveData<List<ProductList>>
        get() = mutableLivedata
    val BrandDealsListData: LiveData<List<BrandDealsList>>
        get() = _BDmutableLivedata
    val btCListData: LiveData<List<backToCityDeals>>
        get() = _bTCmutableLivedata
    val offerListData: LiveData<List<Offers>>
        get() = _offermutableLivedata

    //----------------------------------------------------------------//----------------------------------------------------------------
            //categories
    val getCEListData : LiveData<List<AllProducts>>
        get() = _getCEList

    val getCFListData: LiveData<List<AllProducts>>
        get() = _getCFList

    val getCFurListData: LiveData<List<AllProducts>>
        get() = _getCFurList

    val getCGListData: LiveData<List<AllProducts>>
        get() = _getCGList

    val getCMListData: LiveData<List<AllProducts>>
        get() = _getCMList

    val getCTListData: LiveData<List<AllProducts>>
        get() = _getCTList


    //----------------------------------------------------------------//----------------------------------------------------------------


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
    //----------------------------------------------------------------//----------------------------------------------------------------
    //categories
    suspend fun getCEProducts() {
        val _Alldata = dataSource.getCEProducts()
    _getCEList.postValue(_Alldata)
    }

    suspend fun getCFProducts() {
        val _Alldata = dataSource.getCFProducts()
        _getCFList.postValue(_Alldata)
    }

    suspend fun getCFurProducts() {
        val _Alldata = dataSource.getCFurProducts()
        _getCFurList.postValue(_Alldata)
    }

    suspend fun getCGProducts() {
        val _Alldata = dataSource.getCGProducts()
        _getCGList.postValue(_Alldata)
    }
    suspend fun getCMProducts() {
        val _Alldata = dataSource.getCMProducts()
        _getCMList.postValue(_Alldata)
    }

    suspend fun getCTProducts() {
        val _Alldata = dataSource.getCTProducts()
        _getCTList.postValue(_Alldata)
    }

    //----------------------------------------------------------------//----------------------------------------------------------------

}