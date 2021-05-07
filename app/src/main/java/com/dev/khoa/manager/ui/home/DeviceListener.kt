package com.dev.khoa.manager.ui.home

import com.dev.khoa.manager.data.model.Device

interface DeviceListener {
    fun onClickItem(position: Int, item : Device)
}