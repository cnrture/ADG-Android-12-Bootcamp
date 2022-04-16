package com.canerture.adbootcampactivitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.canerture.adbootcampactivitylifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.kullaniciGonderButton.setOnClickListener {

            val isimInput = binding.isimEditText.text.toString()
            val yasInput = binding.yasEditText.text.toString().toInt()
            val yeniKullanici = Kullanici(isimInput, yasInput)

            val intent = Intent(this@MainActivity, KullaniciBilgiActivity::class.java)
            intent.putExtra("isim", isimInput)
            intent.putExtra("yas", yasInput)

            intent.putExtra("kullanici", yeniKullanici)
            startActivity(intent)

        }

        Log.d("MainActivity", "onCreate çalıştı!")

    }

    override fun onStart() {
        super.onStart()

        Log.d("MainActivity", "onStart çalıştı!")

    }

    override fun onResume() {
        super.onResume()

        Log.d("MainActivity", "onResume çalıştı!")

    }

    override fun onPause() {
        super.onPause()

        Log.d("MainActivity", "onPause çalıştı!")

    }

    override fun onRestart() {
        super.onRestart()

        Log.d("MainActivity", "onRestart çalıştı!")

    }

    override fun onStop() {
        super.onStop()

        Log.d("MainActivity", "onStop çalıştı!")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "onDestroy çalıştı!")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d("MainActivity", "onSaveInstanceState çalıştı!")

    }

    override fun onBackPressed() {
        super.onBackPressed()

        Log.d("MainActivity", "onBackPressed çalıştı!")

    }
}