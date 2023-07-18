package com.example.flipkartcloneapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flipkartcloneapp.Model.entities.*
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

    val BDList: LiveData<List<BrandDealsList>>
        get() = repository.BrandDealsListData

    val btcList: LiveData<List<backToCityDeals>>
        get() = repository.btCListData

    val offerList: LiveData<List<Offers>>
        get() = repository.offerListData

//----------------------------------------------------------------
    val CEList: LiveData<List<AllProducts>>
        get() = repository.getCEListData


    val CFList: LiveData<List<AllProducts>>
        get() = repository.getCFListData


    val CFurList: LiveData<List<AllProducts>>
        get() = repository.getCFurListData

    val CGList: LiveData<List<AllProducts>>
        get() = repository.getCGListData

    val CMList: LiveData<List<AllProducts>>
        get() = repository.getCMListData
    val CTList: LiveData<List<AllProducts>>
        get() = repository.getCTListData


    init {
        viewModelScope.launch {

            repository.getProductListData()
            repository.getBrandListData()
            repository.getbtcListData()
            repository.getOfferListData()

            repository.getCEProducts()
            repository.getCFProducts()
            repository.getCFurProducts()
            repository.getCGProducts()
            repository.getCMProducts()
            repository.getCTProducts()
        }

    }
}