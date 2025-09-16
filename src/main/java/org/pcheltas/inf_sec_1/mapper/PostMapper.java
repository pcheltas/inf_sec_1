package org.pcheltas.inf_sec_1.mapper;

import org.pcheltas.inf_sec_1.dto.PostRequestDto;
import org.pcheltas.inf_sec_1.dto.PostResponseDto;
import org.pcheltas.inf_sec_1.model.Post;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

@Component
public class PostMapper {
    public Post toEntity(PostRequestDto postRequestDto) {
        return Post.builder()
                .title(HtmlUtils.htmlEscape(postRequestDto.getTitle()))
                .content(HtmlUtils.htmlEscape(postRequestDto.getContent())).build();
    }

    public PostResponseDto toDto(Post post) {
        return PostResponseDto.builder().id(post.getId()).title(post.getTitle()).content(post.getContent()).build();
    }
}
