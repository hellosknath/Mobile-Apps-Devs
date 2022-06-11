package com.sriidea.udemyandroidlearning

import android.util.Patterns
import androidx.lifecycle.*
import com.sriidea.udemyandroidlearning.db.Subscriber
import com.sriidea.udemyandroidlearning.db.SubscriberRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    private val subscribers = repository.subscribers

    // delete or update flag
    private var isUpdateOrDelete = false

    // update or delete subscriber model data
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    // get all save subscriber data
    fun getSavesSubscribers() = liveData {
        subscribers.collect() {
            emit(it)
        }
    }

    // getting user input
    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveOrUpdateBtnText = MutableLiveData<String>()
    val clearAllOrDeleteBtnText = MutableLiveData<String>()

    /*    // is's mutable private live data., it's only access this class, and modify
    * can not change this value others classes. only access message value*/
    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    // setting layout button text
    init {
        saveOrUpdateBtnText.value = "Save"
        clearAllOrDeleteBtnText.value = "Clear All"
    }

    fun saveOrUpdate() {

        if (inputName.value == null){
            statusMessage.value = Event("Please enter your name")
        }else if (inputEmail.value == null){
            statusMessage.value = Event("Please enter your email address")
        }else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()){
            statusMessage.value = Event("Please enter your email address correct format")
        }else{
            // flag is true, update the value
            if (isUpdateOrDelete) {
                subscriberToUpdateOrDelete.name = inputName.value!!
                subscriberToUpdateOrDelete.email = inputEmail.value!!
                update(subscriberToUpdateOrDelete)
            } else {
                val name: String = inputName.value!!
                val email: String = inputEmail.value!!
                insert(Subscriber(0, name, email))
                inputName.value = ""
                inputEmail.value = ""
            }
        }

    }

    fun clearAllOrDelete() {
        // if flag is true, single data delete, flag is false , then all data delete
        if (isUpdateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    fun insert(subscriber: Subscriber): Job =
        viewModelScope.launch {
            val newRowId = repository.insert(subscriber)
            if (newRowId > -1) {
                statusMessage.value = Event("Subscriber inserted successfully $newRowId")
            } else {
                statusMessage.value = Event("Error occurred $newRowId")
            }

        }

    fun update(subscriber: Subscriber): Job =
        viewModelScope.launch {
            val rowNo = repository.update(subscriber)

            if (rowNo > 0) {
                // when value is update, then input data are cleared
                inputName.value = ""
                inputEmail.value = ""

                // after value update, then flag is false, button return save and cleared mode
                isUpdateOrDelete = false
                saveOrUpdateBtnText.value = "Save"
                clearAllOrDeleteBtnText.value = "Clear All"

                statusMessage.value = Event("$rowNo Row updated successfully")
            } else {
                statusMessage.value = Event("Error Occurred")
            }

        }

    fun delete(subscriber: Subscriber): Job =
        viewModelScope.launch {
            val numberOfRowDeleted = repository.delete(subscriber)

            if (numberOfRowDeleted > 0) {

                // when delete data, then clear input field
                inputName.value = ""
                inputEmail.value = ""

                // set flag to false and return mode to initial state
                isUpdateOrDelete = false
                saveOrUpdateBtnText.value = "Save"
                clearAllOrDeleteBtnText.value = "Clear All"

                statusMessage.value = Event("$numberOfRowDeleted Row deleted successfully")
            } else {
                statusMessage.value = Event("Error Occurred")
            }
        }

    fun clearAll(): Job =
        viewModelScope.launch {
            val deleteOfRow = repository.deleteAll()
            if (deleteOfRow > 0) {
                statusMessage.value = Event("$deleteOfRow Row cleared successfully")
            } else {
                statusMessage.value = Event("Error Occurred")
            }
        }

    /*changing update or delete button text and showing selected update or delete data to
    edit text*/
    fun initUpdateAndDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email

        // when selected update or delete action, then flag is true
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateBtnText.value = "Update"
        clearAllOrDeleteBtnText.value = "Delete"

    }

}