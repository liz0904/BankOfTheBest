package com.example.bankofthebest.event

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R

class EventItemActivity : AppCompatActivity() {

    lateinit var mainImageView: ImageView
    lateinit var title:TextView
    lateinit var content:TextView
    lateinit var detail:TextView
    lateinit var webBtn:ImageButton
    lateinit var shareBtn:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_content)

        mainImageView=findViewById(R.id.imageViewSub)
        title=findViewById(R.id.titleSub)
        content=findViewById(R.id.contentSub)
        detail=findViewById(R.id.detailSub)
        webBtn=findViewById(R.id.webBtn)
        shareBtn=findViewById(R.id.shareBtn)
        val link_tmp=intent.getStringExtra("link")

        if(intent.hasExtra("title")){
            title.text=intent.getStringExtra("title")
            content.text=intent.getStringExtra("content")
            detail.text=intent.getStringExtra("detail")
            mainImageView.setImageResource(intent.getIntExtra("mainImageView", R.drawable.defaultimg))

        }

        //홈페이지 연결
        webBtn.setOnClickListener {
            if(link_tmp.equals("empty")){
                Toast.makeText(this, "등록된 홈페이지가 없습니다.", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, WebViewActivity::class.java)
                intent.putExtra("link", link_tmp)
                startActivity(intent)
            }
        }

        //공유하기
        shareBtn.setOnClickListener {
            Toast.makeText(this, "메시지로 공유하기", Toast.LENGTH_SHORT).show()

            val intent=Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            if(link_tmp.equals("empty")) {
                //링크가 등록 안되어 있으면 행사 제목 보내기
                intent.putExtra(Intent.EXTRA_TEXT, title.text.toString())
            }else{
                //링크가 등록 되어 있으면 행사 홈페이지 보내기
                intent.putExtra(Intent.EXTRA_TEXT, link_tmp.toString())
            }
            val shareIntent=Intent.createChooser(intent, null)
            startActivity(shareIntent)
        }



    }
}