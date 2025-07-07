package webcrud.org.model.entity.dao;

import java.util.List;

import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

public interface PrestacaoContaDAO {

	public List<PrestacaoContaDTO> getAllPrestacaoConta();
	
	public List<PrestacaoConta> getAllPrestacaoContaDetails();
	
	public void savePrestacaoConta();
	
	public boolean deletePrestacaoConta();
	
	public void updatePrestacaoConta();
	
}
