package com.sparta.noteproject.controller;


import com.sparta.noteproject.domain.Note;
import com.sparta.noteproject.repository.NoteRepository;
import com.sparta.noteproject.dto.NoteRequestDto;
import com.sparta.noteproject.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor        // final..
@RestController
public class NoteController {

    private final NoteRepository noteRepository;
    private final NoteService noteService;

    @PostMapping("/api/notes")          // 생성
    public Note createNote(@RequestBody NoteRequestDto requestDto) {
        Note note = new Note(requestDto);
        return noteRepository.save(note);
    }

    @GetMapping("/api/notes")           // 조회
    public List<Note> getNotes() {
        return noteRepository.findAllByOrderByModifiedAtDesc();  // 수정시간기준 최신순 정렬
    }

    @DeleteMapping("/api/notes/{id}")   // 삭제
    public Long deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/notes/{id}")
    public Long updateNote(@PathVariable Long id, @RequestBody NoteRequestDto requestDto) {
        noteService.update(id, requestDto);
        return id;
    }

    @GetMapping("/api/notes/{id}")
    public Note getEachNote(@PathVariable Long id) {
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("찾는 포스팅이 없습니다"));
        return note;
    }



}
