package com.example.flipkartcloneapp.Model.dataSource

import com.example.flipkartcloneapp.Model.entities.BrandDealsList
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


public class productDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val db = Firebase.firestore

    suspend fun getProductsData(): List<ProductList> {
        val productList = mutableListOf<ProductList>()

        try {
            val snapshot = db.collection("ProductList").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(ProductList::class.java)
                product?.let {
                    productList.add(product)

                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return productList
    }

    suspend fun getBrandDeals(): List<BrandDealsList> {
        val DealsList = mutableListOf<BrandDealsList>()

        try {
            val snapshot = db.collection("BrandDeals").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(BrandDealsList::class.java)
                product?.let {
                    DealsList.add(product)

                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return DealsList
    }


}

