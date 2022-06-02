package com.example.prophetstory.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.prophetstory.adapter.NabiAdapter
import com.example.prophetstory.databinding.FragmentNabiBinding
import com.example.prophetstory.model.ResponseItem
import com.example.prophetstory.network.RetrofitInterface
import com.example.prophetstory.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NabiFragment : Fragment() {

    private lateinit var binding : FragmentNabiBinding
    private lateinit var nabiAdapter: NabiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNabiBinding.inflate(inflater,container,false)

        nabiAdapter = NabiAdapter()
        binding.rvNabi.adapter = nabiAdapter
        binding.rvNabi.setHasFixedSize(true)
        binding.rvNabi.layoutManager = GridLayoutManager(context, 2)

        val call = RetrofitService.getService().getDataNabi()
        call.enqueue(object : Callback<List<ResponseItem>> {
            override fun onResponse(
                call: Call<List<ResponseItem>>,
                response: Response<List<ResponseItem>>
            ) {
                val listData = response.body()!!
                listData.let { it.let { it1 -> nabiAdapter.addDataNabi(it1) } }
            }

            override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return binding.root
    }

}