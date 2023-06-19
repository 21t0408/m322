package com.example.application.views.Menu;

import com.example.application.data.entity.Pizza;
import com.example.application.data.service.PizzaSource;
import com.example.application.views.Start.HomeView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Menü-Kartr")
@Route(value = "pizza-list")
public class MenuView extends Main {

    public MenuView() {
        addClassNames("menu-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        VerticalLayout mainContainer = new VerticalLayout();
        mainContainer.addClassNames(AlignItems.CENTER);

        VerticalLayout headerContainer = new VerticalLayout();
        headerContainer.addClassNames(Margin.Top.SMALL, Margin.Bottom.MEDIUM, AlignItems.CENTER);

        H2 header = new H2("Menükarte");
        header.addClassNames(FontSize.XXXLARGE, Margin.Bottom.NONE, AlignItems.CENTER);

        headerContainer.add(header);

        HorizontalLayout cardContainer = new HorizontalLayout();
        cardContainer.addClassNames(Gap.MEDIUM, AlignItems.CENTER);

        new PizzaSource();
        for (Pizza pizza : PizzaSource.pizzas) {
            MenuCardView card = new MenuCardView(pizza.getName(), pizza.getImg(), pizza.getPrice());
            cardContainer.add(card);
        }

        VerticalLayout backContainer = new VerticalLayout();
        backContainer.addClassNames(Margin.Top.SMALL, Margin.Bottom.XLARGE, AlignItems.CENTER);

        Div backButtonLayout = new Div();
        Button back = new Button("Zurück");
        back.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(HomeView.class)));
        backButtonLayout.add(back);

        backContainer.add(backButtonLayout);

        mainContainer.add(headerContainer, cardContainer, backContainer);
        add(mainContainer);
    }
}
