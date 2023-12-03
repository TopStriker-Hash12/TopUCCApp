package com.android.uccapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

//This is the adapter class for the Faculty recyvler view
class UCCFacultyAdapter(usersList: List<Faculty>, context: Context) :
    RecyclerView.Adapter<UCCFacultyAdapter.MyViewHolder>() {
    var notesList: List<Faculty>
    var context: Context

    //constructor
    init {
        notesList = usersList
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.faculty_single_item, parent, false)
        return MyViewHolder(itemView)
    }

    //binding data of every list item to the view of single item in recycler view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val faculty: Faculty = notesList[position]
        holder.email_tv.setText(faculty.email)
        holder.phone_tv.setText(faculty.phone)
        holder.name_tv.setText(faculty.name)
//        holder.position_tv.setText(faculty.position)
        holder.keyTv.setText(faculty.position)
        Glide.with(context).load(faculty.profile)
            .apply(RequestOptions().placeholder(R.drawable.profile).error(R.drawable.profile))
            .into(holder.profile_Img)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    //binging UI element with single item of adapter
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var email_tv: TextView
        var phone_tv: TextView
        var name_tv: TextView
        var position_tv: TextView
        var keyTv: TextView
        var profile_Img: CircleImageView

        init {
            email_tv = itemView.findViewById(R.id.email_tv)
            phone_tv = itemView.findViewById(R.id.phone_tv)
            name_tv = itemView.findViewById(R.id.name_tv)
            position_tv = itemView.findViewById(R.id.position_tv)
            keyTv = itemView.findViewById(R.id.key_number)
            profile_Img = itemView.findViewById(R.id.profile_image)
        }
    }
}