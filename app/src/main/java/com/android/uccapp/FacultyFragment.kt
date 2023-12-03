package com.android.uccapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FacultyFragment : Fragment() {


    var mDB: SQLiteDatabaseHelper? = null

    private var mAdapter: UCCFacultyAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var notesArrayList: ArrayList<Faculty>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_faculty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mDB = SQLiteDatabaseHelper(activity)
        recyclerView = view.findViewById(R.id.faculty_recyclerview)
        notesArrayList = java.util.ArrayList()
    }

    override fun onResume() {
        super.onResume()
        notesArrayList!!.clear()
        //get data form faculty table
        notesArrayList = mDB!!.allFaculty

        setData()

    }

    //setting data in recycler view
    private fun setData() {
        Log.d("tEstarraylist", notesArrayList.toString())
        if (notesArrayList!!.size > 0) {
            recyclerView!!.visibility = View.VISIBLE
            mAdapter = UCCFacultyAdapter(notesArrayList!!, requireActivity())
            val mLayoutManager1: RecyclerView.LayoutManager = LinearLayoutManager(activity)
            recyclerView!!.layoutManager = mLayoutManager1
            recyclerView!!.adapter = mAdapter
            mAdapter!!.notifyDataSetChanged()
        } else {
            recyclerView!!.visibility = View.GONE
        }
    }
}