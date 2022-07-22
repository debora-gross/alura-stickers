import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {

    public String getData(String url){

        // uma url é um uri
        URI endereco = URI.create(url);
        // aqui pode ser do tipo HttpClient ou Var
        var client = HttpClient.newHttpClient();
        // HttpRequest tem um builder que por sua vez tem GET par ajogar dentro de uma variável. Documentaçao no javadoc
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response;
        try {
            response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(body);
    }
}
