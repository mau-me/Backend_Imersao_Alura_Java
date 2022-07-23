import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoImdb implements ExtratorConteudo {

  @Override
  public List<Conteudo> extraiConteudo(String json) {

    var jsonParser = new JsonParser();

    List<Map<String, String>> listaAtributos = jsonParser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();

    for (Map<String, String> atributos : listaAtributos) {
      var titulo = atributos.get("title");
      var urlImage = atributos.get("image");
      float nota = (float) Float.parseFloat(atributos.get("imDbRating"));

      var conteudo = new Conteudo(titulo, urlImage, nota);
      conteudos.add(conteudo);
    }

    return conteudos;
  }

}
