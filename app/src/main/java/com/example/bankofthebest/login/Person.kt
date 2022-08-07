package com.example.bankofthebest.login

import io.realm.RealmObject

open class Person(var id:String="",
                  var pwd:String="",
                  var email:String="",
                  var money:Int=101234,
                  var account:String="",
                  var saving_money: Int=1234
)
    : RealmObject() {
}