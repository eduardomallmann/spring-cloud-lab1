package com.treinamento.voffice.springcloudconfigclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class SpringCloudConfigClientApplication {

    @Value("${treinamento.curso}")
    String curso;

    @Value("${treinamento.carga.horaria}")
    String cargaHoraria;
    @GetMapping("/curso")
    public ResponseEntity<JsonNode> getCurso() {
        JsonNode response = JsonNodeFactory.instance.objectNode();
        ((ObjectNode) response).put("curso", curso);
        ((ObjectNode) response).put("cargaHoraria", cargaHoraria);
        return ResponseEntity.ok(response);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }
}
