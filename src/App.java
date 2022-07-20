import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
  public static void main(String[] args) throws Exception {

    String url = "https://api.mocki.io/v2/549a5d8b";
    // String url = "https://alura-filmes.herokuapp.com/conteudos";
    var fraseFigurinha = "";
    var endereco = URI.create(url);
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(endereco).GET().build();

    GeradoraDeFigurinhas geradoraDeFigurinhas = new GeradoraDeFigurinhas();

    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

    var jsonParser = new JsonParser();
    List<Map<String, String>> filmes = jsonParser.parse(response.body());

    // System.out.println(filmes.size());
    // System.out.println(filmes.get(0).get("title"));
    for (Map<String, String> filme : filmes) {
      int notaFilme = (int) Double.parseDouble(filme.get("imDbRating"));

      fraseFigurinha = notaFilme >= 7 ? "TOPZEIRA" : "BAGACEIRA";
      geradoraDeFigurinhas.cria(filme.get("image"), fraseFigurinha);
    }
  }
}
