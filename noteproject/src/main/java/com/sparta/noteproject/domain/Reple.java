package com.sparta.noteproject.domain;

import com.sparta.noteproject.dto.RepleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자 만들기
@Getter
@Entity // 테이블임!!
public class Reple extends Timestamped{  // 생성, 수정시간을 자동으로 만들어줌
    @GeneratedValue(strategy = GenerationType.AUTO)  // id 자동으로 생성
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Long noteId;


    public Reple(RepleRequestDto requestDto){
//        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.noteId = requestDto.getNoteId();
    }

    public void update(RepleRequestDto requestDto){
//        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}
