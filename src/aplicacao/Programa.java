package aplicacao;

import model.entidades.Contrato;
import model.entidades.Parcelas;
import model.servicos.ServicoDePagament_Contrato;
import model.servicos.ServicoPaypal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Informe os dados abaixo");
            System.out.print("Numero Indentificação do contrato: ");
            var numero = sc.next();
            System.out.print("Data (dd/MM/yyyy): ");
            Date data = sdf.parse(sc.next());
            System.out.print("Valor do contrato: ");
            double valorTotal = sc.nextDouble();

            Contrato contrato = new Contrato(numero, data, valorTotal);

            System.out.print("Informe o numero de parcelas: ");
            int n = sc.nextInt();
            ServicoDePagament_Contrato servicoDePagamentContrato = new ServicoDePagament_Contrato(new ServicoPaypal());
            servicoDePagamentContrato.processoContrato(contrato, n);

            System.out.println("Parcelas:");
            for (Parcelas x : contrato.getParcelas()) {
                System.out.println(x);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}
