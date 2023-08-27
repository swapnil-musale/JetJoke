package com.devx.domain.util

interface Mapper<T> {
    fun mapToDomain(): T
}
