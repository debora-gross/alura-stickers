import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // *fazer uma conexão HTTP e buscar os top 250 filmes

        String url = "https://imdb-api.com/en/API/Top250Movies/k_9qd0fycp";
        ContentExtractor extractor = new IMDBContentExtractor();

        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-07-07&end_date=2022-07-09";
        //ContentExtractor extractor = new NasaContentExtractor();

        ClientHttp clientHttp = new ClientHttp();
        String jsonData = clientHttp.getData(url);

        // *exibir e manipular os dados

        List<Content> listContents = extractor.extractContent(jsonData);

        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
        //int count = 0;
        for (int i = 0; i < 3; i++)
        {
            Content content = listContents.get(i);

            // input stream trabalha com abstração
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String nomeArquivo = content.getTitle() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}

