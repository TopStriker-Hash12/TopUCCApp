package com.android.uccapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class AdmissionFragment : Fragment() {

    private var submitBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admission, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submitBtn = view.findViewById(R.id.start_application)

        //button click to navigate the defined link of university website
        submitBtn!!.setOnClickListener(View.OnClickListener {
            val url = "https://ucc.edu.jm/apply/undergraduate/preform"
            if (url.startsWith("https://") || url.startsWith("http://")) {
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Invalid Url", Toast.LENGTH_SHORT).show()
            }
        })
    }
}