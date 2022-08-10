package com.example.bankofthebest.mypage

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R
import com.example.bankofthebest.login.LoginActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.where
import com.example.bankofthebest.login.Person
import com.example.bankofthebest.todo.Todo

class loginCheckActivity: AppCompatActivity(){
    lateinit var pwd: EditText
    lateinit var btn_check_pwd:Button

    //var loginRealm: Realm?=null
    var handler: Handler? = null

    val loginRealm = try {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_check_activity)

        //액션바 숨기기
        var actionBar:ActionBar?
        actionBar=supportActionBar
        actionBar?.hide()

        handler = Handler()

        val id=intent.getStringExtra("userid")
        pwd=findViewById(R.id.pwd_check)
        btn_check_pwd=findViewById(R.id.btn_check_pwd)

        //버튼 클릭시 alert Dialog 발생
        btn_check_pwd.setOnClickListener {
            var dialog = AlertDialog.Builder(this)
            dialog.setTitle(" 회원 탈퇴하시겠습니까? ")
            dialog.setMessage("확인 버튼을 누르실 경우, 회원님의 소중한\n개인정보가 모두 삭제됩니다.")
            dialog.setIcon(R.mipmap.icon_launcher)

            fun toast_p() {
                login(id.toString())
                //deleteTodo(id as String)
            }
            fun toast_n(){
                super.onBackPressed()
            }

            var dialog_listener = object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when(which){ //확인시 삭제
                        DialogInterface.BUTTON_POSITIVE ->
                            toast_p()
                        DialogInterface.BUTTON_NEGATIVE ->
                            toast_n()
                    }
                }
            }

            dialog.setPositiveButton("탈퇴하기",dialog_listener)
            dialog.setNegativeButton("취소",dialog_listener)
            dialog.show()
        }
    }

    fun login(id: String){
        val pwd=pwd.text.toString()

        val person=loginRealm?.where(Person::class.java)!!
            .equalTo("id", id)
            .equalTo("pwd", pwd)
            .findFirst()

        if(person!=null){
            deleteTodo(id)
        }else{
            Toast.makeText(this,"로그인 정보가 없거나 틀립니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginRealm?.close()
    }

    // 데이터 베이스 이체 내역 삭제
    private fun deleteTodo(id: String) {
        loginRealm.beginTransaction()

        val deleteUser = loginRealm.where<Person>().equalTo("id", id).findFirst()!!
        deleteUser.deleteFromRealm()
        val deleteTodo=loginRealm.where<Todo>().equalTo("username", id).findAll()
        deleteTodo.deleteAllFromRealm()

        loginRealm.commitTransaction()

        finishAffinity() //어플을 종료시키고 intent 전달
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        System.exit(0)
    }
}