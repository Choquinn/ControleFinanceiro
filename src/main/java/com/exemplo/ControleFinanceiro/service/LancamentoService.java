package com.exemplo.ControleFinanceiro.service;

import com.exemplo.ControleFinanceiro.model.Lancamento;
import com.exemplo.ControleFinanceiro.model.TipoLancamento;
import com.exemplo.ControleFinanceiro.repository.LancamentoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {
	private final LancamentoRepository lancamentoRepository;
	
	public LancamentoService(LancamentoRepository lancamentoRepository) {
		this.lancamentoRepository = lancamentoRepository;
	}
	
	public List<Lancamento> listarTodos() {
		return lancamentoRepository.findAll();
	}
	
	public List<Lancamento> listarTipo(TipoLancamento tipo) {
		return lancamentoRepository.findByTipo(tipo);
	}
	
	public String calcularSaldo() {
        BigDecimal receitas = lancamentoRepository.somarReceitas();
	    BigDecimal despesas = lancamentoRepository.somarDespesas();
	    BigDecimal total = receitas.subtract(despesas);
	    BigDecimal zero = new BigDecimal("0.00");
	    if (total.compareTo(zero) > 0) {
	    	return ("Você ainda tem " + total + " reais");
	    }else if (total.compareTo(zero) == 0.00) {
	    	return ("Você está zerado");
	    }else {
	    	return ("Você está devendo " + total.abs() + " reais");
	    }
	}

	
	public Lancamento salvar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}
	
	public Optional<Lancamento> buscarPorId(Long id) {
		return lancamentoRepository.findById(id);
	}
	
	public void deletar(Long id) {
		lancamentoRepository.deleteById(id);
	}
}
