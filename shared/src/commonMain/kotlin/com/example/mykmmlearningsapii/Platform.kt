package com.example.mykmmlearningsapii

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform