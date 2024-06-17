package com.sistema.ciao.sistema_ciao_backend;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sistema.ciao.sistema_ciao_backend.entities.Permission;
import com.sistema.ciao.sistema_ciao_backend.entities.Role;
import com.sistema.ciao.sistema_ciao_backend.entities.UserEntity;
import com.sistema.ciao.sistema_ciao_backend.repository.UserRepository;

@SpringBootApplication
public class SistemaCiaoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaCiaoBackendApplication.class, args);
	}

	//Para llenar permisos, usuarios y roles por primera vez
	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			//Creando permisos
			Permission creatPermission = Permission.builder()
			.name("CREATE")
			.build();

			Permission readPermission = Permission.builder()
			.name("READ")
			.build();

			Permission updatePermission = Permission.builder()
			.name("UPDATE")
			.build();

			Permission deletePermission = Permission.builder()
			.name("DELETE")
			.build();

			Permission refactorPermission = Permission.builder()
			.name("REFACTOR")
			.build();

			//CREANDO ROLES
			Role roleAdmin = Role.builder()
			.role("ADMIN")
			.permissionList(Set.of(creatPermission, readPermission, updatePermission, deletePermission, refactorPermission))
			.build();

			Role roleStudent = Role.builder()
			.role("STUDENT")
			.permissionList(Set.of(readPermission, updatePermission))
			.build();

			UserEntity userIrving = UserEntity.builder()
			.name("irving")
			.password("123")
			.email("invax25@hotmail.com")
			.isEnable(true)
			.accountNoExpired(true)
			.accountLocked(true)
			.credentialNoExpired(true)
			.role(roleAdmin  )
			.build();

			UserEntity userAnuar = UserEntity.builder()
			.name("anuar")
			.password("123456")
			.email("invax24@hotmail.com")
			.isEnable(true)
			.accountNoExpired(true)
			.accountLocked(true)
			.credentialNoExpired(true)
			.role(roleStudent)
			.build();

			userRepository.saveAll(List.of(userIrving, userAnuar));

		};
	}
}
