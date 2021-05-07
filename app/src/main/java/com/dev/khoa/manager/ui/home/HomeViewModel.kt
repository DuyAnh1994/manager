package com.dev.khoa.manager.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.khoa.manager.data.model.Manager
import com.dev.khoa.manager.data.repository.ManagerRepository
import com.dev.khoa.manager.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val managerRepository: ManagerRepository) :
    ViewModel() {

    private val _manager = MutableLiveData<Manager>()
    val manager = _manager.asLiveData()

    fun getData() {
        viewModelScope.launch {
            managerRepository.getData().collect { manager ->
                _manager.postValue(manager)
            }
        }
    }

}