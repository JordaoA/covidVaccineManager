package covidVaccineManager;

public abstract class PessoaState {
	String state = "Individuo ainda não está apto para vacinação :/";
	int diasParaSegundaDose = 20;
	
	public void setState(gerenteDeVacinacao pessoa){};
	
	public String getState() {
		return this.state;
	}
	
	public void setDiasSegundaDose(int diasParaSegundaDose) {
		this.diasParaSegundaDose = diasParaSegundaDose;
	}
	
	public int getDiasSegundaDose() {
		return this.diasParaSegundaDose;
	}
}
