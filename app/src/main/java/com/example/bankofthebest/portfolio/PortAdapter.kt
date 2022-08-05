package com.example.bankofthebest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bankofthebest.portfolio.portDB
import io.realm.OrderedRealmCollection
import io.realm.RealmBaseAdapter

// port_content_main.xml의 리스트뷰를 이용하기 위한 Adapter
// 리스트뷰에는 port_list.xml의 형식으로 내용을 추가함

class PortAdapter (realmResult: OrderedRealmCollection<portDB>)
    : RealmBaseAdapter<portDB>(realmResult) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vh : ViewHolderPort
        val view : View

        if (convertView==null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.port_list,parent, false)
            vh = ViewHolderPort(view)
            view.tag=vh
        }else{
            view=convertView
            vh=view.tag as ViewHolderPort
        }
        if(adapterData!=null){
            val item=adapterData!![position]
            vh.titleTextView_port.text = item.title
            vh.dateTextView_port.text = item.date
        }
        return view
    }

    override fun getItemId(position: Int): Long {
        if (adapterData!=null){
            return adapterData!![position].id
        }
        return super.getItemId(position)
    }
}

// 뷰의 내용을 업데이트하기 위한 ViewHolder
class ViewHolderPort(view: View) {
    val titleTextView_port : TextView = view.findViewById(R.id.tvTitle_port)
    val dateTextView_port : TextView = view.findViewById(R.id.tvDate_port)
}