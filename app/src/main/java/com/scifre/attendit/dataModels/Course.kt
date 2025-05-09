package com.scifre.attendit.dataModels
import org.json.JSONObject
import java.util.UUID


data class Course (
    var id: String = UUID.randomUUID().toString(),
    var courseCode: String = "",
    var courseName: String = "",
    var facultyName: String = "",
    var totalClasses: Int = 0,
    var attendedClasses: Int = 0,
    var attendancePercentage: Double =(attendedClasses/totalClasses*100).toDouble(),
    var schedule: JSONObject = JSONObject()

)
