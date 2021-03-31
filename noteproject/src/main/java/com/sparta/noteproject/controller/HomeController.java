package com.sparta.noteproject.controller;

import com.sparta.noteproject.domain.Note;
import com.sparta.noteproject.repository.NoteRepository;
import com.sparta.noteproject.security.UserDetailsImpl;
import com.sparta.noteproject.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final NoteRepository noteRepository;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        return "index";
    }

    @GetMapping("/write")
    public String write(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        return "write";
    }

    @GetMapping("/notedetail/{noteId}")
    public String notedetail(@PathVariable Long noteId, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        Note note = noteRepository.findById(noteId).orElseThrow(()->new IllegalArgumentException("해당하는 ID의 게시물이 없습니다."));

        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("noteId", noteId);
        model.addAttribute("title", note.getTitle());
        model.addAttribute("author", note.getUsername());
        model.addAttribute("contents", note.getContents());
        return "notedetail";
    }
}