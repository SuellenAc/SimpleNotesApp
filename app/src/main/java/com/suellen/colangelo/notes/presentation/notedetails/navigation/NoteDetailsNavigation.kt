package com.suellen.colangelo.notes.presentation.notedetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.suellen.colangelo.notes.presentation.notedetails.NoteDetailsScreen

private const val argNoteId = "noteId"

// navigates
fun NavController.navigateToNoteDetails(noteId: String?, navOptions: NavOptions? = null) {
    this.navigate(getRoute(noteId), navOptions)
}

// register the route
fun NavGraphBuilder.openNoteDetails() {
    composable(
        "noteDetails?noteId={noteId}",
        arguments = listOf(navArgument(argNoteId) { type = NavType.StringType })
    ) { backStackEntry ->
        NoteDetailsScreen(noteId = backStackEntry.arguments?.getString(argNoteId))
    }
}

private fun getRoute(noteId: String?): String =
    noteId?.let { "noteDetails?noteId=$it" } ?: "noteDetails"