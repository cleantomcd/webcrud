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
        this.prestacoes = new ArrayList<>();
        prestacoes.add(new PrestacaoContaDTO(10001L, "Aluguel escritório", 2500, LocalDate.of(2025, 7, 1), "1"));
        prestacoes.add(new PrestacaoContaDTO(10002L, "Compra de materiais", 780, LocalDate.of(2025, 6, 25), "2"));
        prestacoes.add(new PrestacaoContaDTO(10003L, "Serviços terceirizados", 1500, LocalDate.of(2025, 6, 28), "3"));
        prestacoes.add(new PrestacaoContaDTO(10004L, "Transporte", 320, LocalDate.of(2025, 7, 5), "4"));


    }

	public List<PrestacaoContaDTO> getAllPrestacaoConta() {
		 //return prestacaoContaImpl.getAllPrestacaoConta(); -> apenas para mostrar o cadastro de prestacoes momentaneamente
		return this.prestacoes;
	}
	public PrestacaoContaDTO getById(Long id) {
		return prestacaoContaImpl.getById(id);
	}

	public boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		return prestacoes.add(prestacaoContaDTO); // corrigir para adicionar no repository DAO.
	}

	public boolean deletePrestacaoConta(Long id) {
		return prestacoes.removeIf(prestacao -> prestacao.getId().equals(id)); // temporário para remover o da List (enquanto sem o jpa)
		
		//return prestacaoContaImpl.deletePrestacaoConta(id);
	}
	
	public boolean deletePrestacaoConta(List<PrestacaoConta> prestacoes) {
		return prestacoes.removeAll(prestacoes);
		//return prestacaoContaImpl.deletePrestacaoConta(prestacoes); ---> implementar
	}


	public void updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		prestacaoContaImpl.updatePrestacaoConta(prestacaoContaDTO);
	}

}
