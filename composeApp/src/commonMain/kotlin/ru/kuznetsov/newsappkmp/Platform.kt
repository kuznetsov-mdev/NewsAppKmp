package ru.kuznetsov.newsappkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform