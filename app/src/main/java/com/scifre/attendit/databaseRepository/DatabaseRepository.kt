package com.scifre.attendit.databaseRepository

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

/*@Module
@InstallIn(SingletonComponent::class)
object RealmModule {

    @Provides
    @Singleton
    fun provideRealm(): Realm {
        val config = RealmConfiguration.Builder(setOf(Course::class))
            .schemaVersion(1)
            .build()
        return Realm.open(config)
    }
}*/

class DatabaseRepository @Inject constructor(
    private val firestore: FirebaseFirestore
){
    private val coursesCollection = firestore.collection("Courses")

    suspend fun addCourse(){}


}



