package allura.estudo.cep.interactive;

public record Cep(String cep, String logradouro, String complemento, String bairro, String localidade,
				String uf, String ibge, String gia, int ddd, int siafi) {

	@Override
	public String toString() {
		return "Cep [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", localidade=" + localidade + ", uf=" + uf + ", ibge=" + ibge + ", gia=" + gia + ", ddd=" + ddd
				+ ", siafi=" + siafi + "]";
	}
}
