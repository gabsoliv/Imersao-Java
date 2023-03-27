package imersaoJava;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Aula01 {

    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
  
        for (Map<String,String> filme : listaDeFilmes) {
        	double toRank = Double.parseDouble(filme.get("imDbRating"));
            int amountOfStars = (int) toRank;
            for (int i = 1; i <= amountOfStars ; i++) {           	
                System.out.print("⭐");
                          	
            }
         
            System.out.println("\n\u001b[1mMovie Title: \u001b[m" + filme.get("title"));
            System.out.println("\u001b[1mURL da Imagem: \u001b[m" + filme.get("image"));
            System.out.println("\u001b[37m\u001b[40mRating:" + filme.get("imDbRating") + "\u001b[m");
            
            
            System.out.println("\n");
            
        }
    }
}
