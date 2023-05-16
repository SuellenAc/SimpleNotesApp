package com.suellen.colangelo.notes.presentation.notelist.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.suellen.colangelo.notes.presentation.notelist.NoteListScreen

const val noteListRoute = "note_list"

fun NavGraphBuilder.openNoteList(onNoteClick: () -> Unit) {
    composable(noteListRoute) {
        NoteListScreen(onNoteClick)
    }
}