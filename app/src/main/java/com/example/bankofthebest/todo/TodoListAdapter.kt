package com.example.bankofthebest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bankofthebest.todo.Todo
import io.realm.OrderedRealmCollection
import io.realm.RealmBaseAdapter

class TodoListAdapter(realmResult: OrderedRealmCollection<Todo>)
    : RealmBaseAdapter<Todo>(realmResult){//RealmBaseAdapter 상속

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vh: ViewHolder
        val view: View

        if(convertView==null){
            //xml 레이아웃 파일을 불러와서 뷰로 전환시킴
            view= LayoutInflater.from(parent?.context).inflate(R.layout.account_list_item,parent, false)
            vh=ViewHolder(view)
            view.tag=vh
        }else{
            view=convertView
            vh=view.tag as ViewHolder
            //view.tag는 Any형이므로 ViewHolder 타입으로 형변환
        }
        if(adapterData!=null){
            val item=adapterData!![position]
            vh.textTextView.text=item.title
            vh.subTextView.text=item.subtitle
            vh.dateTextView.text = android.text.format.DateFormat.format("yyyy/MM/dd", item.date)
        }
        return view
    }

    override fun getItemId(position: Int): Long {
        if (adapterData!= null) {
            return adapterData!![position].id
            // adapterView가 Realm 데이터를 가지고 있으므로
            // 해당 위치의 id를 반환해줘야 함
        }
        return super.getItemId(position)
    }
}
class ViewHolder(view: View) {
    val dateTextView: TextView = view.findViewById(R.id.account_date)
    val textTextView: TextView = view.findViewById(R.id.account_list_out_money)
    val subTextView: TextView = view.findViewById(R.id.account_list_out_number)
}