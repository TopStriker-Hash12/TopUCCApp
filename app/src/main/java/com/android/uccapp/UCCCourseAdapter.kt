package com.android.uccapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UCCCourseAdapter(courseList: List<Course>, context: Context) :
    RecyclerView.Adapter<UCCCourseAdapter.MyViewHolder>() {
    var courseList: List<Course>
    var context: Context

    init {
        this.courseList = courseList
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_single_item, parent, false)
        return MyViewHolder(itemView)
    }

    //bingding data form list to single items
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val faculty: Course = courseList[position]
        holder.Tvname.text = "COURSE TITLE: " + faculty.name
        holder.Tvcode.text = "COURSE CODE: " + faculty.code
        holder.TvyearSemester.text = "YEAR: " + faculty.yearSemester
        holder.Tvcredit.text = "CREDITS: " + faculty.creditHrs
        holder.TvtotalCredit.text = "TOTAL HOURS: " + faculty.totalCreditHr

        holder.layout.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, CourseDetails::class.java)
            intent.putExtra("details", faculty)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Tvcode: TextView
        var Tvname: TextView
        var TvyearSemester: TextView
        var Tvcredit: TextView
        var TvtotalCredit: TextView
        var layout: LinearLayout

        init {
            Tvcode = itemView.findViewById(R.id.code_tv)
            Tvname = itemView.findViewById(R.id.name_tv)
            TvyearSemester = itemView.findViewById(R.id.year_semester_tv)
            Tvcredit = itemView.findViewById(R.id.credit_tv)
            TvtotalCredit = itemView.findViewById(R.id.total_hours_tv)
            layout = itemView.findViewById(R.id.layout)
        }
    }
}