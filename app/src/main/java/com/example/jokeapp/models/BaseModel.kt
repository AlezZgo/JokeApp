package com.example.jokeapp.models

//import com.example.jokeapp.Errors.NoConnection
//import com.example.jokeapp.Errors.ServiceUnavailable
//import com.example.jokeapp.JokeService
//import com.example.jokeapp.data.JokeDto
//import com.example.jokeapp.data.JokeMapper
//import com.example.jokeapp.resources.ResourceManager
//import retrofit2.Call
//import retrofit2.Response
//import java.net.UnknownHostException
//
//class BaseModel(
//    private val service: JokeService,
//    private val resourceManager: ResourceManager,
//) : Model {
//
//    private var callBack: ResultCallBack? = null
//    private val noConnection by lazy { NoConnection(resourceManager) }
//    private val serviceUnavailable by lazy { ServiceUnavailable(resourceManager) }
//
//    override fun getJoke() {
//        service.getJoke().enqueue(object : retrofit2.Callback<JokeDto> {
//            override fun onResponse(call: Call<JokeDto>, response: Response<JokeDto>) {
//                if (response.isSuccessful) {
//                    callBack?.provideSuccess(JokeMapper.mapDtoToEntity(response.body()!!))
//                } else {
//                    callBack?.provideError(serviceUnavailable)
//                }
//            }
//
//            override fun onFailure(call: Call<JokeDto>, t: Throwable) {
//                if (t is UnknownHostException)
//                    callBack?.provideError(noConnection)
//                else
//                    callBack?.provideError(serviceUnavailable)
//            }
//
//
//        })
//    }
//
//    override fun init(callBack: ResultCallBack) {
//        this.callBack = callBack
//    }
//
//    override fun clear() {
//        callBack = null
//    }
//}