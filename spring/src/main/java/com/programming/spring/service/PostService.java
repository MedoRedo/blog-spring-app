package com.programming.spring.service;

import com.programming.spring.entity.PostEntity;
import com.programming.spring.exception.PostNotFoundException;
import com.programming.spring.mapstruct.dto.PostDto;
import com.programming.spring.mapstruct.mapper.MapStructMapper;
import com.programming.spring.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PostService {
    private final PostRepository repository;
    private final MapStructMapper mapStructMapper;
    public void createPost(PostDto postDto){
        PostEntity post = mapStructMapper.postDtoToPost(postDto);
        post.setCreatedOn(Instant.now());
        repository.saveAndFlush(post);
    }

    public List<PostDto> getAllPosts(){
        return repository.findAll().stream().map(mapStructMapper::postToPostDto).toList();
    }

    public PostDto getPost(Long id) {
        PostEntity post = repository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapStructMapper.postToPostDto(post);
    }
}
