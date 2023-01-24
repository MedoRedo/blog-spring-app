package com.programming.spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String content;
    private String username;
    private Instant createdOn;
    private Instant updatedOn;
}
