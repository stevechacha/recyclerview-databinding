package com.steve.recyclerviewdatabinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.steve.recyclerviewdatabinding.databinding.ActivityMainBinding

class RecyclerAdapter(@LayoutRes var layoutid: Int,var data:ArrayList<RecycleData>,var viewModel: MainViewModel):RecyclerView.Adapter<RecyclerAdapter.GenericViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val view=LayoutInflater.from(parent.context)
        val binding=DataBindingUtil.inflate<ViewDataBinding>(view,viewType,parent,false)
        return GenericViewHolder(binding)

    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bind(viewModel,position)

    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun getItemViewType(position: Int): Int {
        return layoutid
    }

    class GenericViewHolder(private var binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: MainViewModel, position: Int) {
            binding.setVariable(BR.itemViewmodel,viewModel)
            binding.setVariable(BR.position,position)

        }

    }
}