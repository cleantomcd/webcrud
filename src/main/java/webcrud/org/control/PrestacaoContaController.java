package webcrud.org.control;

import org.primefaces.PrimeFaces;
import webcrud.org.model.entity.Categoria;
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

    private List<PrestacaoConta> prestacoesCadastradas;

    private boolean editing;

    public PrestacaoContaController() {

    }

    @PostConstruct
    public void init() {
        this.prestacoesSelecionadas = new ArrayList<>();
        if (prestacaoSelecionada == null) {
            prestacaoSelecionada = new PrestacaoConta();
        }
    }

    public void criarPrestacao() {
        this.editing = false;
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

    public boolean isEditing() {
        return this.editing;
    }

    public void setEditing() {
        this.editing = true;
    }

    public Categoria[] getCategorias() {
        return Categoria.values();
    }

    public String formatData(LocalDate data) {
        if (data != null) {
            return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return "";
    }

    public String formatData() {
        if (prestacaoSelecionada != null) {
            return this.formatData(prestacaoSelecionada.getData());
        }
        return "";
    }

    public void loadPrestacoes() {
        prestacoesCadastradas = prestacaoContaService.getAllPrestacaoConta();
    }

    public List<PrestacaoConta> getPrestacoesCadastradas() {
        return prestacoesCadastradas;
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

    public boolean savePrestacao() {
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        boolean retorno;
        if (this.editing){
            retorno = this.prestacaoContaService.updatePrestacaoConta(new PrestacaoContaDTO(prestacaoSelecionada));
            this.renderPage("Prestação atualizada");
        } else {
            retorno = this.prestacaoContaService.savePrestacaoConta(new PrestacaoContaDTO(prestacaoSelecionada));
            this.renderPage("Prestação cadastrada");
        }
        this.editing = false;
        return retorno;
    }

    public void renderPage(String message) {
        this.loadPrestacoes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
}
