package com.example.bankofthebest.todo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Todo(
    @PrimaryKey var id: Long = -1,
    var username:String="",
    var account_list_out_number: String = "",
    var account_list_out_money: String = "",
    var account_list_bank:String="",
    var date: Long = 0,
    var usermoney:Int=0
) : RealmObject() {
}
