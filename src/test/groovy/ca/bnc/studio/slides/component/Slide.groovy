package ca.bnc.studio.slides.component

import org.testatoo.bundle.html5.Section
import org.testatoo.core.support.property.TitleSupport
import static org.testatoo.core.Testatoo.*

class Slide extends Section implements TitleSupport {
    @Override
    String title() {
        config.evaluator.eval(id(), "find('h1').text()")
    }
}
