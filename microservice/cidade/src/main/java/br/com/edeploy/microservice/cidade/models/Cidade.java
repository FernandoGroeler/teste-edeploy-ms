package br.com.edeploy.microservice.cidade.models;

public class Cidade {
    private int id;
    private String nome;
    private String estado;
    private float pontuacao;

    public Cidade(int id, String nome, String estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.pontuacao = pontuacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(float pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return String.format("Id: %s, Nome: %s, Estado: %s, Pontuação: %s", this.id, this.nome, this.estado, this.pontuacao);
    }
}
