package com.example.extellar.testkt

import android.util.Log
import io.realm.Realm


class RealmHelper(realm: Realm) {
    private val realm = realm

    fun save_to_realm(userId: Int, id: Int, title: String, body: String) {
        val realm = Realm.getDefaultInstance()

        realm.executeTransaction { realm ->
            val dataObject = realm.createObject(Template::class.java)
            dataObject.setUserId(userId)
            dataObject.setId(id)
            dataObject.setTitle(title)
            dataObject.setBody(body)
            realm.close()
        }
    }


}