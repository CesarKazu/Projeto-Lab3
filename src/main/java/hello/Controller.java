package hello;

import static spark.Spark.get;
import java.util.List;
import com.google.gson.Gson;

public class Controller {

	private Model model;


	public Controller(Model model){
		this.model = model;
	}

	public void cadastrar_filme(){
		get("/cadastrar_filme/:titulo/:sinopse/:genero/:ano_lancamento/:produtora/:diretor", (req, res) -> {
			Filme filme = new Filme(req.params(":titulo"), req.params(":sinopse"), req.params(":genero"), req.params(":ano_lancamento"), req.params(":produtora"), req.params(":diretor"));
			boolean bool = model.cadastrar_filme(filme);
			return new Gson().toJson(bool);
		});
	}

	public void listar_filme(){
		get("/listar_filme", (req, res) -> {
			List<Filme> listarcarros  = model.listar_filme();	
			return new Gson().toJson(listarcarros);
		});
	}

	public void alterar_filme() {
		get("/alterar_filme/:id/:titulo/:sinopse/:genero/:ano_lancamento/:produtora/:diretor", (req, res) -> {
			boolean bool = model.alterar_filme(new Filme(Integer.parseInt(req.params(":id")), req.params(":titulo"), req.params(":sinopse"), req.params(":genero"), req.params(":ano_lancamento"), req.params(":produtora"), req.params(":diretor")));
			return new Gson().toJson(bool);
		});
	}

	public void deletar_filme() {
		get("/deletar_filme/:id", (req, res) -> {
			boolean bool = model.deletar_filme(Integer.parseInt(req.params(":id")));
			return new Gson().toJson(bool);
		});
	}
}