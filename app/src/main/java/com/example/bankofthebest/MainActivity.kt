package com.example.bankofthebest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.bankofthebest.event.EventListActivity
import com.example.bankofthebest.login.Person
import com.example.bankofthebest.mypage.mypageMainActivity
import com.example.bankofthebest.portfolio.PortMainActivity
import com.example.bankofthebest.portfolio.portDB
import com.example.bankofthebest.todo.ChoiceBankActivity
import com.example.bankofthebest.todo.Todo
import com.example.bankofthebest.todo.TodoActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

    // 변수 선언
    lateinit var todoDateTextView : TextView
    lateinit var todoTitleTextView : TextView
    lateinit var todoSubtitleTextView : TextView
    lateinit var btn_refresh : ImageButton
    lateinit var text_user:TextView
    lateinit var textview_money_saving:TextView
    lateinit var btn_goto_minus: Button
    lateinit var btn_goto_saving_minus:Button
    lateinit var layout_commercial: View
    lateinit var layout_notice: View
    lateinit var layout_mypage: View
    lateinit var btn_goto_saving:Button
    lateinit var layout_account:View

    // 현재 액티비티에서 Realm 인스턴스 얻음
    // Migration 오류 발생에 대비하여 try-catch로 얻어옴
    // 증복 오류 방지를 위해 인스턴스를 하나 더 생성
    val realm = try {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }

    val realm2 = try {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // activity_main.xml의 변수 id 연결
        todoDateTextView = findViewById(R.id.text_account_number)
        todoTitleTextView = findViewById(R.id.text_account_list_name)
        todoSubtitleTextView = findViewById(R.id.text_account_list_money)
        text_user = findViewById(R.id.text_user)
        btn_refresh = findViewById(R.id.btn_refresh)
        textview_money_saving = findViewById(R.id.textview_money_saving)
        btn_goto_minus = findViewById(R.id.btn_goto_minus)
        btn_goto_saving_minus = findViewById(R.id.btn_goto_saving_minus)
        layout_commercial=findViewById(R.id.layout_commercial)
        layout_notice=findViewById(R.id.layout_notice)
        layout_mypage=findViewById(R.id.layout_mypage)
        btn_goto_saving=findViewById(R.id.btn_goto_saving)
        layout_account=findViewById(R.id.layout_account)
        realm.beginTransaction()    // 첫 번째 트랜젝션 시작

        // 현재 로그인한 회원 정보의 id 값을 가져와 메인 화면에 보여줌
        val userid=intent.getStringExtra("userid")
        val person = realm.where<Person>().equalTo("id", userid).findFirst()
        if (person != null) {
            text_user.text = person.id
            person.account="3333-08-1234567"
        }

        // portDB에 기본 데이터 저장
        val minId = realm.where<portDB>().min("id")
        if (minId == null) {
            val newItem = realm.createObject<portDB>(nextId_awards())
            newItem.title = "2020 봄 카오스 강연 중 ‘ 블록체인’ 강연 진행"
            newItem.date = "20/03/25 ~ 20/03/25"
            newItem.classification = "개인"
            newItem.content =
                "블록체인의 특징과 등장 배경을 살펴본다. 그리고 블록체인의 기본적인 원리에 대하여 예를 중심으로 알아보고 블록체인과 암호화폐이의 관계에 대해 살펴보는 시간을 가졌다. "
            newItem.memo = "블록체인과 연관된 기술들에 대해 알아보고 블로그에 포스팅하기"

            val newItem1 = realm.createObject<portDB>(nextId_awards())
            newItem1.title = "리눅스 마스터 1급 자격증 취득"
            newItem1.date = "20/09/01 - 20/11/14"
            newItem1.classification = "개인"
            newItem1.content =
                "리눅스 마스터 1급을 통해 리눅스 OS의 기본지식과 서버, 네트워크 관리 실무능력을 인증할 수 있는 자격증인데 올해 여름에 2급을 따고 나서 1급도 취득하고자 하여 2달 정도의 기간을 두고 공부하였다. "
            newItem1.memo = "컴퓨터활용능력처럼 자주 있는 시험이 아니기 때문에 연초에 올라오는 시험 일정을 미리미리 확인하는게 좋다."

        }
        realm.commitTransaction()   // 첫 번째 트랜젝션 종료

        realm2.beginTransaction()   // 두 번째 트랜젝션 시작

        // Todo에 기본 정보 저장
        val minId2 = realm2.where<Todo>().min("id")
        if (minId2 == null) {
            val newItem10 = realm2.createObject<Todo>(nextId_todo())
            newItem10.date = 1641794919192
            //newItem10.title = "계좌"
            //newItem10.subtitle = "알고리즘 풀기\n백준 코딩테스트하기"
        }
        refreshTodo()   // 메인 페이지에 체크리스트 목록 중 날짜가 가장 빠른 데이터를 보여줌

        // 새로고침 버튼을 누르면 메인 페이지에 체크리스트 목록 중 날짜가 가장 빠른 데이터를 보여주는 함수 실행
        btn_refresh.setOnClickListener {
            refreshTodo()
        }
        realm2.commitTransaction()   // 두 번째 트랜젝션 종료

        // 이미지 버튼 클릭 시 해당하는 액티비티로 연결

        text_user.setOnClickListener {
            startActivity<mypageMainActivity>()
        }
        btn_goto_minus.setOnClickListener { view -> //메인페이지에서 이체하기 버튼 클릭
            startActivity<ChoiceBankActivity>()
        }
        btn_goto_saving_minus.setOnClickListener {
            refreshsaving_minus()
            //저금통을 해지하시겠습니까? 띄우고 예 하면 금액 변경
        }
        layout_commercial?.setOnClickListener{
            startActivity<EventListActivity>()
        }
        layout_notice?.setOnClickListener{
            startActivity<PortMainActivity>()
        }
        layout_mypage?.setOnClickListener {
            startActivity<mypageMainActivity>()
        }
        btn_goto_saving.setOnClickListener {
            refreshSaving_plus()
        }
        layout_account?.setOnClickListener {
            startActivity<TodoActivity>()
        }
    }

    // 키 증가 메서드
    private fun nextId_awards(): Int {
        val maxId = realm.where<portDB>().max("id")

        if (maxId != null) {
            return maxId.toInt() + 1
        }
        return 0
    }

    private fun nextId_todo(): Int {
        val maxId = realm.where<Todo>().max("id")

        if (maxId != null) {
            return maxId.toInt() + 1
        }
        return 0
    }

    // 메인 페이지에 체크리스트 목록 중
    // 날짜가 가장 빠른 데이터를 보여주는 함수
    private fun refreshTodo() {
        val realmResult_main = realm.where<Person>().findFirst()
        val realmResultmain1 = realmResult_main

        if (realmResultmain1 != null) {
            todoDateTextView.text = realmResult_main.account
            todoTitleTextView.text = "급여통장"
            todoSubtitleTextView.text =realmResult_main.money.toString()+"원"
            textview_money_saving.text=realmResult_main.saving_money.toString()+"원"
        }
    }
    /*
    여기정리필수
    여기정리필수
    여기정리필수
    여기정리필수
    여기정리필수
    여기정리필수
     */

    //저금통 정리하기
    private fun refreshSaving_plus() {
        val realmResult_main = realm.where<Person>().equalTo("id", "asdf").findFirst()!!
        realm.beginTransaction()

        if (realmResult_main != null) {
            todoDateTextView.text = realmResult_main.account
            todoTitleTextView.text = "급여통장"
            realmResult_main.saving_money+=realmResult_main.money%1000
            realmResult_main.money-=realmResult_main.money%1000
            todoSubtitleTextView.text =realmResult_main.money.toString()+"원"
            textview_money_saving.text=realmResult_main.saving_money.toString()+"원"

        }

        realm.commitTransaction()
    }

    //저금통 해지하기
    private fun refreshsaving_minus() {
        val realmResult_main = realm.where<Person>().equalTo("id", "asdf").findFirst()!!
        realm.beginTransaction()

        if (realmResult_main != null) {
            todoDateTextView.text = realmResult_main.account
            todoTitleTextView.text = "급여통장"
            realmResult_main.money+=realmResult_main.saving_money
            realmResult_main.saving_money=0
            todoSubtitleTextView.text =realmResult_main.money.toString()+"원"
            textview_money_saving.text=realmResult_main.saving_money.toString()+"원"

        }

        realm.commitTransaction()
    }
}
