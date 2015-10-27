package nz.co.doltech.gwtjssor.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import nz.co.doltech.gwtjssor.client.options.SliderOptions;

import java.util.Iterator;

public class ImageSlider extends Composite implements HasId, HasWidgets {
    interface ImageSliderUiBinder extends UiBinder<HTMLPanel, ImageSlider> {}

    private static ImageSliderUiBinder uiBinder = GWT.create(ImageSliderUiBinder.class);

    @UiField Element slider;
    @UiField HTMLPanel slides;

    private SliderOptions options = SliderOptions.create();

    @UiConstructor
    public ImageSlider(String id) {
        initWidget(uiBinder.createAndBindUi(this));

        setId(id);
        slides.getElement().setAttribute("data-u", "slides");
        slides.getElement().setAttribute("style", 
            "cursor: default;" +
            "position: relative;" +
            "top: 0;" +
            "left: 0;" +
            "width: 800px;" +
            "height: 356px;" +
            "overflow: hidden;");
    }

    @Override
    public void add(Widget w) {
        slides.add(w);
    }

    @Override
    public void clear() {
        slides.clear();
    }

    @Override
    public Iterator<Widget> iterator() {
        return slides.iterator();
    }

    @Override
    public boolean remove(Widget w) {
        return slides.remove(w);
    }

    public ImageSlider setAutoPlay(boolean autoPlay) {
        options.setAutoPlay(autoPlay);
        return this;
    }

    public ImageSlider init(boolean responsive) {
        init(getId(), options);

        if(responsive) {
            enabledResponsive();
        }
        return this;
    }

    private native void init(String id, SliderOptions options) /*-{
        $wnd.jssor_slider = new $JssorSlider$(id, options);
    }-*/;

    @Override
    public String getId() {
        return slider.getId();
    }

    @Override
    public void setId(String id) {
        slider.setId(id);
    }

    private native ImageSlider enabledResponsive() /*-{
        function ScaleSlider() {
            var refSize = $wnd.jssor_slider.$Elmt.parentNode.clientWidth;
            if (refSize) {
                refSize = Math.min(refSize, 800);
                $wnd.jssor_slider.$ScaleWidth(refSize);
            }
            else {
                window.setTimeout(ScaleSlider, 30);
            }
        }
        ScaleSlider();
        $Jssor$.$AddEvent(window, "load", ScaleSlider);
        $Jssor$.$AddEvent(window, "resize", $Jssor$.$WindowResizeFilter(window, ScaleSlider));
        $Jssor$.$AddEvent(window, "orientationchange", ScaleSlider);
    }-*/;
}