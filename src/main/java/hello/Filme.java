package hello;

public class Filme {
	int id;
	String titulo;
	String sinopse;
	String genero;
	String ano_lancamento;
	String produtora;
	String diretor;

	public Filme(int id, String titulo, String sinopse, String genero, String ano_lancamento, String produtora,
			String diretor) {
		this.id = id;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.genero = genero;
		this.ano_lancamento = ano_lancamento;
		this.produtora = produtora;
		this.diretor = diretor;
	}

	public Filme(String titulo, String sinopse, String genero, String ano_lancamento, String produtora,
			String diretor) {
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.genero = genero;
		this.ano_lancamento = ano_lancamento;
		this.produtora = produtora;
		this.diretor = diretor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(String ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
}