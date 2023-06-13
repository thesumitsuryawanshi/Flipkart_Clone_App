package com.example.flipkartcloneapp.Model

import android.util.Log
import  com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.util.Constants
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


class productsDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val ProductList_Collection = firestore.collection(Constants.Product_Collection)

    suspend fun getProductsData(): List<ProductList> {

            return try {
                Log.d(
                    " mytagforDataChecking ",
                    "Here is the Data is coming ProductList data : " + ProductList_Collection.get()
                        .await().toObjects(ProductList::class.java)
                )
                ProductList_Collection.get().await().toObjects(ProductList::class.java)
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
