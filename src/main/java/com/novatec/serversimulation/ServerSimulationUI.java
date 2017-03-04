package com.novatec.serversimulation;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class ServerSimulationUI extends UI {

    private static final long serialVersionUID = 1L;
   
    boolean weather = false;
    boolean currency = false;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final HorizontalLayout layoutWeather = new HorizontalLayout();
        final HorizontalLayout layoutCurrency = new HorizontalLayout();

        Label lblWeather = new Label("Service Weather");
        Label lblCurrency = new Label("Service Currency");
        
        Button buttonWeather = new Button("NO");
        Button buttonCurrency = new Button("NO");
        
        buttonWeather.addClickListener( e -> {
            if (weather) {
                CallUrl.callDeleteRestWeatherCurl();
                CallUrl.callDeleteSOAPWeatherCurl();
                buttonWeather.setCaption("NO");
                weather = false;
            }else {
                CallUrl.callAddMappingRestWeatherCurl();
                CallUrl.callAddMappingSOAPWeatherCurl();
                buttonWeather.setCaption("YES");
                weather = true;
            }
        });

        buttonCurrency.addClickListener( e -> {
            if (currency) {
                CallUrl.callDeleteRestCurrencyCurl();
                CallUrl.callDeleteSOAPCurrencyCurl();
                buttonCurrency.setCaption("NO");
                currency = false;
            }else {
                CallUrl.callAddMappingRestCurrencyCurl();
                CallUrl.callAddMappingSOAPCurrencyCurl();
                buttonCurrency.setCaption("YES");
                currency = true;
            }
        });

        layoutWeather.addComponents(lblWeather, buttonWeather);
        layoutCurrency.addComponents(lblCurrency, buttonCurrency);
        
        layoutWeather.setMargin(true);
        layoutWeather.setSpacing(true);
        
        layoutCurrency.setMargin(true);
        layoutCurrency.setSpacing(true);
        
        layout.addComponents(layoutWeather,layoutCurrency);
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
    }
    
   
    @WebServlet(urlPatterns = "/*", name = "ServerSimulationUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ServerSimulationUI.class, productionMode = false)
    public static class ServerSimulationUIServlet extends VaadinServlet {

        private static final long serialVersionUID = 1L;
    }
}
