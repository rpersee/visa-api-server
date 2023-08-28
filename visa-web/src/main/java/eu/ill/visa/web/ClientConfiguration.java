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

    @NotNull
    @Valid
    private PagesConfiguration pagesConfiguration;

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
    public PagesConfiguration getPagesConfiguration() {
        return pagesConfiguration;
    }

    public void setPagesConfiguration(PagesConfiguration pagesConfiguration) {
        this.pagesConfiguration = pagesConfiguration;
    }
    
}
