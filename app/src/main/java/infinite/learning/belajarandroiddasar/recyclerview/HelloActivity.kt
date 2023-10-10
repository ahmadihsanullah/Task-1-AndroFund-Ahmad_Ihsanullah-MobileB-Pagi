package infinite.learning.belajarandroiddasar.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import infinite.learning.belajarandroiddasar.R
import infinite.learning.belajarandroiddasar.adapters.RvWisataAdapter
import infinite.learning.belajarandroiddasar.data.Wisata
import infinite.learning.belajarandroiddasar.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHelloBinding
    private lateinit var adapterKeren:RvWisataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setRvAdapter()
    }
    private fun init() {
        binding.rvExample.layoutManager = LinearLayoutManager(this)
    }

    private fun setRvAdapter() {

        val dataList:MutableList<Wisata> = mutableListOf()

        nameWisata().forEachIndexed { index, name ->
            dataList.add(Wisata(imageWisata().get(index),name,descWisata()[index]))
        }

        Log.d("ISI DATANYA ",dataList.toString())
        adapterKeren = RvWisataAdapter(dataList)
        binding.rvExample.adapter = adapterKeren

    }

    private fun nameWisata():Array<String> = resources.getStringArray(R.array.data_name)
    private fun descWisata():Array<String> = resources.getStringArray(R.array.data_description)

    private fun imageWisata():List<Int> = listOf(
        R.drawable.pura_besakih,
        R.drawable.kepulauan_derawan,
        R.drawable.taman_laut_bunaken,
        R.drawable.pantai_parai_tenggiri,
        R.drawable.nusa_dua_bali,
        R.drawable.gunung_rinjani,
        R.drawable.danau_toba,
        R.drawable.nusa_penida
    )


}