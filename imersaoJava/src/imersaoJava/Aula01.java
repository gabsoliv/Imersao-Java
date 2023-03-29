 package imersaoJava;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Aula01 {

    public static void main(String[] args) throws Exception {
    	
    	
    	// exibir e manipular os dados 
        String textoFigurinha = "Aprovado!";
    	var diretorio = new File("stickers/");
        diretorio.mkdir();
        
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        var http = new ClientHttp();
        String json = http.buscaDados(url);
        ExtratorConteudo extrator = new ExtratorConteudoImdb();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        
        /*
        String url = "https://api.nasa.gov/planetary/apod?api_key=rD2p55hAXOWjcsupmsJAjHtr7cfY57yeD8AgWppQ&start_date=2022-06-12&end_date=2022-06-30";        
        var http = new ClientHttp();
        String json = http.buscaDados(url);
        ExtratorConteudo extrator = new ExtratorConteudoNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        */
        
        var geradora = new Aula02();
        
        for (int i = 0; i < 10 ; i++) {
        	
        	Conteudo conteudo = conteudos.get(i);

        	InputStream inputStreamm = new URL(conteudo.getUrlDaImagem()).openStream();
            String nomeArquivo = diretorio + conteudo.getTitulo() +".png";

            geradora.cria(inputStreamm, nomeArquivo, textoFigurinha);

            System.out.println(conteudo.getTitulo());
            System.out.println();

       }

    }
}
