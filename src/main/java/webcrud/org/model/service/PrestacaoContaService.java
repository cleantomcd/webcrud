package webcrud.org.model.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dao.PrestacaoContaImpl;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

@Named
@ApplicationScoped
public class PrestacaoContaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PrestacaoContaImpl prestacaoContaImpl;

	private List<PrestacaoContaDTO> prestacoes;

	@PostConstruct
	public void init() {
		prestacaoContaImpl.savePrestacaoConta(new PrestacaoContaDTO(10001L, "Aluguel escritório", 2500, LocalDate.of(2025, 7, 1), "1"));
		prestacaoContaImpl.savePrestacaoConta(new PrestacaoContaDTO(10002L, "Compra de materiais", 780, LocalDate.of(2025, 6, 25), "2"));
		prestacaoContaImpl.savePrestacaoConta(new PrestacaoContaDTO(10003L, "Serviços terceirizados", 1500, LocalDate.of(2025, 6, 28), "3"));
		prestacaoContaImpl.savePrestacaoConta(new PrestacaoContaDTO(10004L, "Transporte", 320, LocalDate.of(2025, 7, 5), "4"));
    }

	public List<PrestacaoContaDTO> getAllPrestacaoConta() {
		 return prestacaoContaImpl.getAllPrestacaoConta();
	}
	public PrestacaoContaDTO getById(Long id) {
		return prestacaoContaImpl.getById(id);
	}

	public boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		return prestacaoContaImpl.savePrestacaoConta(prestacaoContaDTO); // corrigir para adicionar no repository DAO.
	}

	public boolean deletePrestacaoConta(Long id) {
		return prestacaoContaImpl.deletePrestacaoConta(id);
	}
	
	public void deletePrestacaoConta(List<PrestacaoConta> prestacoes) {
		prestacaoContaImpl.deletePrestacaoConta(prestacoes);
	}

	public void updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		prestacaoContaImpl.updatePrestacaoConta(prestacaoContaDTO);
	}

}
