package ca.bnc.studio.slides.component

import ca.bnc.studio.slides.component.support.SlideSupport
import org.testatoo.bundle.html5.Section
import org.testatoo.core.CssIdentifier
import org.testatoo.core.component.Component

import static org.testatoo.core.Testatoo.$$

@CssIdentifier("body")
class Presentation extends Component implements SlideSupport {
    List<Slide> slides() {
        $$('Section', Section)
    }

    @Override
    Slide slide(String value) {
        throw new UnsupportedOperationException()
    }
}