package org.pcheltas.inf_sec_1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
}
