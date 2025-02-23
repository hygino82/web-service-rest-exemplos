package br.dev.hygino.jakarta.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestProductDTO implements Serializable {
    private String name;
    private Double price;
}
