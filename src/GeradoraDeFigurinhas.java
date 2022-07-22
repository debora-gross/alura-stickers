import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {


    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        // leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.png"));
        /*InputStream inputStream = new URL("https://imdb-api.com/images/original/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_Ratio0.6716_AL_.jpg").openStream();*/
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar nova imagem em memoria com transparencia e com novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para a nova imagem(em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.BLUE);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 110, novaAltura - 100);

        //escrever a nova imagem em um arquivo
        //File f = new File("saida/figurinha.png");
        /*File f = new File(nomeArquivo);

        if(!f.exists())
        {
            f.mkdir();
        }*/

        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }
}
