package com.dev.khoa.manager.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.dev.khoa.manager.R
import com.dev.khoa.manager.data.model.Device
import com.dev.khoa.manager.databinding.ItemDeviceBinding

class DeviceAdapter : RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>() {

    private lateinit var inflater: LayoutInflater
    var data: MutableList<Device>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var listener: DeviceListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        val binding = DataBindingUtil.inflate<ItemDeviceBinding>(inflater, R.layout.item_device, parent, false)
        return DeviceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        holder.binding.apply {
            this.item = data?.get(position)
            this.itemPosition = position
            this.itemListener = listener
            val context = root.context as LifecycleOwner
            lifecycleOwner = context
            executePendingBindings()
        }
    }

    override fun getItemCount() = data?.size ?: 0

    inner class DeviceViewHolder(val binding: ItemDeviceBinding) : RecyclerView.ViewHolder(binding.root)
}