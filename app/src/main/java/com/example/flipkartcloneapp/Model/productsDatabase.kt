import com.example.flipkartcloneapp.Model.entities.ProductList
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class productsDatabase {
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
}
