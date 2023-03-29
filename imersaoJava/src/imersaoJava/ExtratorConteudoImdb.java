package imersaoJava;

import java.util.List;
import java.util.Map;

public class ExtratorConteudoImdb implements ExtratorConteudo {

	public List<Conteudo> extraiConteudos(String json) {

		// extrair só os dados que interessam (titulo, poster, classificação)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);

		// popular a lista de conteudos
		return listaDeAtributos.stream().map(atributos -> new Conteudo(atributos.get("title"),
				atributos.get("image").replaceAll("(@?\\.)([0-9A-Z,]+).jpg", "$1.jpg"))).toList();

	}

}
