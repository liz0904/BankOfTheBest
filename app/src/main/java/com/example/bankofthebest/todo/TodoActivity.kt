package com.example.bankofthebest.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R
import com.example.bankofthebest.TodoListAdapter
import com.example.bankofthebest.login.Person
import com.example.bankofthebest.mypage.mypageMainActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.Sort
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.where
import org.jetbrains.anko.startActivity

class TodoActivity : AppCompatActivity() {

        lateinit var listView: ListView
        lateinit var text_account_list_name:TextView
        lateinit var text_account_list_money:TextView
        lateinit var text_account_number:TextView
        lateinit var btn_account_out_in:Button

    val loginRealm = try {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }

        val realm = try {
            //Realm 인스턴스 얻기
            //오류에 대비하여 예외처리
            val config = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
            Realm.getInstance(config)
        } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_activity)

        listView=findViewById(R.id.listView)
        text_account_list_name=findViewById(R.id.text_account_list_name)
        text_account_number=findViewById(R.id.text_account_number)
        text_account_list_money=findViewById(R.id.text_account_list_money)
        btn_account_out_in=findViewById(R.id.btn_account_out_in)

        val userid=intent.getStringExtra("userid")
        val person = realm.where<Person>().equalTo("id", userid).findFirst()
        if (person != null) {
            text_account_list_name.text = person.id+"님의 급여통장"
            text_account_number.text=person.account
            text_account_list_money.text=person.money.toString()+"원"
        }

        //할 일 추가 버튼 클릭 리스너
        btn_account_out_in.setOnClickListener { view ->
            var intent_choice=Intent(this, ChoiceBankActivity::class.java)
            intent_choice.putExtra("userid", person!!.id)
            startActivity(intent_choice)
        }

        val realmResult = realm.where<Todo>().equalTo("username", person!!.id).findAll().sort("date", Sort.ASCENDING)
        // 할 일 목록을 날짜순으로 모두 가져옴

        val adapter = TodoListAdapter(realmResult)  // 할 일 목록이 담긴 어댑터 생성
        listView.adapter = adapter    // 어댑터 지정 (이 때 목록이 출력됨)

        realmResult.addChangeListener { _ -> adapter.notifyDataSetChanged() }  // 데이터가 변경될 경우 어댑터에 적용됨
        // notifyDataSetChanged() : 데이터 변경을 통지하여 목록을 다시 출력함
        listView.setOnItemClickListener { parent, view, position, id ->   // 리스트 뷰 아이템 클릭시 처리
            startActivity<EditTodoActivity>("id" to id)   // 기존 id 존재 여부에 따라 새 할 일 추가 또는 수정
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}