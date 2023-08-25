package eu.ill.visa.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

public class ClientConfiguration {

    @NotNull
    @Valid
    private LoginConfiguration loginConfiguration;

    @NotNull
    @Valid
    private AnalyticsConfiguration analyticsConfiguration;

    @NotNull
    @Valid
    private DesktopConfiguration desktopConfiguration;

    @NotNull
    @Valid
    private ExperimentsConfiguration experimentsConfiguration;

    private List<Page> extraPages;

    private String contactEmail;

    @JsonProperty("login")
    public LoginConfiguration getLoginConfiguration() {
        return loginConfiguration;
    }

    public void setLoginConfiguration(LoginConfiguration loginConfiguration) {
        this.loginConfiguration = loginConfiguration;
    }

    @JsonProperty("analytics")
    public AnalyticsConfiguration getAnalyticsConfiguration() {
        return analyticsConfiguration;
    }

    public void setAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration) {
        this.analyticsConfiguration = analyticsConfiguration;
    }

    @JsonProperty("desktop")
    public DesktopConfiguration getDesktopConfiguration() {
        return desktopConfiguration;
    }

    @JsonProperty("experiments")
    public ExperimentsConfiguration getExperimentsConfiguration() {
        return experimentsConfiguration;
    }

    @JsonProperty("contactEmail")
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @JsonProperty("extraPages")
    public List<Page> getExtraPages() {
        return extraPages;
    }

    public void setExtraPages(List<Page> extraPages) {
        this.extraPages = extraPages;
    }

    public static class Page {

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

}
