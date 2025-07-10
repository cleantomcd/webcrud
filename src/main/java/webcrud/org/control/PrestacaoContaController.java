package webcrud.org.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;
import webcrud.org.model.service.PrestacaoContaService;

@Named
@ApplicationScoped
public class PrestacaoContaController {

	@Inject
	private PrestacaoContaService prestacaoContaService;

	private PrestacaoConta prestacaoSelecionada;

	private List<PrestacaoConta> prestacoesSelecionadas;

	public PrestacaoContaController() {

	}

	public void criarPrestacao() {
		this.prestacaoSelecionada = new PrestacaoConta();
	}

	public String getMensagemBotaoDelete() {
		if(possuiPrestacoesSelecionadas()) {
			int size = prestacoesSelecionadas.size();
			return size > 1 ? size + " registros selecionados" : "1 registro selecionado";
		}
		return "Excluir";
	}

	private boolean possuiPrestacoesSelecionadas() {
		return prestacoesSelecionadas != null && !prestacoesSelecionadas.isEmpty();
	}

	public List<PrestacaoContaDTO> getPrestacoesCadastradas() {
		return this.prestacaoContaService.getAllPrestacaoConta();
	}

	public PrestacaoConta getPrestacaoSelecionada() {
		return this.prestacaoSelecionada;
	}



}
