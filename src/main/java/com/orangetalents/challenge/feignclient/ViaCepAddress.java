package com.orangetalents.challenge.feignclient;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "ZIP code info retrieved from ViaCEP API")
public class ViaCepAddress {

    @Schema(description = "This is the Address street name",
            example = "Avenida Rondon Pacheco",
            required = true)
    private final String logradouro;

    @Schema(description = "This is the Address neighborhood",
            example = "Tibery",
            required = true)
    private final String bairro;

    @Schema(description = "This is the Address city",
            example = "Uberlândia",
            required = true)
    private final String localidade;

    @Schema(description = "This is the Address state",
            example = "MG",
            required = true)
    private final String uf;

    public ViaCepAddress(String logradouro, String bairro, String localidade, String uf) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViaCepAddress that = (ViaCepAddress) o;

        if (!logradouro.equals(that.logradouro)) return false;
        if (!bairro.equals(that.bairro)) return false;
        if (!localidade.equals(that.localidade)) return false;
        return uf.equals(that.uf);
    }

    @Override
    public int hashCode() {
        int result = logradouro.hashCode();
        result = 31 * result + bairro.hashCode();
        result = 31 * result + localidade.hashCode();
        result = 31 * result + uf.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ViaCepAddress{" +
                "logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}