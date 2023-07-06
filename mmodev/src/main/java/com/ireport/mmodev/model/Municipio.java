package com.ireport.mmodev.model;

import lombok.Data;

@Data
public class Municipio {
    private Integer id;
    private String nome;
    private UF uf;
    private Long populacao;
}
