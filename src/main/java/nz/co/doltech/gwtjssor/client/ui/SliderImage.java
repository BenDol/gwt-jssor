package nz.co.doltech.gwtjssor.client.ui;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Image;

public class SliderImage extends ComplexPanel {

    private final Image image;
    private final Image thumbnail;

    public SliderImage(String imageUrl, String thumbUrl) {
        getElement().setAttribute("data-p", "144.50");
        getElement().getStyle().setDisplay(Style.Display.NONE);

        thumbnail = new Image(thumbUrl);
        thumbnail.getElement().setAttribute("data-u", "thumb");
        add(thumbnail);

        image = new Image(imageUrl);
        image.getElement().setAttribute("data-u", "image");
        add(image);
    }

    public Image getImage() {
        return image;
    }

    public Image getThumbnail() {
        return thumbnail;
    }
}
