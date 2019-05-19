package com.georgevik.base.exception

sealed class Failure {
    object ServerError : Failure()
}