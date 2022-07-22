import java.util.List;

// une os objetos. Orientado a interface. Cria uma abstração
public interface ContentExtractor {

    public List<Content> extractContent(String jsonData);
}
