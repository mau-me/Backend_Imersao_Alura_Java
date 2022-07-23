import java.util.List;

public class App {
  public static void main(String[] args) throws Exception {

    String url = "https://api.mocki.io/v2/549a5d8b";
    // String url = "https://alura-filmes.herokuapp.com/conteudos";
    var fraseFigurinha = "";

    GeradoraDeFigurinhas geradoraDeFigurinhas = new GeradoraDeFigurinhas();

    var http = new ClienteHttp();
    var json = http.buscaDados(url);

    ExtratorConteudo extrator = new ExtratorConteudoImdb();
    List<Conteudo> conteudos = extrator.extraiConteudo(json);

    fraseFigurinha = "TOPZEIRA";

    for (int i = 0; i < 3; i++) {
      Conteudo conteudo = conteudos.get(i);
      System.out.println(conteudo.getTitulo() + "" + conteudo.getNota());

      geradoraDeFigurinhas.cria(conteudo.getUrlImagem(), fraseFigurinha);
    }

    // System.out.println(filmes.size());
    // System.out.println(filmes.get(0).get("title"));
    // int notaFilme = (int) Double.parseDouble(filme.get("imDbRating"));

    // fraseFigurinha = notaFilme >= 7 ? "TOPZEIRA" : "BAGACEIRA";
    // fraseFigurinha = "TOPZEIRA";
    // geradoraDeFigurinhas.cria(filme.get("image"), fraseFigurinha);
  }
}
