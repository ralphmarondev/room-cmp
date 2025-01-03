package com.ralphmarondev.room_cmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Room CMP",
    ) {
        App()
    }
}