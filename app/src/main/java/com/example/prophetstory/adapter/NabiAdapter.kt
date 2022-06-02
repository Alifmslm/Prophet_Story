package com.example.prophetstory.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.bumptech.glide.Glide
import com.example.prophetstory.databinding.ItemMainBinding
import com.example.prophetstory.detail.DetailNabiActivity
import com.example.prophetstory.model.ResponseItem

class NabiAdapter(private val listDataNabi : ArrayList<ResponseItem> = arrayListOf()) : RecyclerView.Adapter<NabiAdapter.NabiViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun addDataNabi(getData : List<ResponseItem>) {
        listDataNabi.clear()
        listDataNabi.addAll(getData)
        notifyDataSetChanged()
    }

    class NabiViewHolder(var binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NabiViewHolder {
        val itemBinding = ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return NabiViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NabiViewHolder, position: Int) {
        val nabi = listDataNabi[position]
        holder.binding.txtNama.text = nabi.nama
        holder.binding.txtTempat.text = nabi.tempat
        holder.binding.imgNabi.load(nabi.avatar!!) {
            scale(Scale.FILL)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailNabiActivity::class.java)
            intent.putExtra(DetailNabiActivity.Detail_Nabi, nabi)

            it.context.startActivity(intent)
        }

    }

    override fun getItemCount()= listDataNabi.size


}