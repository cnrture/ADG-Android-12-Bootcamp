package com.canerture.adbootcampactivitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.canerture.adbootcampactivitylifecycle.databinding.ActivityKullaniciBilgiBinding
import com.canerture.adbootcampactivitylifecycle.databinding.ActivityMainBinding

class KullaniciBilgiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKullaniciBilgiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKullaniciBilgiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gelenIsim = intent.getStringExtra("isim")
        val gelenYas = intent.getIntExtra("yas", 0)

        val gelenKullanici = intent.getSerializableExtra("kullanici") as Kullanici

        binding.isimText.text = gelenKullanici.isim
        binding.yasText.text = gelenKullanici.yas.toString()

    }
}