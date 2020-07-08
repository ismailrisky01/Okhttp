package com.example.okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview_main.layoutManager = LinearLayoutManager(this)


        fetchJson()
    }

    fun fetchJson() {
        println("Attempting to FETCH Json")
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
            client.newCall(request).enqueue(object : Callback{
                override fun onResponse(call: Call, response: Response) {
                    val body = response.body?.string()
                    println(body)
                    val gson = GsonBuilder().create()
                    val homeFeed = gson.fromJson(body,HomeFeed::class.java)

                    runOnUiThread {
                        recyclerview_main.adapter = MainAdapter(homeFeed)

                    }

                }

                override fun onFailure(call: Call, e: IOException) {
                    println("Failed to Load")
                }

            })
    }
}
class User(val status:String,val data: List<datas>)
class datas(val id_user:String,val nama:String,val alamat:String,val tanggal_lahir:String,val foto:String)

class HomeFeed(val videos:List<Video>)
class Video(val id:Int,val name:String, val link :String, val imageUrl: String, val numberOfViews:Int,val channel: Channel)
class Channel(val name: String,val profileImageUrl: String)



