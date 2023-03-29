package imersaoJava;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo {
	
	public List<Conteudo> extraiConteudos(String json){
		
		// extrair só os dados que interessam 
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        return listaDeAtributos.stream()
        		.map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
        		.toList();        
        
	}

} 
