package com.example.extellar.testkt

import android.app.AlertDialog
import android.app.Dialog
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmConfiguration


import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    val curentUserId: Int = 975375

    private val TAG: String = MainActivity::class.java.simpleName
    private lateinit var realm: Realm
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Realm.init(this);
        val configuration = RealmConfiguration.Builder().name("realmDB7").build()
        Realm.setDefaultConfiguration(configuration)

//              USE IT IF REALM DB ARE EMPTY
//*********************************************************
//            val s = com.example.extellar.testkt.AsyncTask() *
//            s.execute()                                                        *
//*********************************************************

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        val drawable = ContextCompat.getDrawable(applicationContext, R.drawable.ic_colorize_black_24dp)
        toolbar.overflowIcon = drawable

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.action_settings) {
            val dialog = AlertDialog.Builder(this)
            val dialogview = layoutInflater.inflate(R.layout.dialog_layout, null)
            val line1 = dialogview.findViewById<TextView>(R.id.dtitle)
            val line2 = dialogview.findViewById<TextView>(R.id.dbody)
            val editLine1: EditText = dialogview.findViewById(R.id.e1)
            editLine1.hint = "Title"

            val editLine2: EditText = dialogview.findViewById(R.id.e2)
            editLine2.hint = "Message"
            val btn: Button = dialogview.findViewById(R.id.send)

            dialog.setView(dialogview)
            dialog.show()
            btn.setOnClickListener(View.OnClickListener {

                Log.d("SEND button", "<<<<click>>>>")
                if (editLine1.text.toString().isEmpty() || editLine2.text.toString().isEmpty()) {
                    Toast.makeText(applicationContext, "Fields must not be empty! ", Toast.LENGTH_LONG).show()
                } else {
                    val realm = Realm.getDefaultInstance()
                    realm.executeTransaction { realm ->
                        val dataObject = realm.createObject(Template::class.java)
                        dataObject.setUserId(curentUserId)
                        dataObject.setId(1)
                        dataObject.setTitle(editLine1.text.toString())
                        dataObject.setBody(editLine2.text.toString())

                    }
                }

                Toast.makeText(applicationContext, ">>>>> " + editLine1.text.toString() +"   " +editLine2.text.toString(), Toast.LENGTH_LONG).show()
            })

        }

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> {
                    return HomeActivity()
                }
                1 -> {
                    return UserActivity()
                }
                else -> return null
            }

        }

        override fun getCount(): Int {
            // Show 2 total pages.
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "I-net"
                1 -> return "User"
            }
            return null;
        }

    }


}
