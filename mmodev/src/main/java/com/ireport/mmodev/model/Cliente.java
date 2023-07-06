package com.ireport.mmodev.model;

import lombok.Data;

@Data
public class Cliente {
    private Integer id;
    private String nome;
    private String endereco;
    private String observacao;
    private Double dlatitude;
    private Double dlongitude;
    private Municipio municipio;
    private UF uf;
}
