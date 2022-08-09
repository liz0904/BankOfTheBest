package com.example.bankofthebest.portfolio

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.where

class PortRegActivity : AppCompatActivity() {

    // 변수 선언
    lateinit var edtTitle_port: TextView
    lateinit var edtDate_port: TextView
    lateinit var edtClassification_port : TextView
    lateinit var edtContent_port: TextView
    lateinit var edtMemo_port: TextView

    // 현재 액티비티에서 Realm 인스턴스 얻음
    // Migration 오류 발생에 대비하여 try-catch로 얻어옴
    val realm1 = try {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.port_reg)

        // port_reg.xml의 변수 id 연결
        edtTitle_port = findViewById(R.id.edtTitle_port)
        edtDate_port = findViewById(R.id.edtDate_port)
        edtClassification_port = findViewById(R.id.edtClassification_port)
        edtContent_port = findViewById(R.id.edtContent_port)
        edtMemo_port = findViewById(R.id.edtMemo_port)

        // 내용 출력
        val id = intent.getLongExtra("id", -1L)
        val listdb = realm1.where<portDB>().equalTo("id", id).findFirst()!!
        edtTitle_port.setText(listdb.title)
        edtDate_port.setText(listdb.date)
        edtClassification_port.setText(listdb.classification)
        edtContent_port.setText(listdb.content)
        edtMemo_port.setText(listdb.memo)
    }
}