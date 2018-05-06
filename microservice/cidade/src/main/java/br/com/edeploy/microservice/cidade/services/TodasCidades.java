package br.com.edeploy.microservice.cidade.services;

import br.com.edeploy.microservice.cidade.config.Url;
import br.com.edeploy.microservice.cidade.models.Cidade;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TodasCidades {
    List<Cidade> lista = new ArrayList<>();

    public TodasCidades() {

    }

    private void add(JSONArray jsonArray) {
        for(int i = 0; i < jsonArray.length(); ++i) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            lista.add(new Cidade((i + 1), jsonObject.getString("Nome"), jsonObject.getString("Estado")));
        }
    }

    public List<Cidade> getAll() {
        lista.clear();

        try {
            HttpResponse<JsonNode> jsonResp = Unirest
                    .get(Url.BUSCATODASCIDADES)
                    .asJson();

            JSONArray jsonCidades = jsonResp
                    .getBody()
                    .getArray();

            add(jsonCidades);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
