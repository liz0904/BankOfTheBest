package com.example.bankofthebest.event

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddPostActivity: AppCompatActivity() {

    lateinit var titlePost:EditText
    lateinit var objectPost:EditText
    lateinit var hostPost:EditText
    lateinit var timePost:EditText
    lateinit var linkPost:EditText
    lateinit var detailPost:EditText
    lateinit var submitBtn:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_add_floating)

        titlePost=findViewById(R.id.titlePost)
        objectPost=findViewById(R.id.objectPost)
        hostPost=findViewById(R.id.hostPost)
        timePost=findViewById(R.id.timePost)
        linkPost=findViewById(R.id.linkPost)
        detailPost=findViewById(R.id.detailPost)
        submitBtn=findViewById(R.id.submitBtn)

        submitBtn.setOnClickListener {
            Toast.makeText(this, "게시글 업로드", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, EventListActivity::class.java)
            intent.putExtra("title", titlePost.text.toString())
            intent.putExtra("content", "대상: "+objectPost.text+"\n주최/주관: "+hostPost.text+"\n모집 기간: "+timePost.text)
            intent.putExtra("sort", "스터디/동아리")
            intent.putExtra("detail", detailPost.text.toString())
            intent.putExtra("mainImageView", "defaultimg")
            intent.putExtra("link", linkPost.text.toString())
            startActivity(intent)
        }
    }


}