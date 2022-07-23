import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo {

  @Override
  public List<Conteudo> extraiConteudo(String json) {

    var jsonParser = new JsonParser();

    List<Map<String, String>> listaAtributos = jsonParser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();

    for (Map<String, String> atributos : listaAtributos) {
      var conteudo = new Conteudo(atributos.get("title"), atributos.get("url"));
      conteudos.add(conteudo);
    }

    return conteudos;
  }

}
