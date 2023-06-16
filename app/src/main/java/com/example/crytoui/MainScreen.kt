package com.example.crytoui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crytoui.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {
    private lateinit var binding: ActivityMainScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rcvOne.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val cryptoList = mutableListOf<ItemData>()
        val lineData = ArrayList<Int>()
        lineData.add(1000);
        lineData.add(1100);
        lineData.add(1200);
        lineData.add(1100);

        val lineData2 = ArrayList<Int>()
        lineData2.add(2100);
        lineData2.add(2000);
        lineData2.add(1900);
        lineData2.add(2000);

        val lineData3 = ArrayList<Int>()
        lineData3.add(900);
        lineData3.add(1000);
        lineData3.add(1100);
        lineData3.add(1000);


        cryptoList.add(ItemData("bitcoin","BTC",30000.2,-1.1,lineData,123332.1,1.23123))
        cryptoList.add(ItemData("ethereum","ETH",15000.2,3.1,lineData2,13.32,12.2))
        cryptoList.add(ItemData("trox","TDC",39000.2,5.1,lineData3,23.332,1.22))

        binding.rcvOne.adapter = CryptoAdapter(cryptoList,this)

    }
}