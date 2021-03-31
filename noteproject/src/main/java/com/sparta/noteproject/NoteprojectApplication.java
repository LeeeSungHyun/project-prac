package com.sparta.noteproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // jpa 변동사항 잘 반영해줘!
public class NoteprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteprojectApplication.class, args);
    }

}
