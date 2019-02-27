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
            case 10:
                return $('#slide_10') as SlideTitle
            case 13:
                return $('#slide_13') as SlideTitle
            case 14:
                return $('#slide_14') as SlideTitle
            case 18:
                return $('#slide_18') as SlideTitle

            default:
                return $('#slide_${i}') as Slide
        }
    }

    static Image taz() {
        $("#taz") as Img
    }

    static Image pepe() {
        $("#pepe") as Img
    }

    static Image pepeOnViagra() {
        $("#pepe_viagra") as Img
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

    static Image target() {
        $("#target") as Img
    }

    static Image devops() {
        $("#devops") as Img
    }

    static Image quizTime() {
        $("#quiz") as Img
    }

    static Image attack() {
        $("#attack") as Img
    }





}
