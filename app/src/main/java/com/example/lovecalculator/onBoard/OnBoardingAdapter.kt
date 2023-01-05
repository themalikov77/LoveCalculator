package com.example.lovecalculator.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardingBinding
import com.example.lovecalculator.data.model.OnBoard

class OnBoardingAdapter(val onClick:()-> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val arrayList = arrayListOf<OnBoard>(
        OnBoard(R.raw.wedding, "Любовь это...", "Сладостный запах ее духов"),
        OnBoard(
            R.raw.wedding,
            "Любовь это...",
            "Гулять вместе, дарить ей подарки и слушать ее наркотический голос, не думая не о чем"
        ),
        OnBoard(
            R.raw.wedding,
            "Любовь это...",
            "Сидеть за столом,смотреть на ее очаровательные глаза и сходить с ума"
        ),
        OnBoard(
            R.raw.wedding,
            "Любовь это...",
            "Строить вместе новое царство и не беспокоиться, что встретишь новый день один"
        )

    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {

            binding.btnStart.isVisible = adapterPosition == arrayList.lastIndex
            binding.skip.isVisible = adapterPosition != arrayList.lastIndex
            binding.tvTITLE.text = onBoard.title
            binding.tvDESC.text = onBoard.desc

            binding.skip.setOnClickListener {
                onClick
            }
            binding.btnStart.setOnClickListener {
                onClick
            }

            if (adapterPosition == 0) {
                binding.image1.isVisible = true
                binding.image.isVisible = false
                binding.ind1.setImageResource(R.drawable.selected)
                binding.ind2.setImageResource(R.drawable.unselected)
                binding.ind3.setImageResource(R.drawable.unselected)
                binding.ind4.setImageResource(R.drawable.unselected)
                binding.back.isVisible = false
                binding.btnBack.isVisible = false
            }
            if (adapterPosition == 1) {
//                binding.image.setAnimation(R.raw.data)
                binding.ind1.setImageResource(R.drawable.unselected)
                binding.ind2.setImageResource(R.drawable.selected)
                binding.ind3.setImageResource(R.drawable.unselected)
                binding.ind4.setImageResource(R.drawable.unselected)
                binding.back.isVisible = true
                binding.btnBack.isVisible = true
            }
            if (adapterPosition == 2) {
                binding.image.setAnimation(R.raw.boy_and_girl)
                binding.ind1.setImageResource(R.drawable.unselected)
                binding.ind2.setImageResource(R.drawable.unselected)
                binding.ind3.setImageResource(R.drawable.selected)
                binding.ind4.setImageResource(R.drawable.unselected)
                binding.back.isVisible = true
                binding.btnBack.isVisible = true
            }
            if (adapterPosition == 3) {
                binding.image.setAnimation(R.raw.wedding)
                binding.ind1.setImageResource(R.drawable.unselected)
                binding.ind2.setImageResource(R.drawable.unselected)
                binding.ind3.setImageResource(R.drawable.unselected)
                binding.ind4.setImageResource(R.drawable.selected)
                binding.next.isVisible = false
                binding.btnNext.isVisible = false
                binding.skip.isVisible = false

            }
        }


    }

}
