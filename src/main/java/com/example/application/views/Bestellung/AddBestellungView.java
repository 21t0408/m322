package com.example.application.views.Bestellung;

import com.example.application.data.entity.Bestellung;
import com.example.application.data.entity.Pizza;
import com.example.application.data.service.BestellungSource;
import com.example.application.data.service.PizzaSource;
import com.example.application.views.Start.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Bestellung hinzufügen")
@Route(value = "AddBestellung")
@Uses(Icon.class)
public class AddBestellungView extends Div {

    private static Bestellung bestellung = new Bestellung();

    private ComboBox<Pizza> pizza = new ComboBox<>("Pizza");
    private TextField plz = new TextField("PLZ");
    private TextField ort = new TextField("Ort");
    private TextField strasse = new TextField("Straße");
    private TextField hausNummer = new TextField("Hausnummer");
    private DatePicker lieferDatum = new DatePicker("Lieferdatum");
    private RadioButtonGroup<String> bezahlungsart = new RadioButtonGroup<>();

    private Button cancel = new Button("Abbrechen");
    private Button save = new Button("Bestellen");

    private Binder<Bestellung> binder = new Binder<>(Bestellung.class);

    public AddBestellungView() {
        addClassName("dashboard-view");

        VerticalLayout headerContainer = new VerticalLayout();
        headerContainer.addClassNames(Margin.Top.SMALL, Margin.Bottom.SMALL, AlignItems.CENTER);

        H2 header = new H2("Meine Bestellungen");
        header.addClassNames(FontSize.XXXLARGE, Margin.Bottom.NONE, AlignItems.CENTER);
        headerContainer.add(header);

        add(headerContainer);
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        binder.readBean(bestellung);
        binder.setBean(bestellung);

        cancel.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(BestellungView.class)));
        save.addClickListener(e -> {
            saveBestellung();
            Notification.show("Danke für Ihre Bestellung!");
            getUI().ifPresent(ui -> ui.navigate(BestellungView.class));
        });
    }

    private void saveBestellung() {
        Bestellung bestellung = binder.getBean();
        BestellungSource.bestellungen.add(bestellung);
    }

    private Component createFormLayout() {
        VerticalLayout formLayout = new VerticalLayout();
        formLayout.setWidth("100%");
        formLayout.addClassNames(AlignItems.CENTER);
        new PizzaSource();
        pizza.setItems(PizzaSource.pizzas);
        pizza.setItemLabelGenerator(Pizza::getName);
        pizza.setWidth("60%");
        formLayout.add(pizza);

        HorizontalLayout plzOrtLayout = new HorizontalLayout();
        plz.setWidth("100%");
        ort.setWidth("100%");
        plzOrtLayout.add(plz, ort);
        plzOrtLayout.setWidth("60%");
        formLayout.add(plzOrtLayout);

        HorizontalLayout strasseHausnummerLayout = new HorizontalLayout();
        strasse.setWidth("100%");
        hausNummer.setWidth("100%");
        strasseHausnummerLayout.add(strasse, hausNummer);
        strasseHausnummerLayout.setWidth("60%");
        formLayout.add(strasseHausnummerLayout);

        lieferDatum.setWidth("60%");
        formLayout.add(lieferDatum);

        bezahlungsart.setLabel("Bezahlungsart");
        bezahlungsart.setItems("Bar", "Twint", "Karte");
        bezahlungsart.setWidth("60%");
        formLayout.add(bezahlungsart);

        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setWidth("100%");
        buttonLayout.addClassNames(AlignItems.CENTER);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }
}
