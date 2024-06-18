package com.sistema.ciao.sistema_ciao_backend.rest.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"userName", "message", "jwt", "status"})
public record AuthResponse(String userName, String message, String jwt, Boolean status) {

}
