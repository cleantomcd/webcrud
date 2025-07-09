package webcrud.org.model.entity.dto;

import webcrud.org.model.entity.PrestacaoConta;

import java.sql.Date;

public record PrestacaoContaDTO(Long id, String descricao, int valor, Date data, String categoria) {

    public PrestacaoContaDTO(PrestacaoConta prestacao) {
        this(prestacao.getId(), prestacao.getDescricao(), prestacao.getValor(), prestacao.getData(), prestacao.getCategoria());
    }

    public PrestacaoContaDTO(String descricao, int valor, Date data) {
        this(null, descricao, valor, data, null);
    }

}


