package nz.co.doltech.gwtjssor.client.options;

import com.google.gwt.core.client.JavaScriptObject;

public class ThumbnailOptions extends JavaScriptObject {

    protected ThumbnailOptions() {}

    public native final void setClass(JavaScriptObject classJso) /*-{
        this.$Class = classJso;
    }-*/;

    public native final void setCols(int cols) /*-{
        this.$Cols = cols;
    }-*/;

    public native final void setSpacingX(int spacingX) /*-{
        this.$SpacingX = spacingX;
    }-*/;

    public native final void setSpacingY(int spacingY) /*-{
        this.$SpacingY = spacingY;
    }-*/;

    public native final void setAlign(int align) /*-{
        this.$Align = align;
    }-*/;

    public native final void setDefaults() /*-{
        this.$Class = $wnd.$JssorThumbnailNavigator$;
        this.$Cols = 10;
        this.$SpacingX = 8;
        this.$SpacingY = 8;
        this.$Align = 360;
    }-*/;

    public static ThumbnailOptions create() {
        ThumbnailOptions opt = JavaScriptObject.createObject().cast();
        opt.setDefaults();
        return opt;
    }
}
