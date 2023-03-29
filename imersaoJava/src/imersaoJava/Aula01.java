 package imersaoJava;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Aula01 {

    public static void main(String[] args) throws Exception {

        API api = API.ALURA_TOP_MOVIES;
        String url = api.getUrl();        
        var http = new ClientHttp();
        String json = http.buscaDados(url);
        ExtratorConteudo extrator = api.getExtrator();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        String textoFigurinha = "Aprovado!";
    	var diretorio = new File("stickers/");
        diretorio.mkdir();
        var geradora = new Aula02(); 
        
        for (int i = 0; i < 10 ; i++) {
        	
        	Conteudo conteudo = conteudos.get(i);

        	InputStream inputStreamm = new URL(conteudo.urlDaImagem()).openStream();
            String nomeArquivo = diretorio + conteudo.titulo() +".png";

            geradora.cria(inputStreamm, nomeArquivo, textoFigurinha);

            System.out.println(conteudo.titulo());
            System.out.println();

       }

    }
}
