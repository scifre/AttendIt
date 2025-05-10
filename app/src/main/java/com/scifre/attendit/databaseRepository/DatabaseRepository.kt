package com.scifre.attendit.databaseRepository

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirestoreModule {
    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}


class DatabaseRepository @Inject constructor(
    private val firestore: FirebaseFirestore
){
    private val coursesCollection = firestore.collection("Courses")

    fun getCourse(id: String){
        coursesCollection
            .document(id)
            .get()
            .addOnSuccessListener { document->
                if(document.exists()){

                }
            }
    }

    suspend fun addCourse(){}


}



