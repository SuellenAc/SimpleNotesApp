package com.suellen.colangelo.notes.presentation.notedetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.suellen.colangelo.notes.presentation.notedetails.NoteDetailsScreen

const val noteDetailsRoute = "note_details"

fun NavController.navigateToNoteDetails(navOptions: NavOptions? = null) {
    this.navigate(noteDetailsRoute, navOptions)
}

fun NavGraphBuilder.openNoteDetails() {
    composable(noteDetailsRoute) {
        NoteDetailsScreen()
    }
}