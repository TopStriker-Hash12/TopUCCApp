package com.android.uccapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
class SQLiteDatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_FACULTY)
        db.execSQL(CREATE_TABLE_COURSE)
        Log.d("createtable", CREATE_TABLE_FACULTY)
    }

    companion object {
        // Database Name
        const val DATABASE_NAME = "ucc_db"

        // Database Version
        private const val DATABASE_VERSION = 1

        const val TABLE_NAME_COURSE = "course"
        const val COLUMN_ID = "id"
        const val COLUMN_Code = "code"
        const val COLUMN_Name = "name"
        const val COLUMN_Year_Semester = "year_semester"
        const val COLUMN_Credit = "creditHrs"
        const val COLUMN_Total_Credits = "totalCredit"
        const val COLUMN_preRec = "preRec"
        const val COLUMN_Description = "description"

        //Query to create Courses Table
        const val CREATE_TABLE_COURSE = ("CREATE TABLE " + TABLE_NAME_COURSE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_Code + " TEXT,"
                + COLUMN_Name + " TEXT,"
                + COLUMN_Year_Semester + " TEXT,"
                + COLUMN_Credit + " TEXT,"
                + COLUMN_Total_Credits + " TEXT,"
                + COLUMN_preRec + " TEXT,"
                + COLUMN_Description + " TEXT"
                + ")")



        const val TABLE_NAME_FACULTY = "faculty"
        const val COLUMN_ID_Faculty = "id"
        const val COLUMN_Profile = "profile"
        const val COLUMN_Name_faculty = "name"
        const val COLUMN_position = "position"
        const val COLUMN_Email = "email"
        const val COLUMN_Phone = "phone"

        //Query to create Faculty Table
        const val CREATE_TABLE_FACULTY = ("CREATE TABLE " + TABLE_NAME_FACULTY + "("
                + COLUMN_ID_Faculty + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_Profile + " TEXT,"
                + COLUMN_Name_faculty + " TEXT,"
                + COLUMN_position + " TEXT,"
                + COLUMN_Email + " TEXT,"
                + COLUMN_Phone + " TEXT"
                + ")")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_FACULTY)
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_COURSE)
        // Create tables again
        onCreate(db)
    }

    //************************USER***********************
    //insert new faculty in database
    fun insertFaculty(user: Faculty): Long {
        // get writable database as we want to write data
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_Profile, user.profile)
        values.put(COLUMN_Name, user.name)
        values.put(COLUMN_position, user.position)
        values.put(COLUMN_Email, user.email)
        values.put(COLUMN_Phone, user.phone)
        // insert row
        val id = db.insert(TABLE_NAME_FACULTY, null, values)
        // close db connection
        db.close()
        // return newly inserted row id
        return id
    }

    //getting all the list of faculty sotred in faculty table
    val allFaculty: ArrayList<Faculty>
        @SuppressLint("Range")
        get() {
            val db = this.readableDatabase
            val notesArrayList: ArrayList<Faculty> = ArrayList<Faculty>()
            val res = db.rawQuery("select * from " + TABLE_NAME_FACULTY, null)
            res.moveToFirst()
            while (!res.isAfterLast) {
                val faculty = Faculty()
                faculty.id=(res.getInt(res.getColumnIndex(COLUMN_ID_Faculty)))
                faculty.profile=(res.getString(res.getColumnIndex(COLUMN_Profile)))
                faculty.name=(res.getString(res.getColumnIndex(COLUMN_Name_faculty)))
                faculty.position=(res.getString(res.getColumnIndex(COLUMN_position)))
                faculty.email=(res.getString(res.getColumnIndex(COLUMN_Email)))
                faculty.phone=(res.getString(res.getColumnIndex(COLUMN_Phone)))
                notesArrayList.add(faculty)
                res.moveToNext()
            }
            return notesArrayList
        }

    //this is the function to store courses
    fun insertCourse(course: Course): Long {
        // get writable database as we want to write data
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_Code, course.code)
        values.put(COLUMN_Name, course.name)
        values.put(COLUMN_Year_Semester, course.yearSemester)
        values.put(COLUMN_Credit, course.creditHrs)
        values.put(COLUMN_Total_Credits, course.totalCreditHr)
        values.put(COLUMN_preRec, course.preRec)
        values.put(COLUMN_Description, course.description)
        // insert row
        val id = db.insert(TABLE_NAME_COURSE, null, values)
        // close db connection
        db.close()
        // return newly inserted row id
        return id
    }

    //getting all the courses datials
    val allCourse: ArrayList<Course>
        @SuppressLint("Range")
        get() {
            val db = this.readableDatabase
            val notesArrayList: ArrayList<Course> = ArrayList<Course>()
            val res = db.rawQuery("select * from " + TABLE_NAME_COURSE, null)
            res.moveToFirst()
            while (!res.isAfterLast) {
                val course = Course()
                course.id=(res.getInt(res.getColumnIndex(COLUMN_ID)))
                course.code=(res.getString(res.getColumnIndex(COLUMN_Code)))
                course.name=(res.getString(res.getColumnIndex(COLUMN_Name)))
                course.yearSemester=(res.getString(res.getColumnIndex(COLUMN_Year_Semester)))
                course.creditHrs=(res.getString(res.getColumnIndex(COLUMN_Credit)))
                course.totalCreditHr=(res.getString(res.getColumnIndex(COLUMN_Total_Credits)))
                course.preRec=(res.getString(res.getColumnIndex(COLUMN_preRec)))
                course.description=(res.getString(res.getColumnIndex(COLUMN_Description)))
                notesArrayList.add(course)
                res.moveToNext()
            }
            return notesArrayList
        }


}