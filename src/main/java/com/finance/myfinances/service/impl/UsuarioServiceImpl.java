package com.finance.myfinances.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.myfinances.model.entity.Usuario;
import com.finance.myfinances.model.repository.UsuarioRepositoryTest;
import com.finance.myfinances.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepositoryTest usuarioRepository;
	private PasswordEncoder encoder;
	
	public UsuarioServiceImpl(UsuarioRepositoryTest usuarioRepository, 
								PasswordEncoder encoder) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return null;
	}

	@Override
	public void validarEmail(String email) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		
		if(!usuario.isPresent()) {
//			throw new ErroAutenticacao("Usuário não encontrado para o email informado.");
		}
		
		boolean senhasBatem = encoder.matches(senha, usuario.get().getSenha());
		
		if(!senhasBatem) {
//			throw new ErroAutenticacao("Senha inválida.");
		}
		return usuario.get();
	}

	@Override
	public Optional<Usuario> obterPorId(Long id) {
		return Optional.empty();
	}

}
