package imersaoJava;

public enum API {
	NASA_APOD("https://api.nasa.gov/planetary/apod?api_key=rD2p55hAXOWjcsupmsJAjHtr7cfY57yeD8AgWppQ&start_date=2022-06-12&end_date=2022-06-30" , new ExtratorConteudoNasa()),
	ALURA_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json" , new ExtratorConteudoImdb());

	private String url;
	private ExtratorConteudo extrator;
	
	API (String url, ExtratorConteudo extrator){
		this.url = url;	
		this.extrator = extrator;
	}
	
	public String getUrl() {
		return url;
	}
	
	public ExtratorConteudo getExtrator() {
		return extrator;
	}
}
