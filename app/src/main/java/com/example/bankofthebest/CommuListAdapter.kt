package com.example.bankofthebest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bankofthebest.community.CommuDB
import io.realm.RealmBaseAdapter
import io.realm.RealmResults

class CommuListAdapter(realmResult: RealmResults<CommuDB>)
    : RealmBaseAdapter<CommuDB>(realmResult){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vh : ViewHoler_commu
        val view : View

        if (convertView==null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.community_list,parent, false)
            vh = ViewHoler_commu(view)
            view.tag=vh
        }else{
            view=convertView
            vh=view.tag as ViewHoler_commu
        }
        if(adapterData!=null){
            val item=adapterData!![position]
            vh.titleTextView_commu.text = item.title
            vh.nameTextView_commu.text = item.name
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

class ViewHoler_commu(view: View){
    val titleTextView_commu : TextView = view.findViewById(R.id.tvTitle_commu)
    val nameTextView_commu : TextView = view.findViewById(R.id.tvName_commu)
}