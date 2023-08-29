package com.example.country

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.country.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    companion object {
        var countryList = ArrayList<CountryModal>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        var apiinterface = Apiclient.getApiclient().create(Apiinterface::class.java)
        apiinterface.getcountry().enqueue(object : Callback<List<CountryModal>> {
            override fun onResponse(
                call: Call<List<CountryModal>>,
                response: Response<List<CountryModal>>
            ) {

                countryList = response.body() as ArrayList<CountryModal>

                if (response.isSuccessful) {
                    var clickItem = object : CountryClick {
                        override fun onTap(i: Int) {
                            startActivity(Intent(this@MainActivity,Country_Detail::class.java).putExtra("pos",i))
                        }
                    }


                    binding.raccountry.layoutManager = GridLayoutManager(this@MainActivity, 1)
                    binding.raccountry.adapter = CountryAdapter(countryList,clickItem)


                }

            }

            override fun onFailure(call: Call<List<CountryModal>>, t: Throwable) {

                Log.e(TAG, "onFailure: "+t.message )
            }

        }


        )
    }}