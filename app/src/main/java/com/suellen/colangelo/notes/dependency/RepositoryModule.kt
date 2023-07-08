package com.suellen.colangelo.notes.dependency

import com.suellen.colangelo.notes.data.NoteRepositoryImpl
import com.suellen.colangelo.notes.domain.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNotesRepository(impl: NoteRepositoryImpl): NoteRepository
}