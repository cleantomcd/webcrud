package webcrud.org.model.entity.dao;

import java.util.List;

import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

public interface PrestacaoContaDAO {

	public List<PrestacaoContaDTO> getAllPrestacaoConta();

	public PrestacaoContaDTO getById(Long id);

	public boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO);

	public boolean deletePrestacaoConta(Long id);

	public void deletePrestacaoConta(List<PrestacaoConta> prestacoes);

	public void updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO);

}
