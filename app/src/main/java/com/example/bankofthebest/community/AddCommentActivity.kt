package com.example.bankofthebest.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.bankofthebest.R
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton
import java.util.*

class AddCommentActivity : AppCompatActivity() {

    lateinit var add_editText:EditText
    lateinit var button:Button
    lateinit var button2:Button

    val realm1 = try {//Realm 인스턴스 얻기
        //오류에 대비하여 예외처리
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }
    //캘린더 인스턴스 가져오기
    val calendar: Calendar = java.util.Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_comment_add)

        add_editText=findViewById(R.id.add_editText)
        button=findViewById(R.id.button)
        button2=findViewById(R.id.button2)

        // 인텐트로 id를 전달해서 데이터 베이스의 삽입/변경/삭제를 분기
        // id=-1 (추가모드)

        val id=intent.getLongExtra("id",-1L)
        if (id==-1L){
            insertMode_addcomment()
        }else{
            updateMode_addcomment(id)
        }
        //버튼 클릭시 이전화면으로 넘어간다.
        button.setOnClickListener {  super.onBackPressed()}
    }

    //버튼을 누를경우 insertTodo함수 호출
    private fun insertMode_addcomment(){
        button2.setOnClickListener { insertTodo_addcomment() }
    }

    private fun updateMode_addcomment(id:Long){
        val comment=realm1.where<Commu_commentDB>().equalTo("id",id).findFirst()!!
        add_editText.setText(comment.comment)

        button2.setOnClickListener { updateTodo_addcomment(id) }
    }
    override fun onDestroy() {
        super.onDestroy()
        realm1.close() //realm을 해제한다.
    }

    //댓글을 데이터베이스에 삽입하는 함수
    private fun insertTodo_addcomment(){
        realm1.beginTransaction()
        val newItem=realm1.createObject<Commu_commentDB>(nextId())
        newItem.comment=add_editText.text.toString()
        newItem.date=calendar.timeInMillis

        //트랜잭션을 종료
        realm1.commitTransaction()
        alert("댓글이 저장 되었습니다."){
            yesButton { finish() }
        }.show()
    }

    private fun updateTodo_addcomment(id:Long){
        realm1.beginTransaction()
        val updateItem = realm1.where<Commu_commentDB>().equalTo("id", id).findFirst()!!
        updateItem.comment=add_editText.text.toString()
        updateItem.date=calendar.timeInMillis

        realm1.commitTransaction()

        alert("댓글이 변경 되었습니다") {
            yesButton { finish() }
        }.show()
    }

    // Realm은 자동 키 증가를 지원하지 않으므로 아래 메서드를 만들었음
    private fun nextId() : Int {
        val maxId = realm1.where<Commu_commentDB>().max("id")
        // where<Todo>() : 테이블의 모든 값을 얻어옴
        // .max(필드명) : 현재 '필드명'중 가장 큰 값을 얻음 (Number형)

        if (maxId != null) {
            return maxId.toInt() + 1
        }
        return 0
    }
}