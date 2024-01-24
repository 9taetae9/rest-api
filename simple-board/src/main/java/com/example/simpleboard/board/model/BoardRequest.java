package com.example.simpleboard.board.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BoardRequest {

    @NotBlank
    private String boardName;
}
