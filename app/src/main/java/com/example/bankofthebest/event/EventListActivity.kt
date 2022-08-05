package com.example.bankofthebest.event

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.bankofthebest.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EventListActivity : AppCompatActivity() {

    lateinit var listView:ListView
    lateinit var allBtn:Button
    lateinit var contestBtn:Button
    lateinit var eduBtn:Button
    lateinit var volunteerBtn:Button
    lateinit var studyBtn:Button
    lateinit var otherBtn:Button
    lateinit var addBtn:FloatingActionButton

    var contentList= arrayListOf<ContentClass>(
        ContentClass("2021 MZ 인공지능 해커톤 대회",
            "대상: 일반인, 대학생\n" +
                    "주최: 한국지능정보사회 진흥원\n" +
                    "모집 기간: 2021.01.11~2021.01.24",
            "대회/공모전",
            "*공모 및 접수 : 2021. 1. 11(월) ~ 1. 24(일)\n" +
                    "* 참가접수 :  대학(원)생, 관련분야 종사자 및 일반인(국내 거주 외국인 포함)으로 구성된 팀\n" +
                    "* 해외거주 한국인 참가 불가\n" +
                    "* 기존 진행되었던 인공지능 해커톤 대회(AI 장치용 STT를 위한 의도분류) 참가자는 중복참여 불가(기존 대회에 신청 후 제출을 하지 않았다 하더라도 이번 대회 참가 불가)\n" +
                    "* 공모전 도전자들에게 전하고 싶은 말은? 많은 참여 부탁드립니다.",
            "mz_hackathon",
            "https://mzhackathonmedical.co.kr/mzmedical/"),

        ContentClass("2021년 굿네이버스 대구경북본부 대학생자원봉사동아리 한빛 모집",
            "대상: 대학생\n" +
                    "주최: 굿네이버스 대구경북본부\n" +
                    "모집 기간: 20201.02.05~2021.02.24",
            "봉사활동",
            "* 활동내용\n" +
                    "1) 팀별활동 : 세계시민교육 강사, 희망원정대, 사회공헌캠페인\n" +
                    "2) 전체활동 : 발대식, 체육대회, 단합회, 송년회 \n" +
                    "* 활동특전\n" +
                    "1) 수료증 발급\n" +
                    "2) 우수자원봉사자 표창장 수여\n" +
                    "3) VMS자원봉사시간 등록\n" +
                    "4) 특강(취업, NGO관련, 기타 외부 특강)\n" +
                    "5) 다양한 인적 네트워크 형성 및 소정의 기념품 제공",
            "goodvolun",
            "http://daegukb.goodneighbors.kr/gndaegukb/b"),

        ContentClass("ICT콤플렉스 앱개발 챌린지",
            "대상: ICT콤플렉스 멤버\n" +
                    "주최: 과학기술정보통신부\n" +
                    "모집 기간: 2020.11.26~2020.12.09",
            "대회/공모전",
            "사회적 약자가 일상생활에서 겪는 불편과 차별 등 해결이 시급한 문제들을 ICT콤플렉스 이용자들과 함께 고민하며 이를 해소하기 위한 창의적인 아이디어를 발굴하고자 2020 ICT콤플렉스 앱개발 챌린지를 개최합니다!\n" +
                    "우수한 개발능력을 가진 분들의 많은 참여 바랍니다.\n" +
                    "‘I Create Tomorrow at CoC’\n" +
                    "■ 공모주제 : 사회적 약자의 일상생활 속 문제 해결을 위한 앱/웹 개발\n" +
                    "- 사회적 약자의 일상생활과 관련한 불편 해소 및 차별 극복 등을 위한 서비스 개발\n" +
                    "- 개인 또는 팀(최대 4명)으로 지원",
            "ictchallenge",
            "http://www.ictcoc.kr/03_pro_n/pro01_view.asp?idx=73"),

        ContentClass("2021 서울여대 SW 에듀 서포터즈 모집",
            "대상: 서울여대 소중대 학생\n" +
                    "주최: 서울여자대학교 sw중심사업단\n" +
                    "모집 기간: 2020/02/02~2020/02/02",
            "봉사활동",
            "아두이노를 활용한 sw에 대해 고등학생들에게 교육을 함.\n" +
                    "봉사활동 시간 10시간 이상 시, 수료 및 20만원 지급",
            "",
            ""),

        ContentClass("2021 SW 마에스트로 12기 연수생 모집",
            "대상: SW개발 분야에 열정,재능을 보유한 자\n" +
                    "주최: 정보통신기획평가원 \n" +
                    "모집 기간: 2021. 1.18.10:00 ~ 2.18.17:00",
            "교육",
            "(1) 응시자가 선택한 SW 개발 언어*에 대한 문제은행 기반의 온라인 코딩 테스트(120분)를 진행\n" +
                    "  * C, C++, Python, C#, JAVA 등 개발언어 중 선택(총 15개 내외 언어를 제공하며, 지원자는 제공 언어 중 택1)\n" +
                    " (2) 알고리즘, SQL, 웹 프로그래밍으로 출제 예정\n" +
                    " (3) 지원자는 자택 등 고정된 장소에서 온라인으로 응시하며, 세부 일시, 응시방법, 유의사항은 대상자에게 사전 안내 예정",
            "soma",
            "http://www.swmaestro.org"),

        ContentClass("k-shield 보안사고 분석대응 과정",
            "대상: 고등,대학 최종학력 재학생 및 미취업 졸업자\n" +
                    "주최: 한국정보보호교육센터\n" +
                    "모집 기간: 2021.01.18~2021.02.15",
            "교육",
            "보안관제(CERT), 침해사고 및 악성코드 분석,\n" +
                    "보안솔루션 개발 분야로 취업이 가능하며\n" +
                    "보안사고 발생시 문제 원인을 파악하고 조치할 수 있는\n" +
                    "인재로 양성됩니다.",
            "k_shield",
            "http://http://www.kshieldjr.org/tlnt_mu01_002.do"),

        ContentClass("정보보호소학회 SWLUG 신입생 모집",
            "대상: 서울여대 정보보호학과 학우\n" +
                    "주최: 서울여대 소학회\n" +
                    "모집 기간: 2021.02.25~2021.03.03",
            "스터디/동아리",
            "Seoul Woment's univ Linux User Group의 약자로, 보안 및 개발 등 다양한 전공지식에 대해 공부하는 학회입니다.\n" +
                    "모집인원: 13명\n" +
                    "활동내용: 인코그니토 연구, 세미나 발표, CTF 문제풀이",
            "swlug",
            ""),
        ContentClass("2021 제 3회 밀크T 창작동화 공모전",
            "대상: 일반인, 대학생, 청소년\n" +
                    "주최: 천재교육\n" +
                    "모집 기간: 2021.03.02~2021.03.10",
            "기타",
            "동화를 통해 아이들은 새로운 시각으로 세상을 바라보고, 더 넓은 곳으로 나아갈 수 있는 힘을 얻습니다." +
                    "밀크T는 아이들을 꿈꾸게 하는 동화를 찾고 있습니다. 작가님들의 많은 응모 바랍니다.\n" +
                    "*참여 방법\n" +
                    "-응모신청서 및 원고를 제공하는 양식을 다운로드하여 작성 후 온라인으로 접수(밀크T 홈페이지 응모하기 버튼 클릭)\n" +
                    "* 1인당 출품작 수 제한 없음. 단, 수상은 1인 1작품에 한함.",
            "milk_t",
            "http://www.milkt.co.kr/Partner/Partner201204")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_item_floating)

        listView = findViewById(R.id.listview)
        contestBtn=findViewById(R.id.contestBtn)
        volunteerBtn=findViewById(R.id.volunteerBtn)
        studyBtn=findViewById(R.id.studyBtn)
        allBtn=findViewById(R.id.allBtn)
        otherBtn=findViewById(R.id.otherBtn)
        eduBtn=findViewById(R.id.eduBtn)
        addBtn=findViewById(R.id.addBtn)

        //AddPostActivity에서 넘어온 intent데이터를 contentList 배열에 추가
        if(intent.hasExtra("title")){
            contentList.add(
                ContentClass(intent.getStringExtra("title").toString(),
                    intent.getStringExtra("content").toString(),
                    intent.getStringExtra("sort").toString(),
                    intent.getStringExtra("detail").toString(),
                    intent.getStringExtra("mainImageView").toString(),
                    intent.getStringExtra("link").toString()
                )
            )
        }


        var tmp=contentList
        listView.adapter= ListViewAdapter(this, tmp)
        ListViewAdapter(this, tmp).notifyDataSetChanged()

        //Item click listener
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            //val selectItem = parent.getItemAtPosition(position) as String
            //selectName.text = selectItem
            //Toast.makeText(this, MyCustomAdapter(this).getItem(position).toString(), Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "자세한 내용 확인", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, EventItemActivity::class.java)
            intent.putExtra("title", ListViewAdapter(this, tmp).getTitleView(position))
            intent.putExtra("content", ListViewAdapter(this, tmp).getContentView(position))
            intent.putExtra("detail", ListViewAdapter(this, tmp).getDetailView(position))
            intent.putExtra("mainImageView", ListViewAdapter(this, tmp).getImageView(position))
            intent.putExtra("link", ListViewAdapter(this, tmp).getLink(position))
            startActivity(intent)
        }

        allBtn.setOnClickListener {
            listView.adapter = ListViewAdapter(this, tmp)

            for (i in 0..contentList.size - 1) {
                tmp[i].bool = true
            }
        }
        contestBtn.setOnClickListener {
            listView.adapter = ListViewAdapter(this, tmp)

            for (i in 0..contentList.size - 1) {
                tmp[i].bool = tmp[i].sort.equals("대회/공모전")
            }
        }
        volunteerBtn.setOnClickListener {
            listView.adapter= ListViewAdapter(this, tmp)

            for(i in 0..contentList.size-1){
                tmp[i].bool = tmp[i].sort.equals("봉사활동")
            }
        }
        studyBtn.setOnClickListener {
            listView.adapter= ListViewAdapter(this, tmp)

            for(i in 0..contentList.size-1){
                tmp[i].bool = tmp[i].sort.equals("스터디/동아리")
            }
        }
        eduBtn.setOnClickListener {
            listView.adapter= ListViewAdapter(this, tmp)

            for(i in 0..contentList.size-1){
                tmp[i].bool = tmp[i].sort.equals("교육")
            }
        }
        otherBtn.setOnClickListener {
            listView.adapter= ListViewAdapter(this, tmp)

            for(i in 0..contentList.size-1){
                tmp[i].bool = tmp[i].sort.equals("기타")
            }
        }
        addBtn.setOnClickListener {
            Toast.makeText(this, "스터디/동아리 추가하기", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, AddPostActivity::class.java)
            startActivity(intent)
        }
    }
}
