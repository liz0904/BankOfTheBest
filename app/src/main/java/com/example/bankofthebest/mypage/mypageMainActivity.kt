package com.example.bankofthebest.mypage

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R
import com.example.bankofthebest.login.LoginActivity
import com.example.bankofthebest.login.Person
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.where


class mypageMainActivity : AppCompatActivity() {
    lateinit var id_my: TextView
    lateinit var email_my: TextView

    lateinit var app_finish: Button
    lateinit var layout_out: View
    lateinit var layout_quit: View

    val loginRealm = try {
        //Realm 인스턴스 얻기
        //오류에 대비하여 예외처리
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }

    var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage_activity_main)

        id_my=findViewById(R.id.id_my)
        email_my=findViewById(R.id.email_my)

        layout_out=findViewById(R.id.layout_out)
        layout_quit=findViewById(R.id.layout_quit)

        handler = Handler()

        //Realm 데이터베이스 가져오기
        val person=loginRealm.where<Person>().findFirst()

        if (person != null) {
            id_my.text= person.id
            email_my.text=person.email
        }

        //버튼 클릭시 alert Dialog 발생
        layout_out.setOnClickListener {
            var dialog = AlertDialog.Builder(this)
            dialog.setTitle(" 회원 탈퇴하시겠습니까? ")
            dialog.setMessage("확인 버튼을 누르실 경우, 회원님의 소중한\n개인정보가 모두 삭제됩니다.")
            dialog.setIcon(R.mipmap.ic_launcher)

            fun toast_p() {
                deleteTodo(id_my.text as String)
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

            dialog.setPositiveButton("확인",dialog_listener)
            dialog.setNegativeButton("취소",dialog_listener)
            dialog.show()
        }

        layout_quit?.setOnClickListener {//어플을 종료 및 로그아웃
            finishAffinity()
            System.runFinalization()
            System.exit(0)}

    }


    // 데이터 베이스 할 일 삭제
    private fun deleteTodo(id: String) {

        loginRealm.beginTransaction()
        val deleteItem = loginRealm.where<Person>().equalTo("id", id).findFirst()!!
        deleteItem.deleteFromRealm()
        loginRealm.commitTransaction()

        finishAffinity() //어플을 종료시키고 intent 전달
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        System.exit(0)
    }
}