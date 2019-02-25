package ca.bnc.studio.slides

import ca.bnc.studio.slides.component.Slide
import org.junit.jupiter.api.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testatoo.evaluator.webdriver.WebDriverEvaluator
import reactor.netty.DisposableServer
import reactor.netty.http.server.HttpServer

import java.nio.file.Path
import java.nio.file.Paths

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver
import static org.testatoo.core.Testatoo.getConfig
import static org.testatoo.core.Testatoo.visit

import static ca.bnc.studio.slides.component.Factory.*

class SlidesTest {
    private static final int PORT = 8080;
    private WebDriver driver
    private static DisposableServer server

    @BeforeAll
    static void beforeAll() {
        String helper = new File(".").getAbsolutePath()
        Path resource = Paths.get(helper + "/docs")
        server = HttpServer.create()
                .port(PORT)
                .route{routes -> routes.directory("/", resource)}
                .bindNow()
        chromedriver().setup()
    }

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver()
        config.evaluator = new WebDriverEvaluator(driver)
        visit("http://localhost:${PORT}/index.html")
    }

    @AfterEach
    void afterEach() {
        driver.close()
    }

    @AfterAll
    static void tearDown() {
        server.dispose()
    }

    @Test
    @DisplayName("Slides should have expected content")
    void expected() {
        presentation().should { have 2.slides}

        Slide current = slide(1)
        // Slide 1 Main Title ""

        // Slide 2 Title "Team"
        // JF => TAZ
        // Christian => Joker = > Pepe le putoi
        // David => Speede Gonzales => Droopy
        // Paul =>


        // Slide 3 Title ou est ce qu on va

        // Slide 3 Title Quiz Man-in-the-middle attack
        // where the attacker secretly relays and possibly alters the communication between two parties who believe they are directly communicating with each other
        // Sample

        // Slide 4 Title Quest ce qu on fait
        // Gateway
        // Pipeline
        // Monitory
        // Release

        // CI Valeur fonctionel
        // CD Valeur Operationel

        //

        // Toujours questionner.....
        // Lever les flags
        // Identifier les problemes

        // Design by committee
//        Expérience de Asch

//        current.should { have }
//        Slide current =  presentation().slide("Title")
//        current.should { have title("AAA BBB")}

        current = presentation().slide("Team")
    }
}