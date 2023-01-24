package com.programming.spring.mapstruct.mapper;

import com.programming.spring.entity.PostEntity;
import com.programming.spring.mapstruct.dto.PostDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class MapStructMapperTest {
    MapStructMapper mapStructMapper;
    PostDto postDto;
    PostEntity post;
    @BeforeEach
    void setUp() {
        post = PostEntity
                .builder()
                .title("Test")
                .content("Content Test")
                .username("Test user")
                .build();

        postDto = PostDto
                .builder()
                .title("Test dto")
                .content("Content Dto test")
                .username("Test user")
                .build();
        mapStructMapper = Mappers.getMapper(MapStructMapper.class);
    }

    @Test
    void postToPostDto() {
        PostDto postDto = mapStructMapper.postToPostDto(post);
        assertEquals(postDto.getContent(), post.getContent());
    }

    @Test
    void postDtoToPost() {
        PostEntity post = mapStructMapper.postDtoToPost(postDto);
        assertEquals(post.getContent(), postDto.getContent());
    }
}