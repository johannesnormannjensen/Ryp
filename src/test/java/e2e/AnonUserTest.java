package e2e;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static e2e.HtmlUtil.LOCALHOST_8080_LOGIN;
import static org.junit.Assert.*;

/**
 * Created by Ferenc_S on 12/18/2016.
 */

/*
 * These tests are only to be run alongside the server when it's running. Hence the @Ignore
 */

@Ignore
public class AnonUserTest {
    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @Test
    public void homePageTest() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage(LOCALHOST_8080_LOGIN);
            assertEquals("Rate Your Peers - Welcome to RYP", page.getTitleText());

            final String pageAsXml = page.asXml();
            assertTrue(pageAsXml.contains("<div id=\"mainWrapper\">"));

            final String pageAsText = page.asText();
            assertTrue(pageAsText.contains("Register"));
        }
    }

    @Test
    public void clickRegisterTest() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage homePage = webClient.getPage(LOCALHOST_8080_LOGIN);
            HtmlAnchor htmlAnchor = homePage.getAnchorByText("Register");
            htmlAnchor.click();
            final HtmlPage registerPage = (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();
            assertEquals("user", registerPage.getForms().get(0).getId());
            assertEquals("Rate Your Peers - Register", registerPage.getTitleText());
        }
    }
}
