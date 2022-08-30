package com.finance.myfinances.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.myfinances.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
