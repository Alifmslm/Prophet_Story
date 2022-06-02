package com.example.prophetstory.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.prophetstory.R
import com.example.prophetstory.databinding.ActivityDetailRasulBinding
import com.example.prophetstory.databinding.ActivityMainBinding
import com.example.prophetstory.model.ResponseRasulItem

class DetailRasulActivity : AppCompatActivity() {

    companion object {
        const val Detail_Rasul = ""
    }

    private lateinit var binding: ActivityDetailRasulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRasulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView5.setOnClickListener {
            val intent = Intent(this, ActivityMainBinding::class.java)
            startActivity(intent)
        }

        val data = intent.getParcelableExtra<ResponseRasulItem>(Detail_Rasul)

        binding.txtDetailTempat.text = data?.tempat
        binding.txtDetailTempatklhrn.text = data?.tpKelahiran
        binding.txtDetailUsia.text = data?.usia
        binding.txtDetailDesk.text = data?.deskripsi
        binding.txtDetailNama.text = data?.nama
        Glide.with(this).load(data?.avatar).into(binding.imageView)

    }
}