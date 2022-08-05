package com.example.bankofthebest.event

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.bankofthebest.R

class ListViewAdapter(val context: Context, val contentClassList:ArrayList<ContentClass>) : BaseAdapter() {
    override fun getCount(): Int {
        return contentClassList.size
    }

    override fun getItem(position: Int): Any {
        return contentClassList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View=LayoutInflater.from(context).inflate(R.layout.event_listitem, null)

        val mainImageView=view.findViewById<ImageView>(R.id.mainImageView)
        val titleTextView=view.findViewById<TextView>(R.id.titleTextView)
        val contentTextView=view.findViewById<TextView>(R.id.contentTextView)
        val sort=view.findViewById<TextView>(R.id.sort)

        val contest=contentClassList[position]
        val resourceId=context.resources.getIdentifier(contest.mainImageView, "drawable", context.packageName)

        if(contest.bool){
            mainImageView.setImageResource(resourceId)
            titleTextView.text=contest.title
            contentTextView.text=contest.content
            sort.text=contest.sort
        }else{
            mainImageView.visibility=View.GONE
            titleTextView.visibility=View.GONE
            contentTextView.visibility=View.GONE
            sort.visibility=View.GONE
            view.visibility=View.GONE
        }
        return view
    }

    fun getTitleView(position: Int):String{
        return contentClassList[position].title
    }

    fun getContentView(position: Int):String{
        return contentClassList[position].content
    }

    fun getDetailView(position: Int):String{
        return contentClassList[position].detail
    }

    fun getImageView(position: Int):Int{
        val contest=contentClassList[position]
        val resourceId=context.resources.getIdentifier(contest.mainImageView, "drawable", context.packageName)
        return resourceId
    }
    fun getLink(position: Int):String{
        return contentClassList[position].link
    }

}