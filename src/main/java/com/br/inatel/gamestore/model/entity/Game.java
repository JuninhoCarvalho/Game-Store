package com.br.inatel.gamestore.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Game {

    @Id
    private String code;
    private String name;
    private String company;
    private Integer releasedYear;
    private Double price;
}