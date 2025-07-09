package webcrud.org.model.service;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

import webcrud.org.model.entity.dao.PrestacaoContaImpl;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

@ApplicationScoped
public class PrestacaoContaService {

	@Inject
	private PrestacaoContaImpl prestacaoContaImpl;
	
	
	public List<PrestacaoContaDTO> getAllPrestacaoConta() {
		 return prestacaoContaImpl.getAllPrestacaoConta();
	}
	
	public PrestacaoContaDTO getById(Long id) {
		return prestacaoContaImpl.getById(id);
	}
	
	public boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		return prestacaoContaImpl.savePrestacaoConta(prestacaoContaDTO);
	}
	
	public boolean deletePrestacaoConta(Long id) {
		return prestacaoContaImpl.deletePrestacaoConta(id);
	}
	
	public void updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		prestacaoContaImpl.updatePrestacaoConta(prestacaoContaDTO);
	}
	
}
