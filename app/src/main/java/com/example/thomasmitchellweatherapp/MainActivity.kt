package com.example.thomasmitchellweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thomasmitchellweatherapp.databinding.ActivityMainBinding
import com.example.thomasmitchellweatherapp.repository.WeatherRepositoryImpl
import com.example.thomasmitchellweatherapp.view.CitySearchFragment
import com.example.thomasmitchellweatherapp.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding get() = _binding!!

    private val viewModel : WeatherViewModel by lazy {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return WeatherViewModel(WeatherRepositoryImpl()) as T
            }
        }.create(WeatherViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Both of the below snippets of code are causing problems.
         * I don't know which one is the right approach anymore
         */

//        _binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        viewModel.getForecast(city)

//        supportFragmentManager.beginTransaction().replace(
//            R.id.fragment_container,
//            CitySearchFragment()
//        ).commit()
    }
}