package com.example.bankofthebest.portfolio

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

class PortRegActivity : AppCompatActivity() {

    // 변수 선언
    lateinit var edtTitle_port: TextView
    lateinit var edtDate_port: TextView
    lateinit var edtClassification_port : TextView
    lateinit var edtContent_port: TextView
    lateinit var edtMemo_port: TextView
    lateinit var deleteFab_port: FloatingActionButton
    lateinit var doneFab_port: FloatingActionButton

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
        deleteFab_port = findViewById(R.id.deleteFab_port)
        doneFab_port = findViewById(R.id.doneFab_port)

        // 입력/수정/삭제 모드 변경
        val id = intent.getLongExtra("id", -1L)
        if (id == -1L) {
            //insertMode_port()
        } else {
            updateMode_port(id)
        }
    }

    // 수정
    // 해당 id 필드의 데이터를 editText에 집어넣음
    private fun updateMode_port(id: Long) {
        val listdb = realm1.where<portDB>().equalTo("id", id).findFirst()!!
        edtTitle_port.setText(listdb.title)
        edtDate_port.setText(listdb.date)
        edtClassification_port.setText(listdb.classification)
        edtContent_port.setText(listdb.content)
        edtMemo_port.setText(listdb.memo)

        //doneFab_port.setOnClickListener { updatePort(id) }
        //deleteFab_port.setOnClickListener { deletePort(id) }
    }

    // 액티비티 생명 주기에 맞춰 얻어온 Realm 인스턴스 반환
    override fun onDestroy() {
        super.onDestroy()
        realm1.close()
    }

    // 입력
    private fun insertPort() {
        realm1.beginTransaction()   // 트랜젝션 시작

        // DB에 데이터 추가
        val newItem = realm1.createObject<portDB>(nextId())
        newItem.title = edtTitle_port.text.toString()
        newItem.date = edtDate_port.text.toString()
        newItem.classification = edtClassification_port.text.toString()
        newItem.content = edtContent_port.text.toString()
        newItem.memo = edtMemo_port.text.toString()

        realm1.commitTransaction()  // 트랜젝션 종료
        alert("저장되었습니다") {
            yesButton { finish() }
        }.show()
    }

    // 수정
    private fun updatePort(id: Long) {
        realm1.beginTransaction()    // 트랜젝션 시작

                // editText에 있는 내용을 가져와
                // 일치하는 id 필드의 데이터 수정
                val updateItem = realm1.where<portDB>().equalTo("id", id).findFirst()!!
                updateItem.title = edtTitle_port.text.toString()
                updateItem.date = edtDate_port.text.toString()
                updateItem.classification = edtClassification_port.text.toString()
                updateItem.content = edtContent_port.text.toString()
                updateItem.memo = edtMemo_port.text.toString()

                realm1.commitTransaction()  // 트랜젝션 종료
                alert("변경되었습니다") {
                    yesButton { finish() }
        }.show()
    }

    // 삭제
    private fun deletePort(id: Long) {
        realm1.beginTransaction()   // 트랜젝션 시작

        // 일치하는 id 필드에 해당하는 데이터 삭제
        val deleteItem = realm1.where<portDB>().equalTo("id", id).findFirst()!!
        deleteItem.deleteFromRealm()

        realm1.commitTransaction()  // 트랜젝션 종료
        alert("삭제되었습니다") {
            yesButton { finish() }
        }.show()
    }

    // 키 증가 메서드
    private fun nextId(): Int {
        val maxId = realm1.where<portDB>().max("id")

        if (maxId != null) {
            return maxId.toInt() + 1
        }
        return 0
    }
}