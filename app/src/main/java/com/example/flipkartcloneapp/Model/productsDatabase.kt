package com.example.flipkartcloneapp.Model

import com.google.firebase.firestore.FirebaseFirestore

class productsDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val productsCollection = firestore.collection("ProductsList")
//
//    suspend fun getProducts(): List<ProductList>{
//
//    }


}