package com.example.bankofthebest.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException

class  JoinActivity : AppCompatActivity(){

    lateinit var joinId: EditText
    lateinit var joinPwd: EditText
    lateinit var joinEmail: EditText
    lateinit var joinIdCheck: Button
    lateinit var joinDone: Button
    lateinit var joinName:EditText
    lateinit var joinPhone:EditText


    val loginRealm = try {
        val config = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.getInstance(config)
    } catch (ex: RealmMigrationNeededException) {
        Realm.getDefaultInstance()
    }
    var handler: Handler? = null
    var idCheck: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_join)

        //액션바 숨기기
        var actionBar: ActionBar?
        actionBar=supportActionBar
        actionBar?.hide()

        handler = Handler()

        joinId = findViewById(R.id.joinId)
        joinPwd = findViewById(R.id.joinPwd)
        joinEmail = findViewById(R.id.joinEmail)
        joinIdCheck = findViewById(R.id.joinIdCheck)
        joinDone = findViewById(R.id.joinDone)
        joinName=findViewById(R.id.joinName)
        joinPhone=findViewById(R.id.joinPhone)

        //아이디 중복확인
        joinIdCheck.setOnClickListener {
            loginRealm?.executeTransactionAsync {
                if (it.where(Person::class.java).equalTo("id", joinId.text.toString()).count() > 0) {
                    handler?.post(Runnable {
                        Toast.makeText(this, "실패: 동일한 id가 존재합니다.", Toast.LENGTH_SHORT).show()
                        idCheck = false
                    })
                } else {
                    handler?.post(Runnable {
                        Toast.makeText(this, "사용 가능한 id 입니다.", Toast.LENGTH_SHORT).show()
                        idCheck = true
                    })
                }
            }
        }

        joinDone.setOnClickListener {
            join()
        }

    }


    fun join() {
        loginRealm?.executeTransactionAsync {
                            if (idCheck&&joinPwd.text.isNotEmpty()&&joinId.text.toString().length>=4&&joinPwd.text.toString().length>=10) {
                                handler?.post(Runnable {
                                    Toast.makeText(this, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                                })
                                val user = it.createObject(Person::class.java)
                                user.id = joinId.text.toString()
                                user.pwd = joinPwd.text.toString()
                                user.username=joinName.text.toString()
                                user.email = joinEmail.text.toString()
                                user.phone=joinPhone.text.toString()
                                user.account="0904-"+joinPhone.text.toString()

                                var intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                            } else {
                                handler?.post(Runnable {
                                    if(joinId.text.toString().length<4) {
                                        Toast.makeText(this, "아이디가 너무 짧습니다", Toast.LENGTH_SHORT).show()
                                    }else if(joinPwd.text.toString().length<10){
                        Toast.makeText(this, "비밀번호가 너무 짧습니다", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this, "아이디/비밀번호를 다시 확인하세요", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}