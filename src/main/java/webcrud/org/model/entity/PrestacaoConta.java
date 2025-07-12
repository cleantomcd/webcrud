package webcrud.org.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import webcrud.org.model.entity.dto.PrestacaoContaDTO;


//@Entity
//@Table(name = "PRESTACAO_CONTA")
public class PrestacaoConta implements Serializable {

	private static final long serialVersionUID = 1L;

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;
	private int valor;
	private LocalDate data;
	private String categoria;


	// gerar o id automaticamente
	public PrestacaoConta() {}

	public PrestacaoConta(PrestacaoContaDTO prestacaoContaDTO) {
		super();
		this.id = prestacaoContaDTO.id();
		this.descricao = prestacaoContaDTO.descricao();
		this.valor = prestacaoContaDTO.valor();
		this.data = prestacaoContaDTO.data();
		this.categoria = prestacaoContaDTO.categoria();
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
