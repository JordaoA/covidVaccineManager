package covidVaccineManager;

public class NaoHabilitadaParaVacina extends PessoaState {
	
	String state = "Individuo ainda não está apto para vacinação :/";
	
	public NaoHabilitadaParaVacina() {
			
	}
	@Override
	public void setState(gerenteDeVacinacao pessoa) {
		pessoa.setState(new HabilitadaParaPrimeiraDose());
	}
	
	@Override
	public String getState() {
		return this.state;
	}
}
