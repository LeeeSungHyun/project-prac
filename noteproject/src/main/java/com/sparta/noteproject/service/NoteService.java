package com.sparta.noteproject.service;

import com.sparta.noteproject.domain.Note;
import com.sparta.noteproject.repository.NoteRepository;
import com.sparta.noteproject.dto.NoteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor        // final로 선언된게 있으면 생성할 때 무조건 넣어줘!
@Service                    //여긴 서비스 부분이야
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional // DB반영시켜줘 !
    public Long update(Long id, NoteRequestDto requestDto){
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        note.update(requestDto);
        return note.getId();
    }
}
