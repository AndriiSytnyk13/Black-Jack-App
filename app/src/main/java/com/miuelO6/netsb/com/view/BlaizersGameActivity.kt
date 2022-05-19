package com.miuelO6.netsb.com.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miuelO6.netsb.com.databinding.ActivityBlaizersGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlaizersGameActivity : AppCompatActivity() {

    private lateinit var blaizersGameActivityBinding: ActivityBlaizersGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        blaizersGameActivityBinding = ActivityBlaizersGameBinding.inflate(layoutInflater)
        setContentView(blaizersGameActivityBinding.root)
    }
}