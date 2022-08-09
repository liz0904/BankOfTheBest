package com.example.bankofthebest.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R
import com.example.bankofthebest.login.Person
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.where
import org.jetbrains.anko.startActivity

class ChoiceBankActivity : AppCompatActivity() {

    lateinit var btn_money_out: Button
    lateinit var text_account_out_money:TextView

    val realm = try {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_list_out)

        btn_money_out=findViewById(R.id.btn_money_out)
        text_account_out_money=findViewById(R.id.text_account_out_money)

        btn_money_out.setOnClickListener {
            val userid=intent.getStringExtra("userid")
            val person = realm.where<Person>().equalTo("id", userid).findFirst()

            var intent_todo=Intent(this, EditTodoActivity::class.java)
            intent_todo.putExtra("userid", person!!.id)
            startActivity(intent_todo)
        }
    }
}