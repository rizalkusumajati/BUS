package com.riztech.bus.util

sealed class BaseResult<out T>{
    class Success<out T>(val data: T): BaseResult<T>()
    class Error<out T>(val message: String?,val data: T?=null): BaseResult<T>()
    class Loading<out T>: BaseResult<T>()
}