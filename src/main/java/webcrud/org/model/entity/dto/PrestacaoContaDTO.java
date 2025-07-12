package webcrud.org.model.entity.dto;

import java.time.LocalDate;

import webcrud.org.model.entity.PrestacaoConta;

public record PrestacaoContaDTO(Long id, String descricao, int valor, LocalDate data, String categoria) {

    public PrestacaoContaDTO(PrestacaoConta prestacao) {
        this(prestacao.getId(), prestacao.getDescricao(), prestacao.getValor(), prestacao.getData(), prestacao.getCategoria());
    }

    public PrestacaoContaDTO(String descricao, int valor, LocalDate data) {
        this(null, descricao, valor, data, null);
    }

    public PrestacaoContaDTO(Long id, String descricao, int valor, LocalDate data, String categoria) {
    	this.id = id;
    	this.descricao = descricao;
    	this.valor = valor;
    	this.data = data;
    	this.categoria = categoria;
    }

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getValor() {
		return valor;
	}

	public LocalDate getData() {
		return data;
	}

	public String getCategoria() {
		return categoria;
	}





}


