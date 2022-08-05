package com.example.bankofthebest.portfolio

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.PortAdapter
import com.example.bankofthebest.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.Sort
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.where
import org.jetbrains.anko.startActivity

class PortMainActivity : AppCompatActivity() {

    // 변수 선언
    lateinit var fab_port: FloatingActionButton
    lateinit var listView_port: ListView

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
        setContentView(R.layout.port_activity_main)

        // port_activity_main.xml의 변수 id 연결
        listView_port = findViewById(R.id.listView_port)
        fab_port = findViewById(R.id.fab_port)

        // 추가 버튼을 클릭하면 포트폴리오 추가 화면으로 넘어감
        fab_port.setOnClickListener { view ->
            startActivity<PortRegActivity>()
        }

        //portDB에 있는 데이터들을 id 필드로 정렬
        val realmResult = realm1.where<portDB>().findAll().sort("id", Sort.ASCENDING)

        //리스트뷰에 커스텀 어댑터 연결
        val adapter = PortAdapter(realmResult)
        listView_port.adapter = adapter

        // 리스트 뷰의 목록 선택 시 해당 데이터를 불러와 수정/삭제하도록
        // 해당 액티비티에 id 넘김
        realmResult.addChangeListener { _ -> adapter.notifyDataSetChanged() }
        listView_port.setOnItemClickListener { parent, view, position, id ->
            startActivity<PortRegActivity>("id" to id)
        }
    }

    // 액티비티 생명 주기에 맞춰 얻어온 Realm 인스턴스 반환
    override fun onDestroy() {
        super.onDestroy()
        realm1.close()
    }
}