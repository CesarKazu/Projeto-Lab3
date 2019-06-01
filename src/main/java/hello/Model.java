package hello;

import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;

public class Model {

	ObjectContainer filmes = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/filmes.db4o");

	//private List<Filme> filmes = new LinkedList<Filme>();
	private int cont_id = 0;

	public boolean cadastrar_filme(Filme filme){
		filme.setId(generate_id());
		filmes.store(filme);
		filmes.commit();
		return true;
	}

	public List<Filme> listar_filme(){
		Query query = filmes.query();
		query.constrain(Filme.class);
		List<Filme> lista = query.execute();
		return lista;
	}

	public boolean alterar_filme(Filme filme_novo) {
		Query query = filmes.query();
		query.constrain(Filme.class);
		List<Filme> lista = query.execute();
		for(Filme filme:lista) {
			if(filme.getId()==filme_novo.getId()) {
				filme.setTitulo(filme_novo.getTitulo());
				filme.setSinopse(filme_novo.getSinopse());
				filme.setGenero(filme_novo.getGenero());
				filme.setAno_lancamento(filme_novo.getAno_lancamento());
				filme.setProdutora(filme_novo.getProdutora());
				filme.setDiretor(filme_novo.getDiretor());
				filmes.store(filme);
				filmes.commit();
				return true;
			}
		}
		return false;
	}

	public boolean deletar_filme(int id) {
		Query query = filmes.query();
		query.constrain(Filme.class);
		List<Filme> lista = query.execute();
		for(Filme filme:lista) {
			if(filme.getId()==id) {
				filmes.delete(filme);
				filmes.commit();
				return true;
			}
		}
		return false;
	}

	public int generate_id() {
		cont_id++;
		return cont_id;
	}
}