package com.sriidea.udemyandroidlearning

import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.sriidea.udemyandroidlearning.db.Subscriber
import com.sriidea.udemyandroidlearning.db.SubscriberDao
import com.sriidea.udemyandroidlearning.db.SubscriberRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(), Observable {

    val subscribers = repository.subscribers

    fun getSavesSubscribers() = liveData {
        repository.subscribers.collect() {
            emit(it)
        }
    }

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveOrUpdateBtnText = MutableLiveData<String>()
    val clearAllOrDeleteBtnText = MutableLiveData<String>()

    init {
        saveOrUpdateBtnText.value = "Save"
        clearAllOrDeleteBtnText.value = "Clear All"
    }

    fun saveOrUpdate() {
        val name: String = inputName.value!!
        val email: String = inputEmail.value!!
        insert(Subscriber(0, name, email))
        inputName.value = ""
        inputEmail.value = ""
    }

    fun clearAllOrDelete() {
        clearAll()
    }

    fun insert(subscriber: Subscriber): Job =
        viewModelScope.launch {
            repository.insert(subscriber)
        }

    fun update(subscriber: Subscriber): Job =
        viewModelScope.launch {
            repository.update(subscriber)
        }

    fun delete(subscriber: Subscriber): Job =
        viewModelScope.launch {
            repository.delete(subscriber)
        }

    fun clearAll(): Job =
        viewModelScope.launch {
            repository.deleteAll()
        }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}