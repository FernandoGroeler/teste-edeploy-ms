package br.com.edeploy.microservice.cidade.services;

import br.com.edeploy.microservice.cidade.models.Cidade;

import java.util.Iterator;
import java.util.List;

public class PesquisarCidade {
    private String nome;
    private String estado;

    public PesquisarCidade(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    private List<Cidade> pesquisarNome() {
        List<Cidade> lista = new TodasCidades().getAll();

        for(Iterator<Cidade> iterator = lista.iterator(); iterator.hasNext(); ) {
            Cidade cidade = iterator.next();

            if (!cidade.getNome().toLowerCase().contains(this.nome.toLowerCase())) {
                iterator.remove();
            }
        }

        return lista;
    }

    private List<Cidade> pesquisarEstado() {
        List<Cidade> lista = new TodasCidades().getAll();

        for(Iterator<Cidade> iterator = lista.iterator(); iterator.hasNext(); ) {
            Cidade cidade = iterator.next();

            if (!cidade.getEstado().toLowerCase().contains(this.estado.toLowerCase())) {
                iterator.remove();
            }
        }

        return lista;
    }

    private List<Cidade> pesquisarNomeEEstado() {
        List<Cidade> lista = new TodasCidades().getAll();

        for(Iterator<Cidade> iterator = lista.iterator(); iterator.hasNext(); ) {
            Cidade cidade = iterator.next();

            if (!cidade.getNome().toLowerCase().contains(this.nome.toLowerCase())
                    && !cidade.getEstado().toLowerCase().contains(this.estado.toLowerCase())) {
                iterator.remove();
            }
        }

        return lista;
    }

    public List<Cidade> getCidade() {
        if (!this.nome.trim().equals("") && this.estado.trim().equals("")) {
            return pesquisarNome();
        } else if (this.nome.trim().equals("") && !this.estado.trim().equals("")) {
            return pesquisarEstado();
        } else if (this.nome.trim().equals("") && this.estado.trim().equals("")) {
            return null;
        } else {
            return pesquisarNomeEEstado();
        }
    }
 }
