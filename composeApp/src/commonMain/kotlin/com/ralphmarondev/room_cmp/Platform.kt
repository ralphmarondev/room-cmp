package com.ralphmarondev.room_cmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform