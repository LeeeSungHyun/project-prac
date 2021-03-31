package com.sparta.noteproject.repository;

import com.sparta.noteproject.domain.Reple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepleRepository extends JpaRepository<Reple, Long> {
    List<Reple> findAllByOrderByModifiedAtDesc();

    Optional<List<Reple>> findAllByNoteId(Long noteId);
}
