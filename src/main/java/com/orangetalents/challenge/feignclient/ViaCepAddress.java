package com.orangetalents.challenge.feignclient;

public class ViaCepAddress {
    private final String logradouro;
    private final String bairro;
    private final String localidade;
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