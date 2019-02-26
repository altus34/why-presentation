package ca.bnc.studio.slides


import org.junit.jupiter.api.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testatoo.evaluator.webdriver.WebDriverEvaluator
import reactor.netty.DisposableServer
import reactor.netty.http.server.HttpServer

import java.nio.file.Path
import java.nio.file.Paths

import static ca.bnc.studio.slides.component.Factory.*
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver
import static org.testatoo.core.Testatoo.*

class SlidesTest {
    private static final int PORT = 8080
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
    @DisplayName("Presentation should have expected number of slides")
    void expected() {
        presentation().should { have 8.slides }
    }

    @Test
    @DisplayName("Slide 1 - should display presentation title")
    void slide1() {
        slide(1).should { have title("#OueskonVa #KeskonFait")}
    }

    @Test
    @DisplayName("Slide 2 - should be the TEAM introduction")
    void slide2() {
        slide(2).should { have title("#Team")}
    }

    @Test
    @DisplayName("Slide 3 - should present JF")
    void slide3() {
        slide(3)
        taz().should { be visible }
    }

    @Test
    @DisplayName("Slide 4 - should present Christian")
    void slide4() {
        slide(4)
        pepe().should { be visible }
    }

    @Test
    @DisplayName("Slide 5 - should present David step 1")
    void slide5() {
        slide(5)
        speedy().should { be visible }
    }

    @Test
    @DisplayName("Slide 6 - should present David step 2")
    void slide6() {
        slide(6)
        droopy().should { be visible }
    }

    @Test
    @DisplayName("Slide 7 - should present Paule")
    void slide7() {
        slide(7)
        granny().should { be visible }
    }

    @Test
    @DisplayName("Slide 8 - should present Nicolas")
    void slide8() {
        slide(8)
        porky().should { be visible }
    }



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

//        current = presentation().slide("Team")
//    }
}