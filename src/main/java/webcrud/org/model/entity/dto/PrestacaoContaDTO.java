package webcrud.org.model.entity.dto;

import webcrud.org.model.entity.Categoria;
import webcrud.org.model.entity.PrestacaoConta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PrestacaoContaDTO(Long id, String descricao, BigDecimal valor, LocalDate data, Categoria categoria) {

    public PrestacaoContaDTO(PrestacaoConta prestacao) {
        this(prestacao.getId(), prestacao.getDescricao(), prestacao.getValor(), prestacao.getData(), prestacao.getCategoria());
    }

    public PrestacaoContaDTO(Long id, String descricao, BigDecimal valor, LocalDate data, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }

}


