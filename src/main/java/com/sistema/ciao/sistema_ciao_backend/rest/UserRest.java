package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.sistema.ciao.sistema_ciao_backend.entities.UserEntity;
import com.sistema.ciao.sistema_ciao_backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRest {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
   public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    //Metodo para crear un usuario
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserEntity user) {
        // Asegurarse de que no se incluye el ID en la solicitud
        user.setId(null); // Opcionalmente, asegúrate de que el ID se establezca como null para evitar problemas

        // Verificar si el usuario ya existe
        if (userService.userExists(user.getName(), user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario ya está registrado");
        } else {
            // Encriptar la contraseña antes de guardar el usuario
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            // Guardar el usuario
            UserEntity savedUser = userService.saveUser(user);

            return ResponseEntity.ok("Usuario creado exitosamente: " + savedUser.getId());
        }
    }
}