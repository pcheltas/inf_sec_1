package org.pcheltas.inf_sec_1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostRequestDto {
    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
