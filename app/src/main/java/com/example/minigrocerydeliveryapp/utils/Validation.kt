package com.example.minigrocerydeliveryapp.utils


object Validation {

    fun isValidMobile(number: String): Boolean {
        return number.length == 10
    }

    fun isValidOtp(otp: String): Boolean {
        return otp == Constants.FAKE_OTP
    }

    fun isEmpty(value: String): Boolean {
        return value.trim().isEmpty()
    }
}