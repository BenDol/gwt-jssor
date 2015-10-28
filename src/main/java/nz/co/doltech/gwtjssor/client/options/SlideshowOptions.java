package nz.co.doltech.gwtjssor.client.options;

import com.google.gwt.core.client.JavaScriptObject;

public class SlideshowOptions extends JavaScriptObject {

    protected SlideshowOptions() {}

    public native final void setClass(JavaScriptObject classJso) /*-{
        this.$Class = classJso;
    }-*/;

    public native final void setDefaults() /*-{
        this.$Class = $wnd.$JssorSlideshowRunner$;
    }-*/;

    public static SlideshowOptions create() {
        SlideshowOptions opt = JavaScriptObject.createObject().cast();
        opt.setDefaults();
        return opt;
    }
}
