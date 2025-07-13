package webcrud.org.model.entity.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;

@Named
@ApplicationScoped
public class PrestacaoContaImpl implements PrestacaoContaDAO {

    ArrayList<PrestacaoConta> prestacaoContas = new ArrayList<>();

    @Override
    public List<PrestacaoContaDTO> getAllPrestacaoConta() {
        return prestacaoContas.stream().map(prestacao -> new PrestacaoContaDTO(prestacao.getDescricao(), prestacao.getValor(), prestacao.getData())).collect(Collectors.toList());
    }

    @Override
    public PrestacaoContaDTO getById(Long id) {
        PrestacaoConta prestacaoConta = getPrestacaoConta(id);
        if (prestacaoConta == null) {
            throw new NullPointerException("Não há prestação de contas com ess id");
        }
        return new PrestacaoContaDTO(prestacaoConta);
    }

    @Override
    public boolean savePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
        return prestacaoContas.add(new PrestacaoConta(prestacaoContaDTO));
    }

    @Override
    public boolean deletePrestacaoConta(Long id) {
        PrestacaoConta prestacaoConta = getPrestacaoConta(id);
        return prestacaoConta != null && prestacaoContas.remove(prestacaoConta);
    }

    public void deletePrestacaoConta(List<PrestacaoConta> prestacoes) {
        Set<Long> idsParaRemover = prestacoes.stream()
                .map(PrestacaoConta::getId)
                .collect(Collectors.toSet());

        this.prestacaoContas = (ArrayList<PrestacaoConta>) this.prestacaoContas.stream()
                .filter(pc -> !idsParaRemover.contains(pc.getId()))
                .collect(Collectors.toList());
    }


    @Override
    public void updatePrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
        deletePrestacaoConta(prestacaoContaDTO.id());
        savePrestacaoConta(prestacaoContaDTO);
    }

    private PrestacaoConta getPrestacaoConta(Long id) {
        return prestacaoContas.stream().filter(prestacao -> prestacao.getId().equals(id)).findFirst().orElse(null);
    }

}
