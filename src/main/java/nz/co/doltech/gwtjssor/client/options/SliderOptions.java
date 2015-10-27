package nz.co.doltech.gwtjssor.client.options;

import com.google.gwt.core.client.JavaScriptObject;

public class SliderOptions extends JavaScriptObject {

    protected SliderOptions() {}

    public native final void setAutoPlay(boolean autoPlay) /*-{
        this.$AutoPlay = autoPlay;
    }-*/;

    public native final void setArrowOptions(ArrowOptions arrowOptions) /*-{
        this.$ArrowNavigatorOptions = arrowOptions;
    }-*/;

    public native final void setArrowOptions(ThumbnailOptions thumbnailOptions) /*-{
        this.$ThumbnailNavigatorOptions = thumbnailOptions;
    }-*/;

    public native final void setDefaults() /*-{
        this.$AutoPlay = false;
        this.$ArrowNavigatorOptions = @nz.co.doltech.gwtjssor.client.options.ArrowOptions::create()();
        this.$ThumbnailNavigatorOptions = @nz.co.doltech.gwtjssor.client.options.ThumbnailOptions::create()();
    }-*/;

    public static SliderOptions create() {
        SliderOptions opt = JavaScriptObject.createObject().cast();
        opt.setDefaults();
        return opt;
    }
}
