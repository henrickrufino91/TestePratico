import java.util.Comparator;



public class CompararOrdemAlfabetica implements Comparator<Funcionario> {

	
	
    @Override
    public int compare(Funcionario f1, Funcionario f2) {
    	
    	
        if(f1.getNome().compareTo(f2.getNome()) > 0) {
        	
            return 1;
        }
        
        return -1;
        
    }
    
    
    
}