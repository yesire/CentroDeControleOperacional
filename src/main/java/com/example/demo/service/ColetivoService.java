package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Coletivo;
import com.example.demo.exceptions.ColetivoNaoFoiSalvoException;
import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.repository.ColetivoRepository;

@Service
public class ColetivoService {
	
	private ColetivoRepository coletivoRepository;

	public ColetivoService(ColetivoRepository coletivoRepository) {
		this.coletivoRepository = coletivoRepository;
	}
	
	public List<Coletivo> listaColetivos () {
			return coletivoRepository.findAll();
	}
	
	
	public Coletivo adicionar (Coletivo coletivo) {
		try {
			return coletivoRepository.save(coletivo);			
		}catch (Exception e) {
			throw new ColetivoNaoFoiSalvoException("Coletivo não foi salvo");
		}	
	}
	
	public Coletivo pesquisarColetivoPorId (Long id) {
		Optional<Coletivo> optional = coletivoRepository.findById(id);
		return optional.orElseThrow(()  -> new EntityNotFoundException("Coletivo não encontrado"));
	}
	
	public Coletivo pesquisarColetivoPorPrefixo (String prefixo) {
		Optional<Coletivo> optional = coletivoRepository.findByPrefixo(prefixo);
		return optional.orElseThrow(()  -> new EntityNotFoundException("Coletivo não encontrado"));
	}

	public Coletivo pesquisarColetivoPorPlaca (String placa) {
		Optional<Coletivo> optional = coletivoRepository.findByPlaca(placa);
		return optional.orElseThrow(()  -> new EntityNotFoundException("Coletivo não encontrado"));
	}
	
	public Coletivo alterarColetivoPorId (Coletivo coletivo, Long id) {
		Coletivo coletivoOriginal = pesquisarColetivoPorId(id);
		coletivo.setId(coletivoOriginal.getId());
		return coletivoRepository.save(coletivo);
	}
	
	public Coletivo alterarColetivoPorPrefixo (Coletivo coletivo, String prefixo) {
		Coletivo coletivoOriginal = pesquisarColetivoPorPrefixo(prefixo);
		coletivo.setId(coletivoOriginal.getId());
		return coletivoRepository.save(coletivo);
	}
	
	public Coletivo alterarColetivoPorPlaca (Coletivo coletivo, String placa) {
		Coletivo coletivoOriginal = pesquisarColetivoPorPlaca(placa);
		coletivo.setId(coletivoOriginal.getId());
		return coletivoRepository.save(coletivo);
	}
	
	public void deletarColetivoPorId (Long id) {
		Coletivo coletivo = pesquisarColetivoPorId(id);
		coletivoRepository.delete(coletivo);
	}
	
	public void deletarColetivoPorPrefixo (String  prefixo) {
		Coletivo coletivo = pesquisarColetivoPorPrefixo(prefixo);
		coletivoRepository.delete(coletivo);
	}
	
}