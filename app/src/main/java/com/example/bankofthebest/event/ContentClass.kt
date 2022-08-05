package com.example.bankofthebest.event


class ContentClass(var title:String, var content:String, var sort:String, var detail:String, var mainImageView:String, var link:String){
    var bool:Boolean=true

    init{
        if(mainImageView.isEmpty()){
            mainImageView="defaultimg"
        }
        if(link.isEmpty()){
            link="empty"
        }
    }
}
