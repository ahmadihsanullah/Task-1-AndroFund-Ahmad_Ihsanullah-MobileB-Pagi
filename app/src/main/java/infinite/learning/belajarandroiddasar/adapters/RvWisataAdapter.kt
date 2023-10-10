package infinite.learning.belajarandroiddasar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import infinite.learning.belajarandroiddasar.data.Wisata
import infinite.learning.belajarandroiddasar.databinding.WisataItemBinding

class RvWisataAdapter(private val list: List<Wisata>):
    RecyclerView.Adapter<RvWisataAdapter.ViewHolder>() {

    class ViewHolder(val binding: WisataItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WisataItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.ivWisata.setImageResource(this.image)
                binding.tvWisata.text= this.name
                binding.tvDesc.text= this.desc
            }
        }
    }
}