package nz.co.doltech.gwtjssor.client.options;

import com.google.gwt.core.client.JavaScriptObject;

public class ArrowOptions extends JavaScriptObject {

    protected ArrowOptions() {}

    public native final void setClass(JavaScriptObject classJso) /*-{
        this.$Class = classJso;
    }-*/;

    public native final void setDefaults() /*-{
        this.$Class = $JssorArrowNavigator$;
    }-*/;

    public static ArrowOptions create() {
        ArrowOptions opt = JavaScriptObject.createObject().cast();
        opt.setDefaults();
        return opt;
    }
}
