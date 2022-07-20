import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // *fazer uma conexão HTTP e buscar os top 250 filmes

        String url = "https://imdb-api.com/en/API/Top250Movies/k_9qd0fycp";
        // uma url é um uri
        URI endereco = URI.create(url);
        // aqui pode ser do tipo HttpClient ou Var
        var client = HttpClient.newHttpClient();
        // HttpRequest tem um builder que por sua vez tem GET par ajogar dentro de uma variável. Documentaçao no javadoc
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response= client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);

        // *extrair somente os dados que interessam(titulo, poster, classificação) utilizando expressoes regulares

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        //System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));


        // *exibir e manipular os dados
        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
        int count = 0;
        for (Map<String,String> filme : listaDeFilmes)
        {
            if(count < 5){
                String urlImagem = filme.get("image");
                //urlImagem.replaceAll("@(\\..+)\\.", "@.");
                urlImagem = urlImagem.replaceAll("(.+://.+@)..+(.jpg)", "$1$2");
                System.out.println(urlImagem);
                String titulo = filme.get("title");

                InputStream inputStream = new URL(urlImagem).openStream();
                String nomeArquivo = titulo + ".png";

                geradora.cria(inputStream, nomeArquivo);

                System.out.println(titulo);
                System.out.println();
            }
            count ++;
        }
    }
}
