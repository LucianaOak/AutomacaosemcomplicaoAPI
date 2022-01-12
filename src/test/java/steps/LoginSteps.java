package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import maps.LoginMap;
import utils.RestUtils;

import java.util.Map;

public class LoginSteps {

    String url = "http://localhost:8080/";

    @Dado("que tenha payload valido da API de Login")
    public void queTenhaPayloadValidoDaAPIDeLogin() {
        LoginMap.initLogin();
        RestUtils.setBaseURI(url);
    }

    @Quando("envio uma requisicao do tipo POST de Login")
    public void envioUmaRequisicaoDoTipoPOSTDeLogin() {
        RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");

    }

    @Entao("armazeno o token que recebo de Login")
    public void armazenoOTokenQueReceboDeLogin() {
        LoginMap.token = RestUtils.getResponse().jsonPath().get("token");
    }

    @Dado("que tenha um payload da API de Login com as seguintes informacoes")
    public void queTenhaUmPayloadDaAPIDeLoginComAsSeguintesInformacoes(Map<String, String> map) {
        LoginMap.initLogin();
        RestUtils.setBaseURI(url);
        LoginMap.getLogin().putAll(map);
    }
    @Dado("que tenha realizado o login com dados validos")
    public void queTenhaRealizadoOLoginComDadosValidos() {
        queTenhaPayloadValidoDaAPIDeLogin();
        envioUmaRequisicaoDoTipoPOSTDeLogin();
        armazenoOTokenQueReceboDeLogin();
    }
}