package com.geeks.data.repositories

import android.util.Log
import com.geeks.domain.repositories.SaveUserDataRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import javax.inject.Inject

class SaveUserDataRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : SaveUserDataRepository {

    override fun saveUserData(name: String) {

        val id = firestore.collection("CID").document("id")
        id.get(Source.SERVER).addOnSuccessListener { document ->
            if (document != null) {

                val freeId = document.data!!["count"].toString().toInt()

                val user = hashMapOf(
                    "users" to name,
                    "id" to freeId
                )
                val count = hashMapOf(
                    "count" to freeId + 1
                )
                firestore.collection("CID").document("id").set(count)
                firestore.collection("Users").document(name)
                    .set(user)
                    .addOnSuccessListener {
                        Log.d("TAGGER", "DocumentSnapshot successfully written!")
                    }
                    .addOnFailureListener { e ->
                        Log.w("TAGGER", "Error writing document", e)
                    }

            } else {
                Log.d("TAG", "No such document")
            }

        }.addOnFailureListener { exception ->
            Log.d("TAG", "get failed with ", exception)
        }
    }
}