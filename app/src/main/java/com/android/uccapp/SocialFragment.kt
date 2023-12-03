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
import androidx.cardview.widget.CardView

class SocialFragment : Fragment() {

    private var facebook: CardView? = null
    private var instagram: CardView? = null
    private var twitter: CardView? = null
    private var youtube: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_social, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        facebook = view.findViewById(R.id.facebook_social)
        instagram = view.findViewById(R.id.instagram_social)
        twitter = view.findViewById(R.id.twitter_social)
        youtube = view.findViewById(R.id.youtube_social)




        twitter!!.setOnClickListener(View.OnClickListener {
            val url = "http://www.twitter.com/uccjamaica"
            if (url.startsWith("https://") || url.startsWith("http://")) {
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Invalid Url", Toast.LENGTH_SHORT).show()
            }
        })


        youtube!!.setOnClickListener(View.OnClickListener {
            val url = "https://www.youtube.com/channel/UCZRvkbzlwgpZVHMacb6MtLQ"
            if (url.startsWith("https://") || url.startsWith("http://")) {
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Invalid Url", Toast.LENGTH_SHORT).show()
            }
        })

        instagram!!.setOnClickListener(View.OnClickListener {
            val url = "http://www.instagram.com/uccjamaica/"
            if (url.startsWith("https://") || url.startsWith("http://")) {
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Invalid Url", Toast.LENGTH_SHORT).show()
            }
        })

        facebook!!.setOnClickListener(View.OnClickListener {
            val url = "https://m.facebook.com/381496945527257/"
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