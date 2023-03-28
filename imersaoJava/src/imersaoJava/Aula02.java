package imersaoJava;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Aula02 {
    
    public void gerandoFigurinhas() throws Exception {

        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/PulpFiction.jpg"));

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.BLACK);
        graphics.setFont(fonte);

        graphics.drawString("O melhor filme!", 100, novaAltura - 100);

        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));

    }
    
    
    public static void main(String[] args) throws Exception {
		var geradora = new Aula02();
		geradora.gerandoFigurinhas();
		
	}

}
