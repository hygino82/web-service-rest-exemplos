package br.data;

import lombok.Data;

@Data
public class Cidade implements br.data.model.ICidade {
    private int id;
    private String nome;
}
