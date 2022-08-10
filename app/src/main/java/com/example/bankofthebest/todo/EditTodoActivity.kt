package com.example.bankofthebest.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.bankofthebest.R
import com.example.bankofthebest.login.Person
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton
import java.util.*

class EditTodoActivity : AppCompatActivity() {

    lateinit var calendarView: CalendarView
    lateinit var deleteFab: Button
    lateinit var doneFab: Button
    lateinit var todoEditText: EditText
    lateinit var subEditText: EditText
    lateinit var input_bank:EditText

    val loginRealm = try {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }

    val realm= try {
        //Realm 인스턴스 얻기
        //오류에 대비하여 예외처리
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    } //Realm 인스턴스 얻기
    //캘린더 객체 생성(오늘 날짜로 초기화됨)
    val calendar: Calendar = java.util.Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_list_add)

        calendarView = findViewById(R.id.calendarView)
        todoEditText = findViewById(R.id.input_num)
        subEditText = findViewById(R.id.input_money)
        deleteFab = findViewById(R.id.deleteFab)
        doneFab = findViewById(R.id.doneFab)
        input_bank=findViewById(R.id.input_bank)

        // 인텐트로 id를 전달해서 데이터 베이스의 삽입/변경/삭제를 분기
        // id=-1 (추가모드)
        val id=intent.getLongExtra("id",-1L)
        if (id==-1L){
            insertMode()
        }else{
            updateMode(id)
        }

        /*
        // 캘린더 뷰의 날짜를 선택했을 때 캘린더 객체에 설정
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            calendar.set(java.util.Calendar.YEAR, year)
            calendar.set(java.util.Calendar.MONTH, month)
            calendar.set(java.util.Calendar.DAY_OF_MONTH, dayOfMonth)
            datePickText.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
        }
         */
    }


    //추가모드
    private fun insertMode(){
        deleteFab.visibility= View.GONE
        doneFab.setOnClickListener { insertTodo() }
    }
    //삭제모드
    private fun updateMode(id:Long){
        //id에 해당하는 객체를 화면에 표시
        val todo=realm.where<Todo>().equalTo("id",id).findFirst()!!
        todoEditText.setText(todo.account_list_out_number)
        subEditText.setText(todo.account_list_out_money)
        calendarView.date=todo.date //오늘 날짜
        input_bank.setText(todo.account_list_bank)

        //삭제 버튼 클릭시 deleteTodo() 호출
        deleteFab.setOnClickListener { deleteTodo(id) }
        doneFab.visibility=View.GONE    //열람시에는 수정 불가
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close() //Realm 인스턴스 해제
    }

    private fun insertTodo(){ //데이터베이스 삽입
        realm.beginTransaction()  //트랜잭션 시작
        val newItem=realm.createObject<Todo>(nextId())

        var userid=intent.getStringExtra("userid")
        val person = loginRealm.where<Person>().equalTo("id", userid).findFirst()

        if(person!!.money>=subEditText.text.toString().toInt()) {
            person!!.money -= subEditText.text.toString().toInt()
            newItem.account_list_out_number = todoEditText.text.toString()
            newItem.account_list_out_money = subEditText.text.toString()
            newItem.date = calendar.timeInMillis
            newItem.username = person!!.id
            newItem.usermoney = person!!.money
            newItem.account_list_bank=input_bank.text.toString()

            alert(person.id + "님 이체가 완료 되었습니다.") {
                yesButton { finish() }
            }.show()
        }else{
            alert("계좌 이체 실패: 잔액이 부족합니다") {
                yesButton { finish() }
            }.show()
        }
        realm.commitTransaction() //트랜잭션 종료
    }



    // 데이터 베이스 할 일 삭제
    private fun deleteTodo(id: Long) {
        realm.beginTransaction()

        val deleteItem = realm.where<Todo>().equalTo("id", id).findFirst()!!
        deleteItem.deleteFromRealm()

        realm.commitTransaction()

        alert("이체 내역이 삭제되었습니다.") {
            yesButton { finish() }
        }.show()
    }

    // Realm은 자동 키 증가를 지원하지 않으므로 아래 메서드를 만들었음
    private fun nextId() : Int {
        val maxId = realm.where<Todo>().max("id")
        // where<Todo>() : 테이블의 모든 값을 얻어옴
        // .max(필드명) : 현재 '필드명'중 가장 큰 값을 얻음 (Number형)

        if (maxId != null) {
            return maxId.toInt() + 1
        }
        return 0
    }


}