package e2e;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Created by Ferenc_S on 12/18/2016.
 */
public class HtmlUtil {
    static final String LOCALHOST_8080_LOGIN = "http://localhost:8080/login";
    static final String LOCALHOST_8080_REGISTER = "http://localhost:8080/register";

    static HtmlPage getCurPage(WebClient webClient) {
        return (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();
    }
}
