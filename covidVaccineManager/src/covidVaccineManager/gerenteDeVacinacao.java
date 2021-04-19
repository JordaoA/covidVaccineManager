package covidVaccineManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gerenteDeVacinacao{
	
	String nome;
	String cpf;
	String endereco;
	String numeroCartaoSUS;
	String email;
	String telefone;
	String profissao;
	int idade;
	int idadeApto;
	List<String> comorbidades;
	PessoaState estadoPessoa;
	boolean aptoComorbidade;
	boolean aptoProfissao;
	boolean aptoIdade;
	boolean aptoDiasSegundaVacina;
	
	
	public gerenteDeVacinacao(String nome, String cpf, String endereco, String numeroCartaoSUS, String email,
			String telefone, String profissao, int idade, List<String> comorbidades) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numeroCartaoSUS = numeroCartaoSUS;
		this.email = email;
		this.telefone = telefone;
		this.profissao = profissao;
		this.idade = idade;
		this.comorbidades = comorbidades;
		this.estadoPessoa = new NaoHabilitadaParaVacina();
		this.aptoComorbidade = false;
		this.aptoProfissao = false;
		this.aptoIdade = false;
		this.aptoDiasSegundaVacina = false;
		this.idadeApto = 60;
	}

	public String getSituacao() {
		return this.estadoPessoa.getState();
	}	
	
	public void nextState() {
		
		this.aptoComorbidade = this.checaPorComorbidades();
		this.aptoProfissao = this.checaPorProfissao();
		this.aptoIdade = (this.idade >= this.idadeApto);
		this.aptoDiasSegundaVacina = (estadoPessoa.getDiasSegundaDose() == 0);
		
		if(this.estadoPessoa.getState().equals("Individuo ainda não está apto para vacinação :/")) {
			if(this.aptoComorbidade || this.aptoProfissao || this.aptoIdade){
				this.estadoPessoa.setState(this);
				this.aptoComorbidade = false;
				this.aptoProfissao = false;
				}
		}else if(this.estadoPessoa.getState().equals("Individuo tomou primeira dose :)")){
			if(this.aptoDiasSegundaVacina) {
				this.estadoPessoa.setState(this);
			}
		}else {
			this.estadoPessoa.setState(this);
		}
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumeroCartaoSUS() {
		return numeroCartaoSUS;
	}

	public void setNumeroCartaoSUS(String numeroCartaoSUS) {
		this.numeroCartaoSUS = numeroCartaoSUS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public void setState(PessoaState estadoPessoa) {
		this.estadoPessoa = estadoPessoa;
	}
	
	public void setDiasSegundaVacina(int dias) {
		this.estadoPessoa.setDiasSegundaDose(dias);
	}
	
	public void setIdadeApto(int idadeApto) {
		this.idadeApto = idadeApto;
	}
	
	public void addComorbidades(String Comorbidade) {
		this.comorbidades.add(Comorbidade);
	}
	
	private boolean checaPorComorbidades(){
		boolean apto = false;
		List<String> comorbidadesAceitas = new ArrayList<String>( Arrays.asList("diabetes", "pneumopatia", "hipertensão", "doenças cardiovasculares", "imunossuprimidos", "anemia", "obesidade", "cirrose"));//exemplos de problemas que podem se enquadrar como grupo de risco

		for (int comorbidade = 0; comorbidade < this.comorbidades.size(); comorbidade++) {
			for (int comorbidadeApta = 0; comorbidadeApta < comorbidadesAceitas.size(); comorbidadeApta++) {
				if(comorbidadesAceitas.get(comorbidadeApta).equals(comorbidades.get(comorbidade))) {
					apto = true;
					break;
				}
			}
		}		
		return apto;
	}
	
	private boolean checaPorProfissao(){
		boolean apto = false;
		List<String> profissoesAceitas = new ArrayList<String>(Arrays.asList("saude", "ensino"));//exemplos de areas trabalhistas que teriam preferencia para vacinação.
		for (int profissao = 0; profissao < profissoesAceitas.size(); profissao++) {
			if(profissoesAceitas.get(profissao).equals(this.profissao)) {
				apto = true;
				break;
			}	
		}	
		return apto;
	}
}
