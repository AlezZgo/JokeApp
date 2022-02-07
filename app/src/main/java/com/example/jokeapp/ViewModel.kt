package com.example.jokeapp

import android.graphics.ColorSpace
import android.service.carrier.CarrierMessagingService

class ViewModel(private val model: ColorSpace.Model<Any, Any>) {

    private var callback: TextCallBack? = null

    fun init(callBack: TextCallBack){
        this.callback = callback
        model.init(object : CarrierMessagingService.ResultCallback<Any,Any>){

        }

    }

}

interface TextCallBack{
    fun provideText(text: String)
}