package com.dev.khoa.manager.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dev.khoa.manager.R
import com.dev.khoa.manager.data.model.Device
import com.dev.khoa.manager.databinding.FragmentHomeBinding
import com.dev.khoa.manager.utils.observer
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val TAG = HomeFragment::class.java.simpleName
    private lateinit var myInflater: LayoutInflater
    private lateinit var binding: FragmentHomeBinding
    private val viewModelF by viewModels<HomeViewModel>()
    private val adapter by lazy {
        DeviceAdapter().apply {
            listener = object : DeviceListener {
                override fun onClickItem(position: Int, item: Device) {
                    Log.d(TAG, "position: $position, item: $item")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelF.getData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (!::myInflater.isInitialized) {
            myInflater = LayoutInflater.from(requireActivity())
        }
        binding = DataBindingUtil.inflate(myInflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModelF = viewModelF
        binding.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer(viewModelF.manager) {
            adapter.data = it?.devices
        }
    }


}