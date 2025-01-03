package com.ralphmarondev.room_cmp.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.ralphmarondev.room_cmp.domain.model.Note
import com.ralphmarondev.room_cmp.presentation.home.components.InfoDialog
import com.ralphmarondev.room_cmp.presentation.home.components.NewNoteDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var showInfoDialog by remember { mutableStateOf(false) }
    var showNewNoteDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Room CMP",
                        fontFamily = FontFamily.Monospace
                    )
                },
                actions = {
                    IconButton(
                        onClick = { showInfoDialog = !showInfoDialog }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Information"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showNewNoteDialog = !showNewNoteDialog }) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "New Note"
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No notes yet.",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W500,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }

    if (showInfoDialog) {
        InfoDialog(
            onDismiss = { showInfoDialog = !showInfoDialog }
        )
    }

    if (showNewNoteDialog) {
        NewNoteDialog(
            onDismiss = {
                showNewNoteDialog = !showNewNoteDialog
            },
            onSave = { title, description ->
                val newNote = Note(
                    title = title.trim(),
                    description = description.trim()
                )
                println("New Note: $newNote")
                showNewNoteDialog = !showNewNoteDialog
            }
        )
    }
}