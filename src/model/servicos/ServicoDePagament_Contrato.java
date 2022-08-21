package model.servicos;

import model.entidades.Contrato;
import model.entidades.Parcelas;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

public class ServicoDePagament_Contrato {

    private ServicoPagamentoOnline servicoPagamentoOnline;

    public ServicoDePagament_Contrato(ServicoPagamentoOnline servicoPagamentoOnline) {
        this.servicoPagamentoOnline = servicoPagamentoOnline;
    }

    public void processoContrato(Contrato contrato, int meses) {
        double cotaBasica = contrato.getValorTotal() / meses;
        for (int i = 1; i <= meses; i++) {
            Date date = addMeses(contrato.getDataDeInicio(), i);
            double atualizandoCota = cotaBasica + servicoPagamentoOnline.juros(cotaBasica, i);
            double cotaTotal =  atualizandoCota + servicoPagamentoOnline.taxaDePagamento(atualizandoCota);
            contrato.addListaParcela(new Parcelas(date, cotaTotal));
        }
    }

    private Date addMeses(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
}
