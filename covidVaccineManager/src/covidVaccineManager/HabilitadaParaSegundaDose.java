package covidVaccineManager;

public class HabilitadaParaSegundaDose extends PessoaState {
	
	String state =  "Individuo apto para segunda dose :)";

	public HabilitadaParaSegundaDose() {}
	
	@Override
	public void setState(gerenteDeVacinacao pessoa) {
		pessoa.setState(new FinalizadaVacinacao());
	}
	
	@Override
	public String getState() {
		return this.state;
	}
	
}
