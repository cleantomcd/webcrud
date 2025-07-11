package webcrud.org.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

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

	public void setPrestacaoSelecionada(PrestacaoConta prestacaoSelecionada) {
		this.prestacaoSelecionada = prestacaoSelecionada;
	}

	public void setPrestacoesSelecionadas(List<PrestacaoConta> prestacoesSelecionadas) {
		this.prestacoesSelecionadas = prestacoesSelecionadas;
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

	public boolean possuiPrestacoesSelecionadas() {
		return prestacoesSelecionadas != null && !prestacoesSelecionadas.isEmpty();
	}

	public List<PrestacaoContaDTO> getPrestacoesCadastradas() {
		return this.prestacaoContaService.getAllPrestacaoConta();
	}

	public PrestacaoConta getPrestacaoSelecionada() {
		return this.prestacaoSelecionada;
	}

	public void deletePrestacoesSelecionadas() {
		this.prestacoesSelecionadas.clear();
	}

	public List<PrestacaoConta> getPrestacoesSelecionadas() {
		return this.prestacoesSelecionadas;
	}

	public boolean cadastrarPrestacao() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Prestação cadastrada"));
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");

		return this.prestacaoContaService.savePrestacaoConta(new PrestacaoContaDTO(prestacaoSelecionada));
	}
}
