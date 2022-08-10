package com.example.bankofthebest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bankofthebest.login.Person
import com.example.bankofthebest.todo.Todo
import io.realm.OrderedRealmCollection
import io.realm.Realm
import io.realm.RealmBaseAdapter
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmMigrationNeededException
import io.realm.kotlin.where

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
            vh.account_list_out_number.text=item.account_list_out_number
            vh.account_list_out_money.text="-"+item.account_list_out_money+"원"
            vh.account_date.text = android.text.format.DateFormat.format("yyyy/MM/dd", item.date)
            vh.account_list_money.text=item.usermoney.toString()+"원"
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
    val account_date: TextView = view.findViewById(R.id.account_date)
    val account_list_out_money: TextView = view.findViewById(R.id.account_list_out_money)
    val account_list_out_number: TextView = view.findViewById(R.id.account_list_out_number)
    val account_list_money: TextView = view.findViewById(R.id.account_list_money)
}