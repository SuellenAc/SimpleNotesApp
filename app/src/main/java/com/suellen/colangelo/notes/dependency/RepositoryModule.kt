package com.suellen.colangelo.notes.dependency

import com.suellen.colangelo.notes.data.model.NoteRepositoryImpl
import com.suellen.colangelo.notes.domain.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindNotesRepository(impl: NoteRepositoryImpl): NoteRepository
}