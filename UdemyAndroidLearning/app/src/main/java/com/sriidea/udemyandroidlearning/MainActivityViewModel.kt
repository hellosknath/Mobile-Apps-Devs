package com.sriidea.udemyandroidlearning

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.sriidea.udemyandroidlearning.model.User
import com.sriidea.udemyandroidlearning.model.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private var userRepository = UserRepository()
    // var users: MutableLiveData<List<User>?> = MutableLiveData()

    // Live data builder systems
    var users = liveData(Dispatchers.IO) {
        val result = userRepository.getUser()
        emit(result)
    }

    /*fun getUserData() {
        viewModelScope.launch {
            var result: List<User>? = null
            withContext(Dispatchers.IO) {
                result = userRepository.getUser()
            }
            users.value = result
        }
    }*/
}