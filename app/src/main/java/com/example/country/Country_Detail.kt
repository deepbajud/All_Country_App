package com.example.country

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.country.databinding.ActivityCountryDetailBinding
import com.example.country.databinding.ActivityMainBinding

class Country_Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pos = intent.getIntExtra("pos",0)

        var modal = MainActivity.countryList[pos]

        Glide.with(this).load(modal.flags?.png).into(binding.img)
        binding.txtnamee.text= modal.name
        binding.txtname.text = modal.name
        binding.txtalp2.text = modal.alpha2Code
        binding.txtalp3.text = modal.alpha3Code
        binding.callingcode.text = modal.callingCodes.toString()
        binding.sub.text = modal.subregion
        binding.region.text = modal.region
        binding.populat.text = modal.population.toString()
        binding.deyoma.text = modal.demonym
        binding.area.text = modal.area.toString()
        binding.timezone.text = modal.timezones.toString()
        binding.txtlanguage.text = modal.languages?.get(0)?.name



    }
}