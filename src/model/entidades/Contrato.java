package model.entidades;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {

    private String numeroIdentificacao;
    private Date dataDeInicio;
    private Double valorTotal;

    List<Parcelas> parcelas = new ArrayList<>();

    public Contrato(String numeroIdentificacao, Date dataDeInicio, Double valorTotal) {
        this.numeroIdentificacao = numeroIdentificacao;
        this.dataDeInicio = dataDeInicio;
        this.valorTotal = valorTotal;
    }

    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    public void setNumeroIdentificacao(String numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public Date getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(Date dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Parcelas> getParcelas() {
        return parcelas;
    }

    public void addListaParcela(Parcelas parcela){
        parcelas.add(parcela);
    }
    public void removeParcelaLista(Parcelas parcela){
        parcelas.remove(parcela);
    }
}
