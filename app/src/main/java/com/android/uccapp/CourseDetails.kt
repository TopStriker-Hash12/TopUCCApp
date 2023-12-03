package com.android.uccapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.uccapp.databinding.ActivityViewCourseDetailsBinding

class CourseDetails : AppCompatActivity() {

    private lateinit var binding: ActivityViewCourseDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_course_details)

        binding = ActivityViewCourseDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val faculty: Course? = intent.getSerializableExtra("details") as Course?

        if (faculty != null) {
            binding.nameTv.text = "Title: " + faculty.name
            binding.codeTv.text = "Code: " + faculty.code
            binding.yearSemesterTv.text = "Year: " + faculty.yearSemester
            binding.creditTv.text = "Credits: " + faculty.creditHrs
            binding.totalHoursTv.text = "Total Hours: " + faculty.totalCreditHr
            binding.preRecTv.text = "Pre Rec: " + faculty.preRec
            binding.descriptionTv.text = "Description: " + faculty.description
        }

        binding.backBtn.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}