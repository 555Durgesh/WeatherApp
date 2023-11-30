package com.exampleweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleweatherapp.databinding.ActivityMainBinding
import com.iitkgp.weatherapp.ApiClient
import com.iitkgp.weatherapp.ApiInterface
import com.iitkgp.weatherapp.ResponseModel
import com.iitkgp.weatherapp.WeatherAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var list = listOf<ResponseModel?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        OpenWeatherApi("Surat")
        Cities()
    }

    private fun OpenWeatherApi(z: String) {
        var apiInterface= ApiClient.getRetrofit().create(ApiInterface::class.java)
        apiInterface.getdata(z,"ba06c8c49bdf4337e55aadc60b30676e").enqueue(object:
            Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {

                Log.e("TAG", "onResponse: ${response.body()}", )

                val temp=response.body()
                list= listOf(temp)
                RvAdapter(list)

            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.e("TAG", "onFailure===: ${t.message}", )
            }

        })

    }


    private fun RvAdapter(list: List<ResponseModel?>) {
        var adapter=WeatherAdapter(this,list)
        var layoutManager= LinearLayoutManager(this)
        binding.RvSetup.layoutManager=layoutManager
        binding.RvSetup.adapter=adapter
    }

    private fun Cities() {
        binding.NewYorkBtn.setOnClickListener {
            var Name= "New York"
            OpenWeatherApi(Name)

        }
        binding.SingaporeBtn.setOnClickListener {
            OpenWeatherApi("Singapore")

        }

        binding.MumbaiBtn.setOnClickListener {
            OpenWeatherApi("Mumbai")

        }

        binding.MumbaiBtn.setOnClickListener {
            OpenWeatherApi("Mumbai")

        }

        binding.DelhiBtn.setOnClickListener {
            OpenWeatherApi("Delhi")

        }

        binding.SydneyBtn.setOnClickListener {
            OpenWeatherApi("Sydney")

        }

        binding.MelbourneBtn.setOnClickListener {
            OpenWeatherApi("Melbourne")

        }
    }
}