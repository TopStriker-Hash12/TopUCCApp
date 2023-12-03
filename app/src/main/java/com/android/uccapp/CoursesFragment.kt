package com.android.uccapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CoursesFragment : Fragment() {


    var databaseHelper: SQLiteDatabaseHelper? = null

    private var mAdapter: UCCCourseAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var courseArrayList: ArrayList<Course>? = null
    private var noDataLayout: ConstraintLayout? = null

    private var titleInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseHelper = SQLiteDatabaseHelper(activity)
        recyclerView = view.findViewById(R.id.course_recyclerview)
        noDataLayout = view.findViewById(R.id.no_course_layout)
        titleInput = view.findViewById(R.id.name_input)

        courseArrayList = ArrayList()

        SearchCourse()

    }

    private fun SearchCourse() {
        titleInput!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.length == 0) {
                    if (courseArrayList!!.size != 0) {
                        recyclerView!!.visibility = View.VISIBLE
                        noDataLayout!!.visibility = View.GONE
                    } else {
                        recyclerView!!.visibility = View.GONE
                        noDataLayout!!.visibility = View.VISIBLE
                    }
                    mAdapter = UCCCourseAdapter(courseArrayList!!, activity!!)
                    recyclerView!!.adapter = mAdapter
                    mAdapter!!.notifyDataSetChanged()
                } else {
                    val clone = java.util.ArrayList<Course>()
                    for (element in courseArrayList!!) {
                        if (element.name!!.lowercase()
                                .contains(s.toString().lowercase(Locale.getDefault()))
                        ) {
                            clone.add(element)
                        }
                    }
                    if (clone.size != 0) {
                        recyclerView!!.visibility = View.VISIBLE
                        noDataLayout!!.visibility = View.GONE
                    } else {
                        recyclerView!!.visibility = View.GONE
                        noDataLayout!!.visibility = View.VISIBLE
                    }
                    mAdapter = UCCCourseAdapter(clone, activity!!)
                    recyclerView!!.adapter = mAdapter
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    override fun onResume() {
        super.onResume()

        courseArrayList!!.clear()

        //loading courses data form sqlite database

        //loading courses data form sqlite database
        courseArrayList = databaseHelper!!.allCourse

        setData()
    }

    private fun setData() {
        Log.d("tEstarraylist", courseArrayList.toString())
        if (courseArrayList!!.size > 0) {
            recyclerView!!.visibility = View.VISIBLE
            noDataLayout!!.visibility = View.GONE
            mAdapter = UCCCourseAdapter(courseArrayList!!, requireActivity())
            val mLayoutManager1: RecyclerView.LayoutManager = LinearLayoutManager(activity)
            recyclerView!!.layoutManager = mLayoutManager1
            recyclerView!!.adapter = mAdapter
            mAdapter!!.notifyDataSetChanged()
        } else {
            noDataLayout!!.visibility = View.VISIBLE
            recyclerView!!.visibility = View.GONE
        }
    }
}