package e2e;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static e2e.HtmlUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ferenc_S on 12/18/2016.
 */

/*
 * These tests are only to be run alongside the server when it's running. Hence the @Ignore
 */

@Ignore
public class AuthUserTest {
    static WebClient webClient;

    @BeforeClass
    public static void setUpClass() throws Exception {
        webClient = new WebClient();
    }

    @Test
    public void loginTest() throws Exception {
        final HtmlPage loginPage = webClient.getPage(LOCALHOST_8080_LOGIN);
        webClient.getCookieManager().setCookiesEnabled(true);

        final HtmlForm form = loginPage.getForms().get(0);
        final HtmlTextInput username = form.getInputByName("username");
        final HtmlPasswordInput pwd = form.getInputByName("password");
        final HtmlSubmitInput button = form.getInputByValue("Log in");

        username.setValueAttribute("FigaPl");
        pwd.setValueAttribute("test1234");

        button.click();

        final HtmlPage welcomePage = getCurPage(webClient);
        assertTrue(welcomePage.asText().contains("Welcome back FigaPl"));
    }

    @Test
    public void loginFailTest() throws Exception {
        final HtmlPage loginPage = webClient.getPage(LOCALHOST_8080_LOGIN);
        webClient.getCookieManager().setCookiesEnabled(true);

        final HtmlForm form = loginPage.getForms().get(0);
        final HtmlTextInput username = form.getInputByName("username");
        final HtmlPasswordInput pwd = form.getInputByName("password");
        final HtmlSubmitInput button = form.getInputByValue("Log in");

        username.setValueAttribute("FigaPl");
        pwd.setValueAttribute("WRONGPASSWORD");

        button.click();

        final HtmlPage welcomePage = getCurPage(webClient);
        assertTrue(welcomePage.asText().contains("Invalid"));
    }
}