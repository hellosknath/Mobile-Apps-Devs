package com.sriidea.udemyandroidlearning

open class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set // allow external read but not right

    /* return the content and prevents its use again */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /*returns the content, even if it's already been handled */
    fun peekContent(): T = content
}