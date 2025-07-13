package webcrud.org.model.entity;

public enum Categoria {
    PRESTACAO_CONTAS_ANUAL("Prestação de Contas Anual"),
    PRESTACAO_CONTAS_GESTAO("Prestação de Contas de Gestão"),
    PRESTACAO_CONTAS_TRANSFERENCIAS("Prestação de Contas de Transferências Voluntárias"),
    PRESTACAO_CONTAS_PROJETOS("Prestação de Contas de Projetos"),
    PRESTACAO_CONTAS_COLABORADORES("Prestação de Contas de Colaboradores"),
    PRESTACAO_CONTAS_PARTIDOS("Prestação de Contas de Partidos Políticos");

    private final String label;

    Categoria(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
