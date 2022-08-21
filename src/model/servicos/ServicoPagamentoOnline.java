package model.servicos;

public interface ServicoPagamentoOnline {

    double taxaDePagamento(double valor);
    double juros(double valor, int meses);
}
