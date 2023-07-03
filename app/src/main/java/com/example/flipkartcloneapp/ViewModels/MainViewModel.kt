package com.example.flipkartcloneapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flipkartcloneapp.Model.entities.BrandDealsList
import com.example.flipkartcloneapp.Model.entities.Offers
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.Model.entities.backToCityDeals
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


    init {
        viewModelScope.launch {

            repository.getProductListData()
            repository.getBrandListData()
            repository.getbtcListData()
            repository.getOfferListData()
        }

    }
}