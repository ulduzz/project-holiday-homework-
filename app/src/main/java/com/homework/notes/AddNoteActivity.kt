package com.homework.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.homework.notes.databinding.ActivityAddNoteBinding
import com.homework.notes.databinding.ActivityMainBinding

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db : NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = NoteDatabaseHelper(this)
       binding.saveButton.setOnClickListener {
           val title= binding.titleEditText.text.toString()
           val content= binding.contentEditText.text.toString()
           val note = Note(0,title,content)
           db.insertNote(note)
           finish()
           Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
       }
    }
}