package Banco.conta;

import market.Modelo.helper;

import java.util.Date;

public class Cliente {
    private static int codigo = 1;
    private int id;
    private String nome;
    private String endereco;
    private Date datadeNacimento;
    private Date dataCadastro;
    private String cpf;


    public Cliente(String nome, String endereco, Date datadeNacimento,String cpf) {
        this.id = Cliente.codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.datadeNacimento = datadeNacimento;
        this.dataCadastro = new Date();
        this.cpf = cpf;
        Cliente.codigo += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereço) {
        this.endereco = endereço;
    }

    public Date getDatadeNacimento() {
        return datadeNacimento;
    }

    public void setDatadeNacimento(Date datadeNacimento) {
        this.datadeNacimento = datadeNacimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "codigo" + this.getId() + "\nNome" + this.getNome() + "\nCPF" + this.getCpf() + "\ndata de nacimento" + helper.dateParaSring(this.getDatadeNacimento()) + "\nData de cadastro" + helper.dateParaSring(this.dataCadastro);
    }
}
