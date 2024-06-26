import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Pessoa {
	
    private String nome;
    
    private LocalDate dataNascimento;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
    
    public Pessoa() {
    	
    }
        
    
    public Pessoa(String nome, LocalDate dataNascimento) {
    	
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        
    }
    

    public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String formatacaoData() {
        return dtf.format(getDataNascimento());
    }


	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
	}
	
	
	
}