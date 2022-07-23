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

  public void cria(Conteudo conteudo, String fraseFigurinha) throws Exception {

    /*
     * InputStream Criado de um Arquivo Local
     *
     * InputStream inputStream = new FileInputStream(new
     * File("assets/img/TopMovies_1.jpg"));
     *
     */

    // InputStream Criado de um Arquivo disponível em uma URL
    InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    int largura = imagemOriginal.getWidth();
    int altura = (int) (imagemOriginal.getHeight() + (imagemOriginal.getHeight() * 0.15));

    String nomeArquivo = RandomStringUtils.randomAlphabetic(15) + ".png";
    int nota = (int) conteudo.getNota();

    if (nota > 0) {
      fraseFigurinha += " -> ";
      for (int i = 0; i < nota; i++) {
        fraseFigurinha += "🔝";
      }
    }

    BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);

    Graphics2D grafico = (Graphics2D) novaImagem.getGraphics();
    grafico.drawImage(imagemOriginal, 0, 0, null);

    int fontSize = (int) (largura * 0.05);
    int larguraFrase = (int) (largura - largura * 0.9);
    int alturaFrase = (int) (altura - altura * 0.05);

    Font fonte = new Font(Font.MONOSPACED, Font.BOLD, fontSize);
    grafico.setFont(fonte);
    grafico.drawString(fraseFigurinha, larguraFrase, alturaFrase);
    // grafico.drawString(starRating, largura - 480, (altura - 50));

    ImageIO.write(novaImagem, "png", new File("output/img/" + nomeArquivo));
  }

}
