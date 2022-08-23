package br.atividade.testes;

	public class Filmes {
	    public String[][] nomes;
	    public String[] faixaEtaria;
	    
	    
	    public String[][] getNomes() {
	        return nomes;
	    }
	    public void setNomes(String[][] nome) {
	        this.nomes = nome;
	    }
	    public String[] getFaixaEtaria() {
	        return faixaEtaria;
	    }
	    public void setFaixaEtaria(String[] faixaEtaria) {
	        this.faixaEtaria = faixaEtaria; 
	    }
	    
	   public void imprimirFilmesEmCartaz(String[] filmesEmCartaz) {
	    	for (int i = 0; i < filmesEmCartaz.length; i++) {
				System.out.println((i + 1 + " - " + filmesEmCartaz[i].toString()));
			}
	    }
	    
	}

