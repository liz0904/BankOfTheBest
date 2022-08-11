package com.example.bankofthebest.login

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Person(var id:String="",
                  var pwd:String="",
                  var username:String="",
                  var email:String="",
                  var phone:String="",
                  var money:Int=101234,
                  var account:String="",
                  var saving_money: Int=1234
): RealmObject() {}