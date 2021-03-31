package com.sparta.noteproject.repository;

import com.sparta.noteproject.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByOrderByModifiedAtDesc();
}
