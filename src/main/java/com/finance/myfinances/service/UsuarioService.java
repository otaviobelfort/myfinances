package com.finance.myfinances.service;

import java.util.Optional;

import com.finance.myfinances.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);
	
	// query methods
	Optional<Usuario> obterPorId(Long id);

}
