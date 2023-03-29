import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // IMDB
        // String url
        // ="https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        // NASA
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClientHttp();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var diretorio = new File("saida/");
        diretorio.mkdir();

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + " .png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }

    }
}