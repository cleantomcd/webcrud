package webcrud.org.model.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import webcrud.org.model.entity.Categoria;
import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dao.PrestacaoContaImpl;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

@Named
@ApplicationScoped
public class PrestacaoContaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PrestacaoContaImpl prestacaoContaImpl;

	@PostConstruct
	public void init() {
		prestacaoContaImpl.savePrestacaoConta(new PrestacaoContaDTO(10001L, "Aluguel escritório", new BigDecimal("200.00"), LocalDate.of(2025, 7, 1), Categoria.PRESTACAO_CONTAS_ANUAL));
		prestacaoContaImpl.savePrestacaoConta(new PrestacaoContaDTO(10002L, "Compra de materiais", new BigDecimal("780.00"), LocalDate.of(2025, 6, 25), Categoria.PRESTACAO_CONTAS_COLABORADORES));
		prestacaoContaImpl.savePrestacaoConta(new PrestacaoContaDTO(10003L, "Serviços terceirizados", new BigDecimal("1500.00"), LocalDate.of(2025, 6, 28), Categoria.PRESTACAO_CONTAS_PARTIDOS));
		prestacaoContaImpl.savePrestacaoConta(new PrestacaoContaDTO(10004L, "Transporte", new BigDecimal("320.00"), LocalDate.of(2025, 7, 5), Categoria.PRESTACAO_CONTAS_PROJETOS));
    }

	public List<PrestacaoConta> getAllPrestacaoConta() {
		 return prestacaoContaImpl.getAllPrestacaoConta();
	}
	public PrestacaoConta getById(Long id) {
		return prestacaoContaImpl.getById(id);
	}

	public boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		return prestacaoContaImpl.savePrestacaoConta(prestacaoContaDTO);
	}

	public boolean deletePrestacaoConta(Long id) {
		return prestacaoContaImpl.deletePrestacaoConta(id);
	}
	
	public void deletePrestacaoConta(List<PrestacaoConta> prestacoes) {
		prestacaoContaImpl.deletePrestacaoConta(prestacoes);
	}

	public boolean updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		return prestacaoContaImpl.updatePrestacaoConta(prestacaoContaDTO);
	}

}
