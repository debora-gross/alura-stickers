import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// para importar tudo: Alt + Shift + o

public class IMDBContentExtractor implements ContentExtractor {

    public List<Content> extractContent(String jsonData){
        // *extrair somente os dados que interessam(titulo, poster, classificação) utilizando expressoes regulares

        var parser = new JsonParser();
        List<Map<String, String>> listOfAttributes = parser.parse(jsonData);
        //System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));
        List<Content> listContents = new ArrayList<>();

        //popular a lista de itens/conteudos
        for (Map<String, String> attributes : listOfAttributes) {
            String title = attributes.get("title");
            String urlImage = attributes.get("image").replaceAll("(.+://.+@)..+(.jpg)", "$1$2");;
            Content content = new Content(title, urlImage);

            listContents.add(content);
        }

        return listContents;
    }
}

