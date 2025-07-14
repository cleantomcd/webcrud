package webcrud.org.model.entity.dao;

import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
@Transactional
public class PrestacaoContaImpl implements PrestacaoContaDAO {

    @PersistenceContext(unitName = "webcrud")
    private EntityManager em;

    @Override
    public List<PrestacaoConta> getAllPrestacaoConta() {
        return em.createQuery("SELECT p FROM PrestacaoConta p", PrestacaoConta.class).getResultList();
    }

    @Override
    public PrestacaoConta getById(Long id) {
        PrestacaoConta prestacaoConta = em.find(PrestacaoConta.class, id);
        if (prestacaoConta == null) {
            throw new NullPointerException("Não há prestação de contas com esse id");
        }
        return prestacaoConta;
    }

    @Override
    public boolean savePrestacaoConta(PrestacaoContaDTO dto) {
        PrestacaoConta pc = new PrestacaoConta(dto);
        em.persist(pc);
        return true;
    }

    @Override
    public boolean deletePrestacaoConta(Long id) {
        PrestacaoConta prestacao = em.find(PrestacaoConta.class, id);
        if (prestacao != null) {
            em.remove(prestacao);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePrestacaoConta(PrestacaoContaDTO dto) {
        PrestacaoConta pc = new PrestacaoConta(dto);
        em.merge(pc);
        return true;
    }

    @Override
    public void deletePrestacaoConta(List<PrestacaoConta> prestacoes) {
        for (PrestacaoConta pc : prestacoes) {
            deletePrestacaoConta(pc.getId());
        }
    }
}
