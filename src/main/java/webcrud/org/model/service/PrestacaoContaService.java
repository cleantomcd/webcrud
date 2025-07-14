package webcrud.org.model.service;

import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dao.PrestacaoContaImpl;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class PrestacaoContaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PrestacaoContaImpl prestacaoContaImpl;

    @PostConstruct
    public void init() {
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
