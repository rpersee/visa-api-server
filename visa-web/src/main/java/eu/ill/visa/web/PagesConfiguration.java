package eu.ill.visa.web;

import java.util.ArrayList;

public class PagesConfiguration extends ArrayList<Page> {}

class Page {

    private String  title;
    private String  iconShape;
    private String  iframeSrc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconShape() {
        return iconShape;
    }

    public void setIconShape(String iconShape) {
        this.iconShape = iconShape;
    }

    public String getIframeSrc() {
        return iframeSrc;
    }

    public void setIframeSrc(String iframeSrc) {
        this.iframeSrc = iframeSrc;
    }

}