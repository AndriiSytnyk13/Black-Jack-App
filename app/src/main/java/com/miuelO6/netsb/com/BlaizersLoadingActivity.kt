package com.miuelO6.netsb.com

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.miuelO6.netsb.com.view.BlaizersGameActivity
import com.miuelO6.netsb.com.view.BlaizersMenuFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BlaizersLoadingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blaizers_loading)
        openBlaizersWebView()
    }

    private fun openBlaizersWebView() {
        lifecycleScope.launch {
            delay(9000)
            startActivity(Intent(this@BlaizersLoadingActivity, BlaizersGameActivity::class.java))
        }
    }

}