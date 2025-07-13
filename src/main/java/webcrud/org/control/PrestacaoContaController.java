package webcrud.org.control;

import org.primefaces.PrimeFaces;
import webcrud.org.model.entity.PrestacaoConta;
import webcrud.org.model.entity.dto.PrestacaoContaDTO;
import webcrud.org.model.service.PrestacaoContaService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class PrestacaoContaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PrestacaoContaService prestacaoContaService;

    private PrestacaoConta prestacaoSelecionada;

    private List<PrestacaoConta> prestacoesSelecionadas;

    public PrestacaoContaController() {

    }

    @PostConstruct
    public void init() {
        this.prestacoesSelecionadas = new ArrayList<>();
    }

    public void setDTOtoPrestacaoSelecionada(PrestacaoContaDTO prestacaoDTO) {
        this.prestacaoSelecionada = new PrestacaoConta(prestacaoDTO);
    }

    public void criarPrestacao() {
        this.prestacaoSelecionada = new PrestacaoConta();
    }

    public String getMensagemBotaoDelete() {
        if (possuiPrestacoesSelecionadas()) {
            int size = prestacoesSelecionadas.size();
            return size > 1 ? size + " registros selecionados" : "1 registro selecionado";
        }
        return "Excluir";
    }

    public boolean possuiPrestacoesSelecionadas() {
        return prestacoesSelecionadas != null && !prestacoesSelecionadas.isEmpty();
    }


    // possíveis soluções: alterar para retornar a entidade PrestacaoConta ou tratar os DTOs de maneira correta. Verificar os lugares nos quais se cria uma entidade de PrestacaoConta e converter para DTO
    public List<PrestacaoContaDTO> getPrestacoesCadastradas() { //problema: na view, o value acessado na dataTable está sendo um DTO, que não possui (ver) getters públicos
        return this.prestacaoContaService.getAllPrestacaoConta();
    }

    public PrestacaoConta getPrestacaoSelecionada() {
        return this.prestacaoSelecionada;
    }

    public void setPrestacaoSelecionada(PrestacaoConta prestacaoSelecionada) {
        this.prestacaoSelecionada = prestacaoSelecionada;
    }

    public List<PrestacaoConta> getPrestacoesSelecionadas() {
        return this.prestacoesSelecionadas;
    }

    public void setPrestacoesSelecionadas(List<PrestacaoConta> prestacoesSelecionadas) {
        this.prestacoesSelecionadas = prestacoesSelecionadas;
    }

    public void deletePrestacoesSelecionadas() {
        this.prestacaoContaService.deletePrestacaoConta(this.prestacoesSelecionadas);
        this.prestacoesSelecionadas.clear();
        this.renderPage("Registros excluídos");
    }

    public void deletePrestacaoSelecionada() {
        this.prestacaoContaService.deletePrestacaoConta(this.prestacaoSelecionada.getId());
        this.prestacoesSelecionadas.remove(this.prestacaoSelecionada);
        this.prestacaoSelecionada = null;
        this.renderPage("Registro excluído");
    }

    public boolean cadastrarPrestacao() {
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        this.renderPage("Prestação cadastrada");
        return this.prestacaoContaService.savePrestacaoConta(new PrestacaoContaDTO(prestacaoSelecionada));
    }

    public void renderPage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
}
