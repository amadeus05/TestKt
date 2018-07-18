package com.example.extellar.testkt

import io.realm.RealmObject
import io.realm.annotations.RealmClass


/*  {
    "userId": 8,
    "id": 72,
    "title": "sint hic doloribus consequatur eos non id",
    "body": "quam occaecati qui deleniti consectetur\nconsequatur aut facere quas exercitationem aliquam hic voluptas\nneque id sunt ut aut accusamus\nsunt consectetur expedita inventore velit"
  }*/

@RealmClass
open class Template() : RealmObject() {

    private var userId: Int = 0
    private var id: Int = 0
    private lateinit var title: String
    private lateinit var body: String

    fun setUserId(userId: Int) {
        this.userId = userId
    }

    fun getUserId(): Int {
        return userId
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getId(): Int {
        return id
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getTitle(): String {
        return title
    }

    fun setBody(body: String) {
        this.body = body
    }

    fun getBody(): String {
        return body
    }


}

