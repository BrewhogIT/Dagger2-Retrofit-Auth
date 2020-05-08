package com.brewhog.android.daggerretrofitauthorization.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.brewhog.android.daggerretrofitauthorization.R
import com.brewhog.android.daggerretrofitauthorization.databinding.ItemMotoBinding
import com.brewhog.android.daggerretrofitauthorization.model.Moto

class MotoAdapter(motoList: List<Moto>) : RecyclerView.Adapter<MotoHolder>() {
    var motoList = motoList
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotoHolder {
        val inflator = LayoutInflater.from(parent.context)
        val itemMotoBinding = DataBindingUtil.inflate<ItemMotoBinding>(
            inflator,
            R.layout.item_moto,
            parent,
            false)
        return MotoHolder(itemMotoBinding)
    }

    override fun getItemCount(): Int {
        return motoList.size
    }

    override fun onBindViewHolder(holder: MotoHolder, position: Int) {
        holder.itemMotoBinding.moto = motoList[position]
    }
}