package com.example.extellar.testkt


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm
import io.realm.RealmResults
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : Fragment() {

    lateinit var realm: Realm
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_internet_posts, container, false)

        val recycler = rootView.findViewById(R.id.recycler) as RecyclerView
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = Adapter(list())

        return rootView
    }

    fun list(): ArrayList<Template> {
        val model = ArrayList<Template>()
        try {
            realm = Realm.getDefaultInstance()
            val result: RealmResults<Template> = realm.where(Template::class.java).findAll()
            model.addAll(realm.copyFromRealm(result))

        } finally {
            if (realm != null) {
                realm.close()
            }
        }
        return model
    }
}

