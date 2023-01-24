package com.programming.spring.mapstruct.mapper;

import com.programming.spring.entity.PostEntity;
import com.programming.spring.mapstruct.dto.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    PostDto postToPostDto(PostEntity post);
    PostEntity postDtoToPost(PostDto postDto);
}
