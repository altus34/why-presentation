package ca.bnc.studio.slides.component.support

import ca.bnc.studio.slides.component.Slide

interface SlideSupport {
    List<Slide> slides()

    Slide slide(String value)
}
