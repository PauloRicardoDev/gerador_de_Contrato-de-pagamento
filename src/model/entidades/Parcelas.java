package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcelas {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date vencimento;
    private Double valor;

    public Parcelas( Date vencimento, Double valor) {
        this.vencimento = vencimento;
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Parcela: " + "Vencimento " + sdf.format(vencimento) +
                ", Valor R$" + String.format("%.2f",valor);
    }
}
