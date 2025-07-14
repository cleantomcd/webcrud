package webcrud.org.model.entity.dao;

import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

import java.util.List;

public interface PrestacaoContaDAO {

    List<PrestacaoConta> getAllPrestacaoConta();

    PrestacaoConta getById(Long id);

    boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO);

    boolean deletePrestacaoConta(Long id);

    void deletePrestacaoConta(List<PrestacaoConta> prestacoes);

    boolean updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO);

}
