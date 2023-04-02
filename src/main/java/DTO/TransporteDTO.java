package DTO;

public class TransporteDTO {

	private Long numeroviagens;
	private String matricula;
	public Long getNumeroviagens() {
		return numeroviagens;
	}
	public void setNumeroviagens(Long numeroviagens) {
		this.numeroviagens = numeroviagens;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public TransporteDTO(Long numeroviagens, String matricula) {
		super();
		this.numeroviagens = numeroviagens;
		this.matricula = matricula;
	}
public TransporteDTO() {}
	 
}
