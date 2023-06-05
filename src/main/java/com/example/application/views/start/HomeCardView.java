package com.example.application.views.start;

import com.example.application.views.dashboard.DashboardView;
import com.vaadin.flow.component.charts.model.TextAlign;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignContent;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;
import com.vaadin.flow.theme.lumo.LumoUtility.BorderRadius;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

public class HomeCardView extends ListItem {

    public HomeCardView(String title, String url) {
        addClassNames(Background.CONTRAST_5, Display.FLEX, FlexDirection.COLUMN, AlignItems.START, Padding.MEDIUM,
                BorderRadius.LARGE);
    
        Div div = new Div();
        div.addClassNames(Display.FLEX, AlignItems.CENTER, JustifyContent.CENTER, Margin.Bottom.MEDIUM, Overflow.HIDDEN,
                BorderRadius.MEDIUM);
        div.setHeight("250px");
    
        Image image = new Image(url, title);
        image.addClassNames(Margin.Bottom.MEDIUM);
        image.setWidth("200px");
    
        Span header = new Span(title);
        header.addClassNames(FontSize.XLARGE, FontWeight.SEMIBOLD, AlignContent.CENTER);
    
        div.add(image);
        add(div, header);
    }    
}
