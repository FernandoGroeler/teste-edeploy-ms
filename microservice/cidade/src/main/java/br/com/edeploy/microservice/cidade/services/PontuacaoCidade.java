package br.com.edeploy.microservice.cidade.services;

import br.com.edeploy.microservice.cidade.config.Url;
import br.com.edeploy.microservice.cidade.models.Cidade;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.Map;

public class PontuacaoCidade {
    private Cidade cidade;

    public PontuacaoCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public float getPontuacao() {
        Map<String, String> map = new HashMap<>();

        map.put("Nome", this.cidade.getNome());
        map.put("Estado", this.cidade.getEstado());

        try {
            HttpResponse<String> resp = Unirest
                    .post(Url.BUSCAPONTOS)
                    .body(new Gson().toJson(map))
                    .asString();

            return Float.parseFloat(resp.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
