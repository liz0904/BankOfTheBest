package com.example.bankofthebest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bankofthebest.community.Commu_commentDB
import io.realm.RealmBaseAdapter
import io.realm.RealmResults

class CommentListAdapter(realmResult: RealmResults<Commu_commentDB>)
    :RealmBaseAdapter<Commu_commentDB>(realmResult) {
    //RealmBaseAdapter 상속

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val vh: ViewHolder_comment
        val view: View

        if(convertView==null){
            //xml 레이아웃 파일을 불러와서 뷰로 전환시킴
            view=LayoutInflater.from(parent?.context).inflate(R.layout.community_item_content,parent, false)
            vh=ViewHolder_comment(view)
            view.tag=vh
        }else{
            view=convertView
            vh=view.tag as ViewHolder_comment //view.tag는 Any형이므로 ViewHolder 타입으로 형변환
        }
        if(adapterData!=null){
            val item=adapterData!![position]
            vh.commentTextView.text=item.comment
            vh.dateCommentTextView.text= android.text.format.DateFormat.format("yyyy/MM/dd", item.date)
        }
        return view
    }

    override fun getItemId(position: Int): Long { //position을 getItemId 통해서 받아와 지정해줌.
        if(adapterData!=null){
            return adapterData!![position].id
        }
        return super.getItemId(position)
    }
}

class ViewHolder_comment(view: View){
    val commentTextView: TextView=view.findViewById(R.id.comment_commu)
    val dateCommentTextView: TextView=view.findViewById(R.id.commenttime_commu)
}