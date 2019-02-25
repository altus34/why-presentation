package ca.bnc.studio.slides.component

import static org.testatoo.core.Testatoo.$

class Factory {
    static Presentation presentation() {
        $('body') as Presentation
    }

    static Slide slide(int index) {
        $('#slide_${i -1}') as Slide
    }
}
