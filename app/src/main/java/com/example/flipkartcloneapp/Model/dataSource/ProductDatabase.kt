package com.example.flipkartcloneapp.Model.dataSource

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.flipkartcloneapp.Model.entities.*
import com.example.flipkartcloneapp.View.MainActivity
import com.google.android.material.snackbar.Snackbar
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

    suspend fun getBrandDealsList(): List<BrandDealsList> {
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

    suspend fun getBackToCityList(): List<backToCityDeals> {
        val DealsList = mutableListOf<backToCityDeals>()

        try {
            val snapshot = db.collection("backToCityWatches").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(backToCityDeals::class.java)
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

    suspend fun getOffersList(): List<Offers> {
        val DealsList = mutableListOf<Offers>()

        try {
            val snapshot = db.collection("offers").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(Offers::class.java)
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

    //------------------------------------------------------------------------------------------------

    suspend fun getCEProducts(): List<AllProducts> {
        val List = mutableListOf<AllProducts>()

        try {
            val snapshot = db.collection("Electronics").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(AllProducts::class.java)
                product?.let {
                    List.add(product)
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return List
    }
    suspend fun getCFProducts(): List<AllProducts> {
        val List = mutableListOf<AllProducts>()

        try {
            val snapshot = db.collection("Fasion").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(AllProducts::class.java)
                product?.let {
                    List.add(product)
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return List
    }
    suspend fun getCFurProducts(): List<AllProducts> {
        val List = mutableListOf<AllProducts>()

        try {
            val snapshot = db.collection("Furniture").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(AllProducts::class.java)
                product?.let {
                    List.add(product)
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return List
    }
    suspend fun getCGProducts(): List<AllProducts> {
        val List = mutableListOf<AllProducts>()

        try {
            val snapshot = db.collection("Grosery").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(AllProducts::class.java)
                product?.let {
                    List.add(product)
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return List
    }
    suspend fun getCMProducts(): List<AllProducts> {
        val List = mutableListOf<AllProducts>()

        try {
            val snapshot = db.collection("Mobiles").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(AllProducts::class.java)
                product?.let {
                    List.add(product)
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return List
    }
    suspend fun getCTProducts(): List<AllProducts> {
        val List = mutableListOf<AllProducts>()

        try {
            val snapshot = db.collection("Toys").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(AllProducts::class.java)
                product?.let {
                    List.add(product)
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return List
    }


    suspend fun getrvofferList(): List<AllProducts> {
        val List = mutableListOf<AllProducts>()

        try {
            val snapshot = db.collection("offersList").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(AllProducts::class.java)
                product?.let {
                    List.add(product)
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return List
    }

    suspend fun getWatchList(): List<AllProducts> {
        val List = mutableListOf<AllProducts>()

        try {
            val snapshot = db.collection("watchList").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(AllProducts::class.java)
                product?.let {
                    List.add(product)
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return List
    }


    suspend fun getbrandDealsList(): List<AllProducts> {
        val List = mutableListOf<AllProducts>()

        try {
            val snapshot = db.collection("brandDeals").get().await()
            for (document in snapshot.documents) {
                val product = document.toObject(AllProducts::class.java)
                product?.let {
                    List.add(product)
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions here
            e.printStackTrace()
        }
        return List
    }
}