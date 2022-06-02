package com.example.prophetstory.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.prophetstory.R
import com.example.prophetstory.databinding.ActivityDetailNabiBinding
import com.example.prophetstory.databinding.ActivityMainBinding
import com.example.prophetstory.model.ResponseItem
import com.example.prophetstory.model.ResponseRasulItem

class DetailNabiActivity : AppCompatActivity() {

    companion object {
        const val Detail_Nabi = ""
    }

    private lateinit var binding: ActivityDetailNabiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNabiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<ResponseItem>(Detail_Nabi)

        binding.imageView5.setOnClickListener {
            val intent = Intent(this,ActivityMainBinding::class.java)
            startActivity(intent)
        }

        binding.txtDetailTempat.text = data?.tempat
        binding.txtDetailTempatklhrn.text = data?.tpKelahiran
        binding.txtDetailUsia.text = data?.usia
        binding.txtDetailDesk.text = data?.deskripsi
        binding.txtDetailNama.text = data?.nama
        Glide.with(this).load(data?.avatar).into(binding.imageView)

    }
}