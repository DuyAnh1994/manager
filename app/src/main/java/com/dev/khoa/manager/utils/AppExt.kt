package com.dev.khoa.manager.utils

import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView


fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>

fun <T> Fragment.observer(liveData: LiveData<T>, onChange: (T?) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer(onChange))
}

@BindingAdapter("rv_set_fix_size")
fun RecyclerView.setFixSize(set: Boolean) {
    setHasFixedSize(set)
}

@BindingAdapter("rv_set_adapter")
fun <T : RecyclerView.ViewHolder> RecyclerView.applyAdapter(applyAdapter: RecyclerView.Adapter<T>?) {
    applyAdapter?.apply {
        adapter = applyAdapter
    }
}