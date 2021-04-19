package covidVaccineManager;

public class TomouPrimeiraDose extends PessoaState {
	
	String state =  "Individuo tomou primeira dose :)";
	
	public TomouPrimeiraDose() {}
	
	@Override
	public void setState(gerenteDeVacina pessoa) {
		//diasParaSegundaDose
		if (super.diasParaSegundaDose == 0) {
			pessoa.setState(new HabilitadaParaSegundaDose());
		}
	}
	
	@Override
	public String getState() {
		return this.state;
	}
		
}
