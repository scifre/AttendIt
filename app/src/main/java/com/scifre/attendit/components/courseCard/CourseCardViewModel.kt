package com.scifre.attendit.components.courseCard

import androidx.lifecycle.ViewModel
import com.scifre.attendit.databaseRepository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CourseCardViewModel @Inject constructor(
    private val db: DatabaseRepository
) : ViewModel(){

    var courseName = "Computational Number Theory"
    val facultyName = "Dr. RamaKrishna Bandi"

    fun changeName(new:String){
        courseName = new
    }






}