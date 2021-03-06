package com.neouto.munazam.data.repository

import androidx.lifecycle.LiveData
import com.neouto.munazam.data.dao.NoteDao
import com.neouto.munazam.data.model.Note

class NoteRepository(private val noteDao: NoteDao) {

    // note live data
    val fetchAllNotesLiveData: LiveData<List<Note>> by lazy {
        noteDao.fetchAllNotes()
    }

    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.update(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

    suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }

    fun searchInDatabase(searchQuery: String): LiveData<List<Note>> {
        return noteDao.searchInDatabase(searchQuery)
    }

}