package com.example.bankofthebest

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.portfolio.portDB
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.where
import java.util.*

class AwardsActivity : AppCompatActivity() {

    // 변수 선언
    lateinit var tvTitle_awards : TextView
    lateinit var tvDate_awards : TextView
    lateinit var tvClassification_awards : TextView
    lateinit var tvContent_awards : TextView
    lateinit var tvMemo_awards : TextView

    // 현재 액티비티에서 Realm 인스턴스 얻음
    // Migration 오류 발생에 대비하여 try-catch로 얻어옴
    val realm99 = try {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.awards_activity_main)

        // awards_activity_main.xml의 변수 id 연결
        tvTitle_awards = findViewById(R.id.tvTitle_awards)
        tvDate_awards = findViewById(R.id.tvDate_awards)
        tvClassification_awards = findViewById(R.id.tvClassification_awards)
        tvContent_awards= findViewById(R.id.tvContent_awards)
        tvMemo_awards = findViewById(R.id.tvMemo_awards)

        // 포트폴리오 DB에 있는 목록 중 하나를 랜덤으로 가져와 명예의 전당 페이지에서 보이게 함
        // portDB 클래스로 생성한 DB에서 아이디값을 추출한 뒤, 랜덤 함수를 이용하여 가져올 인덱스를 추출함
        val realmResult99 = realm99.where<portDB>().findAll()
        val dbSize = realm99.where<portDB>().max("id")!!    // DB에 id값이 0부터 저장되므로 0~(저장된 수)의 범위 안에서 인덱스 추출
        val random = Random()
        val sizeInt = random.nextInt(dbSize.toInt())

        // 랜덤으로 추출한 인덱스에 해당하는 필드의 값들을 awards_activity_content.xml의 텍스트뷰에 뿌려줌
        val realmResult99_main = realmResult99[sizeInt]
        if (realmResult99_main != null) {
            tvTitle_awards.setText(realmResult99_main.title)
            tvDate_awards.setText(realmResult99_main.date)
            tvClassification_awards.setText(realmResult99_main.classification)
            tvContent_awards.setText(realmResult99_main.content)
            tvMemo_awards.setText(realmResult99_main.memo)
        }
    }

    // 액티비티 생명 주기에 맞춰 얻어온 Realm 인스턴스 반환
    override fun onDestroy() {
        super.onDestroy()
        realm99.close()
    }

}