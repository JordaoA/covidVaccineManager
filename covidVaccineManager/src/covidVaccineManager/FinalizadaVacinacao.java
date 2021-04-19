package covidVaccineManager;

public class FinalizadaVacinacao extends PessoaState {
	
	String state =  "Individuo devidamente VACINADO :D";
	
	public FinalizadaVacinacao() {}
	
	@Override
	public void setState(gerenteDeVacinacao pessoa) {
		pessoa.setState(new FinalizadaVacinacao());
	}
	
	@Override
	public String getState() {
		return this.state;
	}
	
}
