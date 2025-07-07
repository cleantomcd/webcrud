package webcrud.org.model.entity.dto;

import java.sql.Date;

public record PrestacaoContaDTO() {
	 public PrestacaoContaDTO(Long id, String descricao, int valor, Date data, String categoria) {
		 this();
	 }
}

	
