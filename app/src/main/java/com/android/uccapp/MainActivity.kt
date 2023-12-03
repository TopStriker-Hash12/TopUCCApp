package com.android.uccapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.uccapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var databaseHelper: SQLiteDatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val firstLoad = sh.getBoolean("app_load", true)

        if (firstLoad) {
            saveDataToDB()
        }

        binding.fab.setOnClickListener { view ->
            try {
                val mail: Array<String> = arrayOf("ithod@ucc.edu.jm")
                val mailme = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, mail)
                    putExtra(Intent.EXTRA_TEXT, "Dear..")
                    putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
                }
                startActivity(mailme)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun saveDataToDB() {
        Log.d("testLog", "called")
        databaseHelper = SQLiteDatabaseHelper(this@MainActivity)
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()
        myEdit.putBoolean("app_load", false)
        myEdit.apply()

        //storing faculty objects
        val f1 = Faculty(
            "https://cdn-icons-png.flaticon.com/512/194/194936.png?w=740&t=st=1683355585~exp=1683356185~hmac=03e20dd0fb324768281f02297f9938fdca084781aa6eab97c4d1c6deed7e5b71",
            "Ms. Pamella Reid",
            "Programme Officer",
            "itprogrammeofficer2@ucc.edu.jm",
            "+1876-906-3000"
        )
        val f2 = Faculty(
            "https://img.freepik.com/premium-vector/handsome-businessman-suit_88465-811.jpg?w=740",
            "Mr. Ricardo Reid",
            "Programme Officer",
            "itprogrammeofficer3@ucc.edu.jm",
            "+1876-906-3000"
        )
        val f3 = Faculty(
            "https://cdn-icons-png.flaticon.com/512/607/607424.png?w=740&t=st=1683354026~exp=1683354626~hmac=2b3d32d1784b1b040788f1c9cadf3860fdd56ce161c77f68c5e57283f0fb1109",
            "Mr. Otis Osbourne",
            "IT Head of Department/IT Lecturer",
            "itfaculty@ucc.edu.jm",
            "(876)218-2935"
        )
        val f4 = Faculty(
            "https://img.freepik.com/premium-vector/handsome-businessman-suit_88465-811.jpg?w=740",
            "Mr. Craig Wilmot",
            "Programme Coordinator",
            "itprogrammeofficer4@ucc.edu.jm",
            "+1876-548-0629"
        )

        val f5 = Faculty(
            "https://i.pinimg.com/originals/a6/58/32/a65832155622ac173337874f02b218fb.png",
            "Ms. Natalie Rose",
            "Dean of Department",
            "ithod@ucc.edu.jm",
            "+1876-838-2408"
        )
        databaseHelper!!.insertFaculty(f1)
        databaseHelper!!.insertFaculty(f2)
        databaseHelper!!.insertFaculty(f3)
        databaseHelper!!.insertFaculty(f4)
        databaseHelper!!.insertFaculty(f5)

        //storing the courses objects
        val c1 = Course(
            "MOBILE APPLICATION DEVELOPMENT",
            "ITT420",
            "3",
            "3",
            "45 HOURS",
            "NONE",
            getString(R.string.course_description_1)
        )
        val c2 = Course(
            "COMPUTER SECURITY",
            "ITT309",
            "3",
            "3",
            "45 HOURS",
            "(ITT403) Data Communication & Networking 2",
            getString(R.string.course_description_2)
        )
        val c3 = Course(
            "PROGRAMMING TECHNIQUES",
            "ITT103",
            "1",
            "3",
            "45 HOURS",
            "(ITT 101) COMPUTER INFORMATION SYSTEMS",
            getString(R.string.course_description_3)
        )
        val c4 = Course(
            "BUILDING APPLICATIONS WITH C#",
            "ITT209",
            "3",
            "3",
            "45 HOURS",
            "(ITT208) INTERNET AUTHORING 1",
            getString(R.string.course_description_4)
        )
        val c5 = Course(
            "COMPUTER ESSENTIALS & TROUBLESHOOTING 1",
            "ITT101",
            "1",
            "3",
            "45 HOURS",
            "(ITT 101) COMPUTERS AND INFORMATION SYSTEMS ",
            getString(R.string.course_description_5)
        )
        val c6 = Course(
            "SYSTEM ANALYSIS AND DESIGN",
            "ITT310",
            "3",
            "3",
            "45 HOURS",
            "(ITT210) DATABASE MANAGEMENT SYSTEMS",
            getString(R.string.course_description_6)
        )
        val c7 = Course(
            "DATA STRUCTURES AND FILE MANAGEMENT 1",
            "ITT203",
            "2",
            "3",
            "45 HOURS",
            "(ITT 200) OBJECT-ORIENTED PROGRAMMING USING C ++",
            getString(R.string.course_description_7)
        )
        val c8 = Course(
            "PROGRAMMING DESIGN USING JAVA",
            "ITT303",
            "3",
            "3",
            "45 HOURS",
            ": (ITT 200) OBJECT-ORIENTED PROGRAMMING USING C ++ ",
            getString(R.string.course_description_8)
        )
        val c9 = Course(
            "COMPUTER DATA ANALYSIS",
            "ITT211",
            "1",
            "3",
            "45 HOURS",
            "NONE",
            getString(R.string.course_description_9)
        )
        val c10 = Course(
            "DATA COMMUNICATIONS AND NETWORKS 1",
            "ITT201",
            "2",
            "3",
            "45 HOURS",
            "(ITT 101) COMPUTER INFORMATION SYSTEMS",
            getString(R.string.course_description_10)
        )
        databaseHelper!!.insertCourse(c1)
        databaseHelper!!.insertCourse(c2)
        databaseHelper!!.insertCourse(c3)
        databaseHelper!!.insertCourse(c4)
        databaseHelper!!.insertCourse(c5)
        databaseHelper!!.insertCourse(c6)
        databaseHelper!!.insertCourse(c7)
        databaseHelper!!.insertCourse(c8)
        databaseHelper!!.insertCourse(c9)
        databaseHelper!!.insertCourse(c10)
    }
}