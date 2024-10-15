package projetoImposto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ImpostoRenda {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.print("Renda anual com salário: ");
			double rendaSalario = input.nextDouble();
			
			System.out.print("Renda anual com prestação de serviço: ");
			double rendaServico = input.nextDouble();
			
			System.out.print("Renda anual com ganho de capital: ");
			double ganhoCapital = input.nextDouble();
			
			System.out.print("Gastos médicos: ");
			double gastosMedicos = input.nextDouble();
			
			System.out.print("Gastos educacionais: ");
			double gastosEducacionais = input.nextDouble();
			
			
			double salarioMensal = rendaSalario / 12;
			double impostoSalario = 0.0;
			
			if (salarioMensal < 3000) {
				impostoSalario = 0.0;
			} else if (salarioMensal < 5000) {
				impostoSalario = rendaSalario * 0.10;
			} else {
				impostoSalario = rendaSalario * 0.20;
			}
			
			double impostoServico = rendaServico * 0.15;
			
			double impostoGanhoCapital = ganhoCapital * 0.20;
			
			double impostoBruto = impostoSalario + impostoServico + impostoGanhoCapital;
			
			double maxDedutivel = impostoBruto * 0.30;
			
			double gastosDedutiveis = gastosMedicos + gastosEducacionais;
			
			double abatimento = Math.min(gastosDedutiveis, maxDedutivel);
			
			double impostoDevido = impostoBruto - abatimento;
			
			System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
			System.out.println("* CONSOLIDADO DE RENDA:");
			System.out.printf("Imposto sobre salário: %.2f\n", impostoSalario);
			System.out.printf("Imposto sobre serviços: %.2f\n", impostoServico);
			System.out.printf("Imposto sobre o ganho de capital: %.2f\n", impostoGanhoCapital);
			
			System.out.println("\n* DEDUÇÕES:");
			System.out.printf("Máximo dedutível: %.2f\n", maxDedutivel);
			System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutiveis);
			
			System.out.println("\n* RESUMO:");
			System.out.printf("Imposto bruto total: %.2f\n", impostoBruto);
			System.out.printf("Abatimento: %.2f\n", abatimento);
			System.out.printf("Imposto devido: %.2f\n", impostoDevido);
			
		} catch (InputMismatchException e) {
			System.out.println("Erro: Você deve inserir números válidos usando ponto (.) como separador decimal.");
		} finally {
			input.close();
		}
	}
}
