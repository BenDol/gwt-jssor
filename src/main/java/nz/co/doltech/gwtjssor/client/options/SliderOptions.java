package nz.co.doltech.gwtjssor.client.options;

import com.google.gwt.core.client.JavaScriptObject;

public class SliderOptions extends JavaScriptObject {

    protected SliderOptions() {}

    /**
     * The way to fill image in slide.
     */
    public native final void setFillMode(FillMode fillMode) /*-{
        this.$FillMode = fillMode;
    }-*/;

    /**
     * For image with lazy loading format <img src2="url" .../>, by default it will
     * be loaded only when the slide comes. But an integer value (maybe 1, 2 or 3)
     * indicates that how far of nearby slides should be loaded immediately as well,
     * default value is 1.
     */
    public native final void setLazyLoading(int lazyLoading) /*-{
        this.$LazyLoading = lazyLoading;
    }-*/;

    /**
     * Index of slide to display when initialize, default value is 0.
     */
    public native final void setStartIndex(int startIndex) /*-{
        this.$StartIndex = startIndex;
    }-*/;

    /**
     * Whether to play automatically, to enable slideshow, this option
     * must be set to true.
     */
    public native final void setAutoPlay(boolean autoPlay) /*-{
        this.$AutoPlay = autoPlay;
    }-*/;

    /**
     * Steps to go for each auto play request. Possible value can be 1, 2, -1, -2.
     */
    public native final void setAutoPlaySteps(int autoPlaySteps) /*-{
        this.$AutoPlaySteps = autoPlaySteps;
    }-*/;

    /**
     * Enable loop(circular) of carousel or not.
     */
    public native final void setLoop(Loop loop) /*-{
        this.$Loop = loop;
    }-*/;

    /**
     * Interval (in milliseconds) to go for next slide since the previous
     * stopped if the slider is auto playing.
     */
    public native final void setIdle(int idleMillis) /*-{
        this.$Idle = idleMillis;
    }-*/;

    /**
     * Whether to pause when mouse over if a slider is auto playing,
     * 0: no pause,
     * 1: pause for desktop,
     * 2: pause for touch device,
     * 3: pause for desktop and touch device,
     * 4: freeze for desktop,
     * 8: freeze for touch device,
     * 12: freeze for desktop and touch device,
     * default value is 1
     */
    public final void setPauseOnHover(PauseOnHover pauseOnHover) {
        setPauseOnHover(pauseOnHover.pauseOnHover);
    }

    private native void setPauseOnHover(int pauseOnHover) /*-{
        this.$PauseOnHover = pauseOnHover;
    }-*/;

    /**
     * Steps to go for each navigation request by pressing arrow key,
     * default value is 1.
     */
    public native final void setArrowKeyNavigation(int arrowKeyNavigation) /*-{
        this.$ArrowKeyNavigation = arrowKeyNavigation;
    }-*/;

    /**
     * Specifies default duration for right to left animation in milliseconds.
     */
    public native final void setSlideDuration(int slideDuration) /*-{
        this.$SlideDuration = slideDuration;
    }-*/;

    /**
     * Specifies easing for right to left animation.
     */
    /*public native final void setSlideEasing(int slideEasing) /*-{
        this.$SlideEasing = slideEasing;
    }-*/;

    /**
     * Minimum drag offset to trigger slide.
     */
    public native final void setMinDragOffsetToSlide(int minDragOffsetToSlide) /*-{
        this.$MinDragOffsetToSlide = minDragOffsetToSlide;
    }-*/;

    /**
     * Width of every slide in pixels, default value is width of 'slides' container.
     */
    public native final void setSlideWidth(double slideWidth) /*-{
        this.$SlideWidth = slideWidth;
    }-*/;

    /**
     * Height of every slide in pixels, default value is height of 'slides' container.
     */
    public native final void setSlideHeight(double slideHeight) /*-{
        this.$SlideHeight = slideHeight;
    }-*/;

    /**
     * Space between each slide in pixels.
     */
    public native final void setSlideSpacing(int slideSpacing) /*-{
        this.$SlideSpacing = slideSpacing;
    }-*/;

    /**
     * Number of pieces to display (the slideshow would be disabled
     * if the value is set to greater than 1).
     */
    public native final void setDisplayPieces(int displayPieces) /*-{
        this.$DisplayPieces = displayPieces;
    }-*/;

    /**
     * The offset position to park slide (this options applys only
     * when slideshow disabled).
     */
    public native final void setParkingPosition(int parkingPosition) /*-{
        this.$ParkingPosition = parkingPosition;
    }-*/;

    /**
     * The way to search UI components (slides container, loading screen,
     * navigator container, arrow navigator container, thumbnail navigator container etc).
     */
    public final void setUISearchMode(UiSearchMode uiSearchMode) {
        setUISearchMode(uiSearchMode.ordinal());
    }

    private native void setUISearchMode(int uiSearchMode) /*-{
        this.$UISearchMode = uiSearchMode;
    }-*/;

    /**
     * Orientation to play slide (for auto play, navigation).
     */
    public final void setPlayOrientation(PlayOrientation playOrientation) {
        setPlayOrientation(playOrientation.ordinal());
    }

    private native void setPlayOrientation(int playOrientation) /*-{
        this.$PlayOrientation = playOrientation;
    }-*/;

    /**
     * Orientation to drag slide.
     */
    public final void setDragOrientation(DragOrientation dragOrientation) {
        setDragOrientation(dragOrientation.ordinal());
    }

    private native void setDragOrientation(int dragOrientation) /*-{
        this.$DragOrientation = dragOrientation;
    }-*/;

    public native final void setSlideshowOptions(SlideshowOptions slideshowOptions) /*-{
        this.$SlideshowOptions = slideshowOptions;
    }-*/;

    public native final void setArrowOptions(ArrowOptions arrowOptions) /*-{
        this.$ArrowNavigatorOptions = arrowOptions;
    }-*/;

    public native final void setThumbnailOptions(ThumbnailOptions thumbnailOptions) /*-{
        this.$ThumbnailNavigatorOptions = thumbnailOptions;
    }-*/;

    public native final void setDefaults() /*-{
        this.$SlideshowOptions = @nz.co.doltech.gwtjssor.client.options.SlideshowOptions::create()();
        this.$ArrowNavigatorOptions = @nz.co.doltech.gwtjssor.client.options.ArrowOptions::create()();
        this.$ThumbnailNavigatorOptions = @nz.co.doltech.gwtjssor.client.options.ThumbnailOptions::create()();
    }-*/;

    public static SliderOptions create() {
        SliderOptions opt = JavaScriptObject.createObject().cast();
        opt.setDefaults();
        return opt;
    }
}
