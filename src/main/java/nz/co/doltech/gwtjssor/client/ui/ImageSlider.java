package nz.co.doltech.gwtjssor.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import nz.co.doltech.gwtjssor.client.options.SliderOptions;
import nz.co.doltech.gwtjssor.client.util.StyleUtil;

import java.util.Iterator;
import java.util.logging.Logger;

public class ImageSlider extends Composite implements HasId, HasName, HasWidgets {
    private final static Logger logger = Logger.getLogger(ImageSlider.class.getName());

    interface ImageSliderUiBinder extends UiBinder<HTMLPanel, ImageSlider> {}

    private static ImageSliderUiBinder uiBinder = GWT.create(ImageSliderUiBinder.class);

    interface Resources extends ClientBundle {
        @Source("nz/co/doltech/gwtjssor/client/resources/img/loading.gif")
        ImageResource loading();
    }

    private final static Resources resources = GWT.create(Resources.class);

    @UiField Element slider;
    @UiField Element arrowLeft;
    @UiField Element arrowRight;
    @UiField HTMLPanel slides;
    @UiField HTMLPanel loading;

    private SliderOptions options = SliderOptions.create();

    @UiConstructor
    public ImageSlider(String name) {
        initWidget(uiBinder.createAndBindUi(this));

        setId(name);
        slides.getElement().setAttribute("data-u", "slides");
        slides.getElement().setAttribute("style", 
            "cursor: default;" +
            "position: relative;" +
            "top: 0;" +
            "left: 0;" +
            "width: 800px;" +
            "height: 356px;" +
            "overflow: hidden;");

        loading.getElement().setAttribute("style",
            "position:absolute;" +
                "display:block;" +
                "top:0;" +
                "left:0;" +
                "width:100%;" +
                "height:100%;");

        loading.getElement().setAttribute("background",
            "url('"+resources.loading().getSafeUri().asString()+ "') no-repeat center center");
    }

    @Override
    public void setWidth(String width) {
        double value = StyleUtil.getMeasurementValue(width);
        Unit unit = StyleUtil.getMeasurementUnit(width);

        if(unit.equals(Unit.PX)) {
            slider.getStyle().setWidth(value, unit);
            slides.getElement().getStyle().setWidth(value, unit);
            options.setSlideWidth(value);
        } else {
            logger.severe("Can only set width using px.");
        }
    }

    @Override
    public void setHeight(String height) {
        double value = StyleUtil.getMeasurementValue(height);
        Unit unit = StyleUtil.getMeasurementUnit(height);

        if(unit.equals(Unit.PX)) {
            slider.getStyle().setHeight(value, unit);
            slides.getElement().getStyle().setHeight(value, unit);
            options.setSlideHeight(value);

            if(value > 0) {
                arrowLeft.getStyle().setTop((value / 2) + arrowLeft.getClientHeight(), Unit.PX);
                arrowRight.getStyle().setTop((value / 2) + arrowRight.getClientHeight(), Unit.PX);
            }
        } else {
            logger.severe("Can only set height using px.");
        }
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
        String id = getId();
        init(id, options);

        if(responsive) {
            enabledResponsive(id);
        }
        return this;
    }

    private native void init(String id, SliderOptions options) /*-{
        if($wnd.jssor_slider == null) {
            $wnd.jssor_slider = [];
        }
        $wnd.jssor_slider[id] = new $wnd.$JssorSlider$(id, options);
    }-*/;

    @Override
    public String getId() {
        return slider.getId();
    }

    @Override
    public void setId(String id) {
        slider.setId(id);
    }

    @Override
    public void setName(String name) {
        setId(name);
    }

    @Override
    public String getName() {
        return getId();
    }

    public SliderOptions getOptions() {
        return options;
    }

    private native ImageSlider enabledResponsive(String id) /*-{
        function ScaleSlider() {
            var refSize = $wnd.jssor_slider[id].$Elmt.parentNode.clientWidth;
            if (refSize) {
                refSize = Math.min(refSize, 800);
                $wnd.jssor_slider[id].$ScaleWidth(refSize);
            }
            else {
                window.setTimeout(ScaleSlider, 30);
            }
        }
        ScaleSlider();
        $wnd.$Jssor$.$AddEvent(window, "load", ScaleSlider);
        $wnd.$Jssor$.$AddEvent(window, "resize", $wnd.$Jssor$.$WindowResizeFilter(window, ScaleSlider));
        $wnd.$Jssor$.$AddEvent(window, "orientationchange", ScaleSlider);
    }-*/;
}