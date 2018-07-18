package com.example.extellar.testkt

import android.os.AsyncTask
import android.util.Log
import io.realm.Realm

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray


class AsyncTask : AsyncTask<Unit, Unit, Unit>() {

    override fun doInBackground(vararg p0: Unit?) {
        val realm: Realm = Realm.getDefaultInstance()
        val url = "https://jsonplaceholder.typicode.com/posts"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        val body = response?.body()?.string()
        Log.d("RESPONSE FROM URL", "STRING: " + body)

        val jArr = JSONArray(body)
        for (i in 0..(jArr.length() - 1)) {
            val item = jArr.getJSONObject(i)
            val newT: Template = Template()

            newT.setUserId(Integer.parseInt(item.getString("userId")))
            newT.setId(Integer.parseInt(item.getString("id")))
            newT.setTitle(item.getString("title"))
            newT.setBody(item.getString("body"))

            Log.d("TEMPLATE: $i : ", " >>>>>>>>>>>>>>" + newT.getId() + newT.getUserId() + newT.getTitle() + newT.getBody())

            val needHelp = RealmHelper(realm)

            needHelp.save_to_realm(
                    Integer.parseInt(item.getString("userId")),
                    Integer.parseInt(item.getString("id")),
                    item.getString("title"),
                    item.getString("body")
            )
        }


    }

}
