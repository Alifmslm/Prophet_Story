package com.example.prophetstory.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.prophetstory.databinding.ItemMainBinding
import com.example.prophetstory.detail.DetailNabiActivity
import com.example.prophetstory.detail.DetailRasulActivity
import com.example.prophetstory.model.ResponseItem
import com.example.prophetstory.model.ResponseRasulItem

class RasulAdapter(private val listDataRasul : ArrayList<ResponseRasulItem> = arrayListOf()) : RecyclerView.Adapter<RasulAdapter.RasulViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun addDataRasul(getData : List<ResponseRasulItem>) {
        listDataRasul.clear()
        listDataRasul.addAll(getData)
        notifyDataSetChanged()
    }

    class RasulViewHolder(var binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RasulViewHolder {
        val itemBinding = ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return RasulAdapter.RasulViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RasulViewHolder, position: Int) {
        val rasul = listDataRasul[position]
        holder.binding.txtNama.text = rasul.nama
        holder.binding.txtTempat.text = rasul.tempat
        holder.binding.imgNabi.load(rasul.avatar!!) {
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailRasulActivity::class.java)
            intent.putExtra(DetailRasulActivity.Detail_Rasul, rasul)

            it.context.startActivity(intent)
        }
    }

    override fun getItemCount()= listDataRasul.size

}