package com.example.bankofthebest.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R
import org.jetbrains.anko.startActivity

class ChoiceBankActivity : AppCompatActivity() {

    lateinit var btn_money_out: Button
    lateinit var text_account_out_money:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_list_out)

        btn_money_out=findViewById(R.id.btn_money_out)
        text_account_out_money=findViewById(R.id.text_account_out_money)

        btn_money_out.setOnClickListener {
            intent= Intent(this, EditTodoActivity::class.java)
            intent.putExtra("account_out_moeny", text_account_out_money.text.toString())
            startActivity(intent)
            //startActivity<TodoActivity>()
        }
    }
}