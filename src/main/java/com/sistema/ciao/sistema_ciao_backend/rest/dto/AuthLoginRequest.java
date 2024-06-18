package com.sistema.ciao.sistema_ciao_backend.rest.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String userName, @NotBlank String password) {

}
