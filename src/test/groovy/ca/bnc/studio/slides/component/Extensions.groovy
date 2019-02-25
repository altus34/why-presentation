package ca.bnc.studio.slides.component

import ca.bnc.studio.slides.component.matcher.property.SlideSizeMatcher
import org.testatoo.hamcrest.PropertyMatcher

class Extensions {
    static PropertyMatcher getSlides(Integer number) {
        new SlideSizeMatcher(number)
    }
}