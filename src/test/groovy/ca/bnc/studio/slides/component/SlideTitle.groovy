package ca.bnc.studio.slides.component

import org.testatoo.core.support.property.TitleSupport

import static org.testatoo.core.Testatoo.getConfig

class SlideTitle extends Slide implements TitleSupport {
    @Override
    String title() {
        config.evaluator.eval(id(), "it.find('h1').text()")
    }
}
