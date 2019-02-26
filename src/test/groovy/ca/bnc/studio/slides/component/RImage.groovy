package ca.bnc.studio.slides.component

import org.testatoo.bundle.html5.Img

import static org.testatoo.core.Testatoo.getConfig

class RImage extends Img {
    @Override
    boolean visible() {
        config.evaluator.check(id(), "it.hasClass('visible')")
    }
}
