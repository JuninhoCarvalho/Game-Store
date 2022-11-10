package com.br.inatel.gamestore.model.dto;

import com.br.inatel.gamestore.model.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GameDto {

    private String name;
    private String company;
    private Integer releasedYear;
    private Double price;
}
