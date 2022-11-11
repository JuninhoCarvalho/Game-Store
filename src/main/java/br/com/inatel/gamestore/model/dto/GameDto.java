package br.com.inatel.gamestore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GameDto {

    private String name;
    private String company;
    private Integer releasedYear;
    private Double price;
    private String imageUrl;
}
