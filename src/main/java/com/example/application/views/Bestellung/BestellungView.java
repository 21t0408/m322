package com.example.application.views.Bestellung;

import com.example.application.data.entity.Bestellung;
import com.example.application.data.service.BestellungSource;
import com.example.application.views.Start.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Bestellungen")
@Route(value = "bestellungen-view")
@Uses(Icon.class)
public class BestellungView extends Div {

    private Grid<Bestellung> grid;

    public BestellungView() {
        setSizeFull();
        addClassNames("hello-world-view");

        VerticalLayout headerContainer = new VerticalLayout();
        headerContainer.addClassNames(Margin.Top.SMALL, Margin.Bottom.SMALL, AlignItems.CENTER);
    
        H2 header = new H2("Meine Bestellungen");
        header.addClassNames(FontSize.XXXLARGE, Margin.Bottom.NONE, AlignItems.CENTER);

        Div buttonLayout = new Div();
        Button button = new Button("Bestellung hinzufügen");
        button.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(AddBestellungView.class)));
        buttonLayout.add(button);

        headerContainer.add(header, buttonLayout);

        Div backButtonLayout = new Div();
        backButtonLayout.addClassNames(AlignItems.CENTER, Margin.MEDIUM);
        Button back = new Button("Zurück");
        back.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(HomeView.class)));
        backButtonLayout.add(back);

        VerticalLayout layout = new VerticalLayout(headerContainer, createGrid(), backButtonLayout);
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        add(layout);
    }

    private Component createGrid() {
        grid = new Grid<>(Bestellung.class, false);
        grid.addColumn("pizza.name").setAutoWidth(true).setHeader("Name");
        grid.addColumn("lieferDatum").setAutoWidth(true).setHeader("Lieferdatum");
        grid.addColumn(item -> item.getPizza().getPrice()).setAutoWidth(true).setHeader("Preis");

        grid.setItems(BestellungSource.bestellungen);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.addClassNames(LumoUtility.Border.TOP, LumoUtility.BorderColor.CONTRAST_10, Margin.LARGE);

        return grid;
    }
}
