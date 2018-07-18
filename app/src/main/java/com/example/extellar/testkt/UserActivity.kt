package com.example.extellar.testkt
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class UserActivity : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_user_posts, container, false)
//        val recycler = rootView.findViewById(R.id.userrecycler) as RecyclerView
//        val itemsList = ArrayList<Template>()
//
//
//
//        recycler.layoutManager = LinearLayoutManager(activity)
//        recycler.adapter = Adapter(itemsList)
//        val  fab = rootView.findViewById(R.id.fab) as FloatingActionButton
//        fab.setOnClickListener { view ->
////            Snackbar.make(view, "Your post was added successful", Snackbar.LENGTH_LONG)
////                    .setAction("Action", null).show()
//        }

        return rootView

    }
}