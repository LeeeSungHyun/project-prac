package com.sparta.noteproject.dto;

import lombok.Getter;

@Getter
public class RepleRequestDto {
    private String title;
    private String username;
    private String contents;
    private Long noteId;
}
