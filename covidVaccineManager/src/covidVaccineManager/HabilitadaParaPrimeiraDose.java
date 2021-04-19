package covidVaccineManager;

public class HabilitadaParaPrimeiraDose extends PessoaState {
	
	String state =  "Individuo apto para primeira dose :)";
	
	public HabilitadaParaPrimeiraDose() {
	}
	@Override
	public void setState(gerenteDeVacina pessoa) {
		pessoa.setState(new TomouPrimeiraDose());
	}
	
	@Override
	public String getState() {
		return this.state;
	}
		
}
