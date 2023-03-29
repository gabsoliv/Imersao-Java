 package imersaoJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Aula01 {

    public static void main(String[] args) throws Exception {
    	
    	
    	// fazer uma conexão HTTP e buscar os top 250 filmes   	
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        
        
        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
        	
        	var diretorio = new File("stickers/");
            diretorio.mkdir();
      
        	String urlImagem = filme.get("image");
        	String urlImagemMaior = urlImagem.replaceFirst("(@?\\.)([0-9A-Z,]+).jpg", "$1.jpg");
            String titulo = filme.get("title");
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            
            String textoFigurinha;
            InputStream imagemGabs;
            if (classificacao >= 9.0 ) {
            	textoFigurinha = "Aprovado!";
            	imagemGabs = new FileInputStream(new File("sobreposicao/sorrindo.PNG"));
            	
            } else {
            	textoFigurinha = "HMMMMMM...";
            	imagemGabs = new FileInputStream(new File("sobreposicao/pensando.PNG"));
            }

            InputStream inputStreamm = new URL(urlImagemMaior).openStream();
            String nomeArquivo = diretorio + titulo +".png";

            var geradora = new Aula02();
            geradora.cria(inputStreamm, nomeArquivo, textoFigurinha, imagemGabs);

            System.out.println(titulo);
            System.out.println();

        	}   
        
    }
}
