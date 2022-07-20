import org.apache.commons.lang.RandomStringUtils;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
// import java.io.FileInputStreasm;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

  public void cria(String url, String fraseFigurinha) throws Exception {

    /*
     * InputStream Criado de um Arquivo Local
     *
     * InputStream inputStream = new FileInputStream(new
     * File("assets/img/TopMovies_1.jpg"));
     *
     */

    // InputStream Criado de um Arquivo disponível em uma URL
    InputStream inputStream = new URL(url).openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    int largura = imagemOriginal.getWidth();
    int altura = (imagemOriginal.getHeight() + 200);
    String nomeArquivo = RandomStringUtils.randomAlphabetic(15) + ".png";

    BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);

    Graphics2D grafico = (Graphics2D) novaImagem.getGraphics();
    grafico.drawImage(imagemOriginal, 0, 0, null);

    Font fonte = new Font(Font.MONOSPACED, Font.BOLD, 52);
    grafico.setFont(fonte);
    grafico.drawString(fraseFigurinha, largura - 480, (altura - 100));

    ImageIO.write(novaImagem, "png", new File("output/img/" + nomeArquivo));
  }

  // public static void main(String[] args) throws Exception {
  // var Gerador = new GeradoraDeFigurinhas();

  // Gerador.cria("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg");
  // }
}
