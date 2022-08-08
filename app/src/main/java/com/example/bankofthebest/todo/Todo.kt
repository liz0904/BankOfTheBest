package com.example.bankofthebest.todo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Todo(
    @PrimaryKey var id: Long = -1,
    var username:String="",
    var title: String = "",
    var subtitle: String = "",
    var date: Long = 0
) : RealmObject() {
}
