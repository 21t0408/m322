package com.example.application.views.Start;

import com.example.application.views.Bestellung.BestellungView;
import com.example.application.views.Bestellung.AddBestellungView;
import com.example.application.views.Kontakt.KontaktView;
import com.example.application.views.Menu.MenuView;
import com.example.application.views.Newsletter.NewsletterView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

@PageTitle("Home")
@Route(value = "Start")
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSpacing(false);
    
        constructUI();
    }
    
    private void constructUI() {
        addClassNames("home-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.MEDIUM, AlignItems.CENTER);
    
        VerticalLayout mainContainer = new VerticalLayout();
        mainContainer.addClassNames(AlignItems.CENTER);
    
        VerticalLayout headerContainer = new VerticalLayout();
        headerContainer.addClassNames(Margin.Top.SMALL, Margin.Bottom.SMALL, AlignItems.CENTER);
    
        H2 header = new H2("Noah's Pizza");
        header.addClassNames(FontSize.XXXLARGE, Margin.Bottom.NONE, AlignItems.CENTER);
    
        Paragraph description = new Paragraph("077 458 10 06");
        description.addClassNames(Margin.Top.NONE, TextColor.SECONDARY, AlignItems.CENTER);

        Div backButtonLayout = new Div();
        Button button = new Button("Newsletter beitreten");
        button.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(NewsletterView.class)));
        backButtonLayout.add(button);
    
        headerContainer.add(header, description, backButtonLayout);
    
        HorizontalLayout cardContainer = new HorizontalLayout();
        cardContainer.addClassNames(Gap.MEDIUM, AlignItems.CENTER);

        HomeCardView card1 = new HomeCardView("Bestellungen", "icons/bestellungen.png");
        card1.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(BestellungView.class)));
        HomeCardView card2 = new HomeCardView("Menükarte", "icons/menuKarte.png");
        card2.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(MenuView.class)));
        HomeCardView card3 = new HomeCardView("Kontakt", "icons/kontakt.png");
        card3.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(KontaktView.class)));

        cardContainer.add(card1, card2, card3);
    
        mainContainer.add(headerContainer, cardContainer);
    
        add(mainContainer);
    }   
}
