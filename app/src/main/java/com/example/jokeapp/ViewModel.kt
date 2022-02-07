package com.example.jokeapp


class ViewModel(private val model: Model<Any, Any>) {

    private var callback: TextCallBack? = null

    fun init(callBack: TextCallBack){
        this.callback = callBack

        model.init(object : ResultCallBack<Any,Any>{
            override fun provideSuccess(data: Any) {
                callBack.provideText("success")
            }

            override fun provideError(error: Any) {
                callBack.provideText("error")
            }
        })
    }

    fun getJoke(){
        model.getJoke()
    }

    fun clear(){
        callback = null
        model.clear()
    }

}

interface TextCallBack{
    fun provideText(text: String)
}