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
        presentation().should { have 10.slides }
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
    @DisplayName("Slide 7 - should present Christian")
    void slide7() {
        slide(7)
        pepeOnViagra().should { be visible }
    }

    @Test
    @DisplayName("Slide 8 - should present Paule")
    void slide8() {
        slide(8)
        granny().should { be visible }
    }

    @Test
    @DisplayName("Slide 9 - should present Nicolas")
    void slide9() {
        slide(9)
        porky().should { be visible }
    }

    @Test
    @DisplayName("Slide 10 - should display Target")
    void slide10() {
        slide(10).should { have title("#Target")}
        target().should { be visible }
    }

    @Test
    @DisplayName("Slide 11 - should display DevOps cycle")
    void slide11() {
        slide(11)
        devops().should { be visible }
    }

    @Test
    @DisplayName("Slide 12 - should display quiz time")
    void slide12() {
        slide(12)
        quizTime().should { be visible }
    }

    @Test
    @DisplayName("Slide 13 - should display Man-in-the-middle attack Question")
    void slide13() {
        slide(13).should { have title("Man-in-the-middle attack")}
    }

    @Test
    @DisplayName("Slide 14 - should display Man-in-the-middle attack Answer")
    void slide14() {
//        slide(14).should { have title("is an attack where the attacker secretly relays and possibly alters the communication between two parties who believe they are directly communicating with each other")}
    }

    @Test
    @DisplayName("Slide 15 - should display Man-in-the-middle attack Sample")
    void slide15() {
        slide(15)
        attack().should { be visible }
    }

    @Test
    @DisplayName("Slide 16 - Success")
    void slide16() {
    }

    @Test
    @DisplayName("Slide 17 - Failure")
    void slide17() {
    }

    @Test
    @DisplayName("Slide 18 - should display change Culture")
    void slide18() {
        slide(18).should { have title("#Change Culture")}
    }
//
//    @Test
//    @DisplayName("Slide 16 - should display Plane")
//    void slide16() {
//        slide(16)
//        plane().should { be visible }
//    }
//
//    @Test
//    @DisplayName("Slide 17 - Why")
//    void slide17() {
//        slide(17).should { have title("#WHY ?")}
//    }
//
//    @Test
//    @DisplayName("Slide 18 - Why")
//    void slide18() {
//        slide(18)
//        train().should { be visible }
//    }
//
//    @Test
//    @DisplayName("Slide 19 - Why")
//    void slide19() {
//        slide(19)
//        tunnel().should { be visible }
//    }
//
//    @Test
//    @DisplayName("Slide 20 - Why")
//    void slide20() {
//        slide(20).should { have title("#WHY ?")}
//    }




    // WHY ?




        // Legacy
        // L'important c'est le WHY
        // Toujours questionner.....
        // Lever les flags
        // Identifier les problemes

        // Design by committee
        //  Expérience de Asch
}