package webcrud.org.model.service;

import java.io.Serializable;
import java.text.ParseException;
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
public class PrestacaoContaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PrestacaoContaImpl prestacaoContaImpl;

	private List<PrestacaoContaDTO> prestacoes;
	
	@PostConstruct
	public void init() throws ParseException {
        this.prestacoes = new ArrayList<>();
        PrestacaoContaDTO p = new PrestacaoContaDTO(23342L, "desc" ,1230, LocalDate.now(), "Categoria"); 
        prestacoes.add(p);        prestacoes.add(p);
        prestacoes.add(p);
        prestacoes.add(p);
        prestacoes.add(p);

    }

	public List<PrestacaoContaDTO> getAllPrestacaoConta() {
		 //return prestacaoContaImpl.getAllPrestacaoConta(); -> apenas para mostrar o cadastro de prestacoes momentaneamente
		return this.prestacoes;
	}
	public PrestacaoContaDTO getById(Long id) {
		return prestacaoContaImpl.getById(id);
	}

	public boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		System.out.println("entrou aqui");//enquanto não está integrado com a JPA, temos que criar manualmente
		return prestacoes.add(prestacaoContaDTO);
	}

	public boolean deletePrestacaoConta(Long id) {
		return prestacaoContaImpl.deletePrestacaoConta(id);
	}

	public void updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		prestacaoContaImpl.updatePrestacaoConta(prestacaoContaDTO);
	}

}
