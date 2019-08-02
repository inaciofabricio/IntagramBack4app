package com.parse.starter.util;

import android.content.Intent;

import java.util.HashMap;

public class ParseErros {

    private HashMap<Integer, String> erros;

    public ParseErros() {
        this.erros = new HashMap<>();
        this.erros.put(-1,"OTHER_CAUSE");
        this.erros.put(1,"INTERNAL_SERVER_ERROR");
        this.erros.put(100,"CONNECTION_FAILED");
        this.erros.put(101,"OBJECT_NOT_FOUND");
        this.erros.put(102,"INVALID_QUERY");
        this.erros.put(103,"INVALID_CLASS_NAME");
        this.erros.put(104,"MISSING_OBJECT_ID");
        this.erros.put(105,"INVALID_KEY_NAME");
        this.erros.put(106,"INVALID_POINTER");
        this.erros.put(107,"INVALID_JSON");
        this.erros.put(108,"COMMAND_UNAVAILABLE");
        this.erros.put(109,"NOT_INITIALIZED");
        this.erros.put(111,"INCORRECT_TYPE");
        this.erros.put(112,"INVALID_CHANNEL_NAME");
        this.erros.put(115,"PUSH_MISCONFIGURED");
        this.erros.put(116,"OBJECT_TOO_LARGE");
        this.erros.put(119,"OPERATION_FORBIDDEN");
        this.erros.put(120,"CACHE_MISS");
        this.erros.put(121,"INVALID_NESTED_KEY");
        this.erros.put(122,"INVALID_FILE_NAME");
        this.erros.put(123,"INVALID_ACL");
        this.erros.put(124,"TIMEOUT");
        this.erros.put(125,"E-mail inválido!");
        this.erros.put(137,"DUPLICATE_VALUE");
        this.erros.put(139,"INVALID_ROLE_NAME");
        this.erros.put(140,"EXCEEDED_QUOTA");
        this.erros.put(141,"SCRIPT_ERROR");
        this.erros.put(142,"VALIDATION_ERROR");
        this.erros.put(153,"FILE_DELETE_ERROR");
        this.erros.put(155,"REQUEST_LIMIT_EXCEEDED");
        this.erros.put(160,"INVALID_EVENT_NAME");
        this.erros.put(200,"Usuário não foi informado!");
        this.erros.put(201,"Senha não foi informada!");
        this.erros.put(202,"Usuário já existe, escolha um outro nome de usuário!");
        this.erros.put(203,"E-mail já cadastrado, escolha um outro E-mail!");
        this.erros.put(204,"E-mail não foi informado!");
        this.erros.put(205,"E-mail não encontrado!");
        this.erros.put(206,"SESSION_MISSING");
        this.erros.put(207,"MUST_CREATE_USER_THROUGH_SIGNUP");
        this.erros.put(208,"ACCOUNT_ALREADY_LINKED");
        this.erros.put(209,"INVALID_SESSION_TOKEN");
        this.erros.put(250,"LINKED_ID_MISSING");
        this.erros.put(251,"INVALID_LINKED_SESSION");
        this.erros.put(252,"UNSUPPORTED_SERVICE");

        this.erros.put(300,"Usuário ou Senha inválidos!");
        this.erros.put(301,"Erro Grave - Estamos corrigindo!");
        this.erros.put(302,"Usuário não informado!");
        this.erros.put(303,"Senha não informada!");


    }

    public String getErro(int codErro){
        return this.erros.get(codErro);
    }
}
