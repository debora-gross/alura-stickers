public class Content {

    private String title;
    private String urlImage;

    public Content(String title, String urlImage) {
        this.title = title;
        this.urlImage = urlImage;
    }
    // não necessita setter porque não vou mudar nada, só buscar
    public String getTitle() {
        return title;
    }
    public String getUrlImage() {
        return urlImage;
    }


}
