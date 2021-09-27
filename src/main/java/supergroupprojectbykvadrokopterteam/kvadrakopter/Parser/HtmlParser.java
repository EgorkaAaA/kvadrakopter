package supergroupprojectbykvadrokopterteam.kvadrakopter.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class HtmlParser {
    private Document getPage(String url) throws IOException {
        return Jsoup.parse(new URL(url), 3000);
    }
}
