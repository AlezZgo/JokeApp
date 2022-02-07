package com.example.jokeapp

class TestModel : Model<Any,Any> {

    private var callBack: ResultCallBack<Any,Any>? = null

    private var count = 1

    override fun getJoke() {
        Thread.sleep(1000)

        if(count%2 == 0){
            callBack?.provideSuccess("success")
        }else{
            callBack?.provideError("error")
        }
        count++
    }

    override fun init(callBack: ResultCallBack<Any, Any>) {
        this.callBack = callBack
    }

    override fun clear() {
        callBack = null
    }

}
