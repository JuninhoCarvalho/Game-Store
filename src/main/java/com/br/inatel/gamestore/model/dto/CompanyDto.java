package com.br.inatel.gamestore.model.dto;

import com.br.inatel.gamestore.model.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyDto {

    private String name;
}
