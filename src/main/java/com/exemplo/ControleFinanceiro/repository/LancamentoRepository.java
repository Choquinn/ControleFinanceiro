package com.exemplo.ControleFinanceiro.repository;

import com.exemplo.ControleFinanceiro.model.Lancamento;
import com.exemplo.ControleFinanceiro.model.TipoLancamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	@Query("SELECT COALESCE(SUM(l.valor), 0) FROM Lancamento l WHERE l.tipo = 'RECEITA'")
    BigDecimal somarReceitas();
	
	@Query("SELECT COALESCE(SUM(l.valor), 0) FROM Lancamento l WHERE l.tipo = 'DESPESA'")
    BigDecimal somarDespesas();
	
	List<Lancamento> findByTipo(TipoLancamento tipo);
}
