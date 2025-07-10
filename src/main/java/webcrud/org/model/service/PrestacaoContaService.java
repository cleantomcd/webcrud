package webcrud.org.model.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import webcrud.org.model.entity.dao.PrestacaoContaImpl;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

@Named
@ApplicationScoped
public class PrestacaoContaService {

	@Inject
	private PrestacaoContaImpl prestacaoContaImpl;

	private List<PrestacaoContaDTO> prestacoes;

	@PostConstruct
	public void init() {
        this.prestacoes = new ArrayList<>();
        PrestacaoContaDTO p = new PrestacaoContaDTO("desc" ,1230, Date.valueOf(LocalDate.now())); 
        prestacoes.add(p);        prestacoes.add(p);
        prestacoes.add(p);
        prestacoes.add(p);
        prestacoes.add(p);

    }

	public List<PrestacaoContaDTO> getAllPrestacaoConta() {
		 //return prestacaoContaImpl.getAllPrestacaoConta();
		return this.prestacoes;
	}

	public PrestacaoContaDTO getById(Long id) {
		return prestacaoContaImpl.getById(id);
	}

	public boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) { //enquanto não está integrado com a JPA, temos que criar manualmente
		return prestacaoContaImpl.savePrestacaoConta(prestacaoContaDTO);
	}

	public boolean deletePrestacaoConta(Long id) {
		return prestacaoContaImpl.deletePrestacaoConta(id);
	}

	public void updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		prestacaoContaImpl.updatePrestacaoConta(prestacaoContaDTO);
	}

}
