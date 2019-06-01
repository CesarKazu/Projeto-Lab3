package hello;

import static spark.Spark.*;


public class MainServer {

	final static Model model = new Model();

	public static void main(String[] args) {
		// Get port config of heroku on environment variable
		ProcessBuilder process = new ProcessBuilder();
		Integer port;
		if (process.environment().get("PORT") != null) {
			port = Integer.parseInt(process.environment().get("PORT"));
		} else {
			port = 8081;
		}
		port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializar();

		Controller controller = new Controller(model);
		controller.cadastrar_filme();
		controller.listar_filme();
		controller.alterar_filme();
		controller.deletar_filme();

		//SparkJavaFileUploadSample s = new SparkJavaFileUploadSample();
		//s.teste();
	}

	public static void inicializar(){
	}
}
