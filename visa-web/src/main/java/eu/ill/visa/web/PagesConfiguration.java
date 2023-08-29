package eu.ill.visa.web;

import java.util.ArrayList;

public class PagesConfiguration extends ArrayList<Page> {}

class Page {

    private String  title;
    private String  iconShape;
    private String  iframeSrc;
    private String  iframeHeight = "100%";
    private String  iframeWidth = "100%";

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

    public String getIframeHeight() {
        return iframeHeight;
    }

    public void setIframeHeight(String iframeHeight) {
        this.iframeHeight = iframeHeight;
    }

    public String getIframeWidth() {
        return iframeWidth;
    }

    public void setIframeWidth(String iframeWidth) {
        this.iframeWidth = iframeWidth;
    }
    
}