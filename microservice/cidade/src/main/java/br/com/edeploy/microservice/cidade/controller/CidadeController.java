package br.com.edeploy.microservice.cidade.controller;

import br.com.edeploy.microservice.cidade.models.Cidade;
import br.com.edeploy.microservice.cidade.services.PesquisarCidade;
import br.com.edeploy.microservice.cidade.services.PontuacaoCidade;
import br.com.edeploy.microservice.cidade.services.TodasCidades;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CidadeController {
    @RequestMapping(value = "/todas", method = RequestMethod.GET, produces = "application/json")
    public List<Cidade> getTodas() {
        return new TodasCidades().getAll();
    }

    @RequestMapping(value = "/cidades", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getCidade(@RequestParam(value = "nome") String nome, @RequestParam(value = "estado") String estado) {
        List<Cidade> lista = new PesquisarCidade(nome, estado).getCidade();
        return ResponseEntity.ok(new Gson().toJson(lista));
    }

    @RequestMapping(value = "/cidades/pontuacao", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getPontuacao(@RequestParam(value = "id") int id, @RequestParam(value = "nome") String nome, @RequestParam(value = "estado") String estado) {
        Float pontuacao = new PontuacaoCidade(new Cidade(id, nome, estado)).getPontuacao();
        return ResponseEntity.ok(new Gson().toJson(pontuacao));
    }
}
