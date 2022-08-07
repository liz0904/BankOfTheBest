package com.example.bankofthebest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.bankofthebest.community.MainCommuActivity
import com.example.bankofthebest.event.EventListActivity
import com.example.bankofthebest.login.Person
import com.example.bankofthebest.mypage.mypageMainActivity
import com.example.bankofthebest.portfolio.PortMainActivity
import com.example.bankofthebest.portfolio.portDB
import com.example.bankofthebest.todo.Todo
import com.example.bankofthebest.todo.TodoActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    // 변수 선언
    lateinit var btn_port : ImageButton
    lateinit var btn_awards : ImageButton
    lateinit var btn_commu : ImageButton
    lateinit var btn_event: ImageButton
    lateinit var btn_my:ImageButton
    lateinit var todoDateTextView : TextView
    lateinit var todoTitleTextView : TextView
    lateinit var todoSubtitleTextView : TextView
    lateinit var btn_refresh : ImageButton
    lateinit var text_user:TextView
    lateinit var textview_money_saving:TextView
    lateinit var btn_goto_minus: Button
    lateinit var btn_goto_saving_minus:Button

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
        btn_port = findViewById(R.id.btn_port)
        btn_awards = findViewById(R.id.btn_awards)
        btn_commu = findViewById(R.id.btn_commu)
        btn_event = findViewById(R.id.btn_commercial)
        todoDateTextView = findViewById(R.id.todoDateTextView)
        todoTitleTextView = findViewById(R.id.todoTitleTextView_Saving)
        todoSubtitleTextView = findViewById(R.id.todoSubtitleTextView_Saving)
        text_user = findViewById(R.id.text_user)
        btn_refresh = findViewById(R.id.btn_refresh)
        textview_money_saving = findViewById(R.id.textview_money_saving)
        btn_goto_minus = findViewById(R.id.btn_goto_minus)
        btn_goto_saving_minus = findViewById(R.id.btn_goto_saving_minus)

        realm.beginTransaction()    // 첫 번째 트랜젝션 시작

        // 현재 로그인한 회원 정보의 id 값을 가져와 메인 화면에 보여줌
        val person = realm.where<Person>().findFirst()
        if (person != null) {
            text_user.text = person.id
        }

        // portDB에 기본 데이터 저장
        val minId = realm.where<portDB>().min("id")
        if (minId == null) {
            val newItem = realm.createObject<portDB>(nextId_awards())
            newItem.title = "2020 봄 카오스 강연 중 ‘ 블록체인’ 강연 듣기"
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

            val newItem2 = realm.createObject<portDB>(nextId_awards())
            newItem2.title = "토익 930점 독학 성공"
            newItem2.date = "21/01/02 - 21/02/02 "
            newItem2.classification = "단체(스터디)"
            newItem2.content =
                "곧 있을 편입과 취업을 위해 토익 시험을 보았다. 요새는 공기업이라면 토익 점수를 본다. 듣기와 독해, 어휘 모든 부분을 보는 시험이기 때문에 처음에 감이 오지 않았었는데, 기출 문제를 풀고나서 어느 부분이 내가 취약한지 알 수 있었다. 그 부분들을 위주로 공부 하다 보니 점수가 빠른 속도로 오를 수 있었다."
            newItem2.memo = "친구들이나 지인들을 통해 교재나 학원 및 공부법에 대해 물어보면 도움이 많이 된다"

            val newItem3 = realm.createObject<portDB>(nextId_awards())
            newItem3.title = "안드로이드 개발 프로젝트"
            newItem3.date = "21/01/04 - 21/02/14"
            newItem3.classification = "단체"
            newItem3.content =
                "안드로이드 앱 개발에 관심이 있는 친구들과 팀을 이루어 프로젝트를 진행하였다. 주제선정부터 개발, 디자인 단계까지 초반에 세부적으로 정하는 것이 중요하다. 팀원들간 역할 배분과 기능 담당을 나누어 개발을 하면 책임감을 더하면서도 부담은 덜 가질 수 있다. "
            newItem3.memo = "생각보다 구글링으로 해결되지 않는게 많았다. 교재를 사서 공부해도 도움이 될 것 같다."
        }
        realm.commitTransaction()   // 첫 번째 트랜젝션 종료

        realm2.beginTransaction()   // 두 번째 트랜젝션 시작

        // Todo에 기본 정보 저장
        val minId2 = realm2.where<Todo>().min("id")
        if (minId2 == null) {
            val newItem10 = realm2.createObject<Todo>(nextId_todo())
            newItem10.date = 1641794919192
            newItem10.title = "정보처리기사 자격증 취득"
            newItem10.subtitle = "알고리즘 풀기\n백준 코딩테스트하기"
        }
        refreshTodo()   // 메인 페이지에 체크리스트 목록 중 날짜가 가장 빠른 데이터를 보여줌

        // 새로고침 버튼을 누르면 메인 페이지에 체크리스트 목록 중 날짜가 가장 빠른 데이터를 보여주는 함수 실행
        btn_refresh.setOnClickListener {
            refreshTodo()
        }
        realm2.commitTransaction()   // 두 번째 트랜젝션 종료

        // 이미지 버튼 클릭 시 해당하는 액티비티로 연결

        btn_port.setOnClickListener { view ->
            startActivity<PortMainActivity>()
        }
        btn_awards.setOnClickListener { view ->
            startActivity<AwardsActivity>()
        }
        btn_commu.setOnClickListener { view ->
            startActivity<MainCommuActivity>()
        }
        btn_event.setOnClickListener { view ->
            startActivity<EventListActivity>()
        }
        text_user.setOnClickListener {
            startActivity<mypageMainActivity>()
        }
        btn_goto_minus.setOnClickListener { view ->
            startActivity<TodoActivity>()
        }
        btn_goto_saving_minus.setOnClickListener {
           //저금통을 해지하시겠습니까? 띄우고 예 하면 금액 변경
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
            todoDateTextView.text = "3333-08-1234567"
            todoTitleTextView.text = "급여통장"
            var saving_tmp=realmResult_main.money%1000
            realmResult_main.money-=saving_tmp
            realmResult_main.saving_money+=saving_tmp
            todoSubtitleTextView.text =realmResult_main.money.toString()+"원"
            textview_money_saving.text=realmResult_main.saving_money.toString()+"원"
        }
    }

}
