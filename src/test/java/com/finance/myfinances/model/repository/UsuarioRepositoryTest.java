package com.finance.myfinances.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.finance.myfinances.model.entity.Usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@SpringBootTest
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class UsuarioRepositoryTest {
	
	/* ESTRUTURA DO TESTE
	 * 01 - Cenário
	 * 02 - Execução
	 * 03 - Resultado/Verificação
	 */
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void validacaoDeEmailIsExist() {
		
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		
		boolean result = usuarioRepository.existsByEmail("usuario@email.com");
		
		Assertions.assertThat(result).isTrue();
		
	}
	
	public static Usuario criarUsuario() {
		return Usuario
				.builder()
				.nome("usuario")
				.email("usuario@email.com")
				.senha("senha")
				.build();
	}

}
