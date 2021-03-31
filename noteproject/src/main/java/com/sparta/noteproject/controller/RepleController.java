package com.sparta.noteproject.controller;


import com.sparta.noteproject.domain.Reple;
import com.sparta.noteproject.dto.RepleRequestDto;
import com.sparta.noteproject.repository.RepleRepository;
import com.sparta.noteproject.service.RepleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor        // final..
@RestController
public class RepleController {

    private final RepleRepository repleRepository;
    private final RepleService repleService;

    @PostMapping("/api/reples")          // 생성
    public Reple createReple(@RequestBody RepleRequestDto requestDto) {
        Reple reple = new Reple(requestDto);
        return repleRepository.save(reple);
    }

    @GetMapping("/api/reples")           // 조회
    public List<Reple> getReples() {
        return repleRepository.findAllByOrderByModifiedAtDesc();  // 수정시간기준 최신순 정렬
    }

    @DeleteMapping("/api/reples/{id}")   // 삭제
    public Long deleteReple(@PathVariable Long id) {
        repleRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/reples/{id}")
    public Long updateReple(@PathVariable Long id, @RequestBody RepleRequestDto requestDto) {
        repleService.update(id, requestDto);
        return id;
    }

    @GetMapping("/api/reples/{noteId}")
    public List<Reple> getEachReple(@PathVariable Long noteId) {
        List<Reple> repleList = repleRepository.findAllByNoteId(noteId).orElseThrow(
                () -> new IllegalArgumentException("찾는 포스팅이 없습니다"));
        return repleList;
    }

}
