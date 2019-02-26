package ca.bnc.studio.slides.component

import org.testatoo.bundle.html5.Img
import org.testatoo.core.component.Image

import static org.testatoo.core.Testatoo.$
import static org.testatoo.core.Testatoo.config

class Factory {
    static Presentation presentation() {
        $('body') as Presentation
    }

    static Slide slide(int index) {
        config.evaluator.runScript("Reveal.slide(${index - 1});")
        switch (index) {
            case 1:
                return $('#slide_1') as SlideTitle
            case 2:
                return $('#slide_2') as SlideTitle

            default:
                return $('#slide_${i -1}') as Slide
        }
    }

    static Image taz() {
        $("#taz") as Img
    }

    static Image pepe() {
        $("#pepe") as Img
    }

    static Image speedy() {
        $("#speedy") as Img
    }

    static Image droopy() {
        $("#droopy") as Img
    }

    static Image granny() {
        $("#granny") as Img
    }

    static Image porky() {
        $("#porky") as Img
    }



    static Image simpleDdevopsImage() {
        $("#devops_1") as Img
    }

    static Image fullDevopsImage() {
        $("#devops_2") as Img
    }
}
