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
import org.jetbrains.anko.startActivity


class mypageMainActivity : AppCompatActivity() {
    lateinit var id_my: TextView
    lateinit var email_my: TextView
    lateinit var phone_my:TextView

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
        phone_my=findViewById(R.id.phone_my)

        layout_out=findViewById(R.id.layout_out)
        layout_quit=findViewById(R.id.layout_quit)

        handler = Handler()

        //Realm 데이터베이스 가져오기
        var userid=intent.getStringExtra("userid")
        val person=loginRealm.where<Person>().equalTo("id", userid.toString()).findFirst()

        if (person != null) {
            id_my.text= getStringMasking(person.id)
            email_my.text=getStringMasking(person.email)
            phone_my.text="010-"+getStringMasking(person.phone)
        }

        //버튼 클릭시 비밀번호 확인 페이지로 이동
        layout_out.setOnClickListener {
            var intent_user=Intent(this, loginCheckActivity::class.java)
            intent_user.putExtra("userid", userid)
            startActivity(intent_user)
        }

        layout_quit?.setOnClickListener {//어플 로그아웃
            finishAffinity()
            startActivity<LoginActivity>()
            System.exit(0)}

    }

    fun getStringMasking(string: String): String {
        val user_mail=string
        val change='*'
        if(user_mail.length>3) {
            val sb = StringBuilder(user_mail).also { it.setCharAt(0, change) }
            val sb1 = StringBuilder(sb).also { it.setCharAt(1, change) }
            val sb2 = StringBuilder(sb1).also { it.setCharAt(2, change) }
            val sb3 = StringBuilder(sb2).also { it.setCharAt(2, change) }
            return sb3.toString()
        }
        else{
            val sb = StringBuilder(user_mail).also { it.setCharAt(0, change) }
            return sb.toString()
        }
    }
}