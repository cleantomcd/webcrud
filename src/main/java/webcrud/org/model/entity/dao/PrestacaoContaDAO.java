package webcrud.org.model.entity.dao;

import java.util.List;
import java.util.stream.Stream;

import webcrud.org.model.entity.dto.PrestacaoContaDTO;

public interface PrestacaoContaDAO {

	public List<PrestacaoContaDTO> getAllPrestacaoConta();

	public PrestacaoContaDTO getById(Long id);

	public boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO);

	public boolean deletePrestacaoConta(Long id);

	public void updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO);

}
