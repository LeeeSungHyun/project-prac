package com.sparta.noteproject.domain;


import com.sparta.noteproject.dto.NoteRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor // 기본생성자 만들기
@Getter
@Entity // 테이블임!!
public class Note extends Timestamped{  // 생성, 수정시간을 자동으로 만들어줌
    @GeneratedValue(strategy = GenerationType.AUTO)  // id 자동으로 생성
    @Id
    private Long id;

    @Column(nullable = false)  // false -> 무조건 있어야 함
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;



    public Note(NoteRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(NoteRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}
