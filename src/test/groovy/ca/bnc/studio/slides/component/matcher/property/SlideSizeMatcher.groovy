package ca.bnc.studio.slides.component.matcher.property

import ca.bnc.studio.slides.component.support.SlideSupport
import org.hamcrest.Description
import org.testatoo.hamcrest.PropertyMatcher

class SlideSizeMatcher extends PropertyMatcher<SlideSupport> {
    private Integer number

    SlideSizeMatcher(Integer number) {
        this.number = number
    }

    @Override
    protected boolean matchesSafely(SlideSupport component) {
        component.slides().size() == number
    }

    @Override
    void describeTo(Description description) {
        description.appendText(number + ' slide(s)')
    }

    @Override
    protected void describeMismatchSafely(SlideSupport component, Description mismatchDescription) {
        mismatchDescription.appendText('has ' + component.slides().size()).appendText(' slide(s)')
    }
}