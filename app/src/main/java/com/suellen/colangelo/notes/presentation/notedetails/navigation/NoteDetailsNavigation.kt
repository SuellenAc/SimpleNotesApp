package com.suellen.colangelo.notes.presentation.notedetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.suellen.colangelo.notes.presentation.notedetails.NoteDetailsScreen

private const val noteId = "noteId"
const val noteDetailsRoute = "noteDetails/{$noteId}"

fun NavController.navigateToNoteDetails(navOptions: NavOptions? = null) {
    this.navigate(noteDetailsRoute, navOptions)
}

fun NavGraphBuilder.openNoteDetails() {
    composable(
        noteDetailsRoute,
        arguments = listOf(navArgument(noteId) { type = NavType.StringType })
    ) { backStackEntry ->
        NoteDetailsScreen(noteId = backStackEntry.arguments?.getString(noteId))
    }
}