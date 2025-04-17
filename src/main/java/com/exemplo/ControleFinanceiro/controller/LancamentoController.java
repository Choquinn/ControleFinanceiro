package com.exemplo.ControleFinanceiro.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.ControleFinanceiro.model.Lancamento;
import com.exemplo.ControleFinanceiro.model.TipoLancamento;
import com.exemplo.ControleFinanceiro.service.LancamentoService;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

	private final LancamentoService lancamentoService;
	
	public LancamentoController(LancamentoService lancamentoService) {
		this.lancamentoService = lancamentoService;
	}
	
	@GetMapping
	public List<Lancamento> listarTodas() {
		return lancamentoService.listarTodos();
	}
	
	@GetMapping("/tipo")
	public List<Lancamento> listarPorTipo(@RequestParam TipoLancamento tipo) {
		return lancamentoService.listarTipo(tipo);
	}
	
	@PostMapping
	public Lancamento criar(@RequestBody Lancamento lancamento) {
		return lancamentoService.salvar(lancamento);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Lancamento> atualizar(@PathVariable Long id, @RequestBody Lancamento lancamentoAtualizado) {
		return lancamentoService.buscarPorId(id)
				.map(lancamento -> {
					lancamento.setValor(lancamentoAtualizado.getValor());
					lancamento.setDescricao(lancamentoAtualizado.getDescricao());
					lancamento.setData(lancamentoAtualizado.getData());
					lancamento.setCategoria(lancamentoAtualizado.getCategoria());
					lancamento.setTipo(lancamentoAtualizado.getTipo());
					return ResponseEntity.ok(lancamentoService.salvar(lancamento));
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		lancamentoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/total")
	public String total() {
		return lancamentoService.calcularSaldo();
	}
}
