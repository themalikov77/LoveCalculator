package com.example.lovecalculator.history

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemHistoryBinding
import com.example.lovecalculator.remote.LoveModel

class HistoryAdapter(
    private val list: ArrayList<LoveModel> = arrayListOf(),
    val context: Context


) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addHistory(newModel: List<LoveModel>) {
        this.list.clear()
        this.list.addAll(newModel)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            with(binding) {
                tvFirstName.text = loveModel.firsName
                tvSecondName.text = loveModel.secondName
                tvPercentage.text = loveModel.percentage
                tvResult.text = loveModel.result
            }


            if (adapterPosition % 2 == 0) {
                itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.blue))

            } else {
                itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.transparent))

            }
            itemView.setOnLongClickListener {
                onLong(loveModel)
                return@setOnLongClickListener true
            }

        }

        private fun onLong(loveModel: LoveModel) {
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Update?")
            alertDialog.setPositiveButton("Ok", DialogInterface.OnClickListener { _, _ ->



            })
            alertDialog.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ -> })
            alertDialog.show()
        }
//
    }
}