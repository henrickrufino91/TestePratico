import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Principal {

	
	public static void main(String[] args) {
		
		
		//Inserir Funcionarios
		inserirFuncionarios();
		
		
		//Imprimir lista de funcionarios
		imprimirLista(true);
		
		
		//Remover Joao	
		removerFuncionario("Joao");
		
		
		
		//Imprimir lista de funcionarios
		imprimirLista(true);
		
		
		
		//Atualizar salario em 10% de aumento
		atualizarSalario(10);
		
		
		
		//Imprimir Funcionarios por funcao
		imprimirPorFuncao();
		
		
		
		//Imprimir aniversariantes do mes 10 e 12
		aniversariantes(10, 12);
		
		
		
		//Imprimir funcionarios maior de idade
		imprimirMaiorIdade();
		
		
		
		//Imprimir funcionarios em ordem alfabetica
		imprimirOrdemAlfabetica();
		
		
		
		//Imprimir total dos salarios dos funcionarios
		totalDosSalarios();
		
		
		
		//Imprimir quantos salarios minimos ganha cada funcionario
		SalariosMinimos();
		
		
		
	}
	
	
	static List<Funcionario> funcionarios = new ArrayList<>();
	
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
    
	
	public static List<Funcionario> inserirFuncionarios() {
		
        
	   Funcionario f1 = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador");
       funcionarios.add(f1);
			
       Funcionario f2 = new Funcionario("Joao", LocalDate.of(1990, 05, 12), new BigDecimal(2284.38),"Operador");
       funcionarios.add(f2);
       
       Funcionario f3 = new Funcionario("Caio", LocalDate.of(1961, 05, 02), new BigDecimal(9836.14), "Coordenador");
       funcionarios.add(f3);
       
       Funcionario f4 = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor");
       funcionarios.add(f4);
       
       Funcionario f5 = new Funcionario("Alice", LocalDate.of(1995, 01, 05), new BigDecimal(2234.68), "Recepcionista");
       funcionarios.add(f5);
       
       Funcionario f6 = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador");
       funcionarios.add(f6);
       
       Funcionario f7 = new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal(4071.84), "Contador");
       funcionarios.add(f7);
       
       Funcionario f8 = new Funcionario("Laura", LocalDate.of(1994, 07, 8), new BigDecimal(3017.45), "Gerente");
       funcionarios.add(f8);
       
       Funcionario f9 = new Funcionario("Heloisa", LocalDate.of(2003, 05, 24), new BigDecimal(1606.85), "Eletrecista");
       funcionarios.add(f9);
			
       Funcionario f10 = new Funcionario("Helena", LocalDate.of(1996, 9, 02), new BigDecimal(2799.93), "Gerente");
       funcionarios.add(f10);
		  
        return funcionarios;
        
    }

	
	
    public static void imprimirLista(boolean visivel) {
    	
        if (visivel) {
        	
        	JOptionPane.showMessageDialog(null, "Lista de funcionários:");
            
        }

        for (Funcionario f: funcionarios) {
           
            JOptionPane.showMessageDialog(null,f.getNome() + " | " + f.formatacaoData() + " | " + f.formatacaoSalario() + " | " + f.getFuncao()); 
        }
        
    }

    
    
    public static void removerFuncionario(String nome) {
    	
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals(nome)){
                funcionarios.remove(i);
            }
        }
       
        JOptionPane.showMessageDialog(null, "\nFuncionário(a) " + nome + " removido da lista!\n" );
       
        
    }

    
    
    public static void atualizarSalario(double porcentagem) {
    	
        BigDecimal cem = new BigDecimal(100);
        BigDecimal porcentagemConvertida = new BigDecimal(porcentagem);
        BigDecimal porcentagemPorCem = porcentagemConvertida.divide(cem);

        for (Funcionario f : funcionarios) {
            BigDecimal salario = f.getSalario();
            BigDecimal valor = salario.multiply(porcentagemPorCem);
            f.setSalario(salario.add(valor));
        }

        JOptionPane.showMessageDialog(null, "\nLista de funcionarios com salário atualizado (Aumento de " + porcentagem + "%):");
        
        imprimirLista(false);
    }

    
    
    public static Map<String, List<Funcionario>> listarPorFuncao(List<Funcionario> listaDeFuncionarios) {
    	
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        
        for (Funcionario f : listaDeFuncionarios) {
        	
            List<Funcionario> funcoes = funcionariosPorFuncao.get(f.getFuncao());
            
            if (funcoes == null) {
                funcoes = new ArrayList<>();
                funcionariosPorFuncao.put(f.getFuncao(), funcoes);
            }
            
            funcoes.add(f);
        }
        return funcionariosPorFuncao;
        
    }

    
    
    public static void imprimirPorFuncao() {
    	
        Map<String, List<Funcionario>> funcionarioPorFuncao = listarPorFuncao(funcionarios);

        JOptionPane.showMessageDialog(null, "\nLista de funcionários separado por função:");
                
        for (String funcao: funcionarioPorFuncao.keySet()) {
        	
        	JOptionPane.showMessageDialog(null, funcao + ": " + funcionarioPorFuncao.get(funcao).stream().map(funcionario -> funcionario.getNome()).collect(Collectors.joining(", ")));
        	
        }
        
    }

    
    
    public static void aniversariantes(int n1, int n2) {
    	
        String nome = "";

        JOptionPane.showMessageDialog(null, "\nAniversariantes dos meses " + n1 + " e " + n2 + ":");
        
        for (int i = 0; i < funcionarios.size(); i++) {
        	
            LocalDate dataDeNascimento = funcionarios.get(i).getDataNascimento();
            int mes = dataDeNascimento.getMonthValue();

            if (mes == n1) {
            	
                nome = funcionarios.get(i).getNome();
                
                JOptionPane.showMessageDialog(null, nome + " - "+ funcionarios.get(i).formatacaoData());
              
            }

            if (mes == n2) {
            	
                nome = funcionarios.get(i).getNome();
                
                JOptionPane.showMessageDialog(null, nome + " - "+ funcionarios.get(i).formatacaoData());
            
            }
        }
    }

    
    
    public static void imprimirMaiorIdade() {
    	
        int idadeMax = 1;
        String nome = "";
        int anoAtual = Year.now().getValue();

        for (int i = 0; i < funcionarios.size(); i++) {
        	
            LocalDate dataDeNascimento = funcionarios.get(i).getDataNascimento();
            int ano = dataDeNascimento.getYear();
            int resultado = anoAtual - ano;

            if (resultado > idadeMax) {
                idadeMax = resultado;
                nome = funcionarios.get(i).getNome();
            }
        }
        
        JOptionPane.showMessageDialog(null, "\nFuncionário(a) com a maior idade é: " + nome + " com " + idadeMax + " anos.");

    }

    
    
    public static void imprimirOrdemAlfabetica() {
    	        
        JOptionPane.showMessageDialog(null, "\nLista por ordem alfabética:");
        
        Collections.sort(funcionarios, new CompararOrdemAlfabetica());
        
        for (Funcionario f: funcionarios) {
        	
        	JOptionPane.showMessageDialog(null, f.getNome() + " | " + f.formatacaoData() + " | " + f.formatacaoSalario() + " | " + f.getFuncao());
        
        }
        
    }
    
    
    public static void totalDosSalarios() {
    	
        BigDecimal soma = BigDecimal.valueOf(0);
        
        for (Funcionario f : funcionarios) {
        	
            BigDecimal salario = f.getSalario();
            soma = soma.add(salario);

        }
        
        JOptionPane.showMessageDialog(null, "\nA soma do salário dos funcionários é: " + soma);
              
    }
    
    

    public static void SalariosMinimos() {
    	
    	JOptionPane.showMessageDialog(null, "\nLista de quantos salários mínimos cada funcionário ganha:");
    	        
        for (Funcionario f: funcionarios) {
        	
            String nome = f.getNome();
            BigDecimal salario = f.getSalario();
            BigDecimal minimo = new BigDecimal(1212.00);
            BigDecimal resultado = salario.divide(minimo, 2, RoundingMode.HALF_UP);
            String valor = resultado.toString().replace(".", ",");
            
            JOptionPane.showMessageDialog(null, nome + " ganha " + valor + " salários mínimos.");

        }
    }
}
	
