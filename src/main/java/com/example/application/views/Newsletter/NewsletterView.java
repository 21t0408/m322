package com.example.application.views.Newsletter;

import com.example.application.data.entity.Newsletter;
import com.example.application.views.Start.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Newsletter abonieren")
@Route(value = "addNewsletter")
@Uses(Icon.class)
public class NewsletterView extends Div {

    private static Newsletter newsletter = new Newsletter();

    private EmailField email = new EmailField("Email Adresse");
    private TextField firstName = new TextField("Vorname");
    private TextField lastName = new TextField("Nachname");

    private Button cancel = new Button("Abbrechen");
    private Button save = new Button("Abonieren");
    private Button clear = new Button("Zurücksetzen");

    private Binder<Newsletter> binder = new Binder<>(Newsletter.class);

    public NewsletterView() {
        addClassName("newsletter-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.MEDIUM, AlignItems.CENTER);

        VerticalLayout mainContainer = new VerticalLayout();
        mainContainer.addClassNames(AlignItems.CENTER);

        VerticalLayout headerContainer = new VerticalLayout();
        headerContainer.addClassNames(Margin.Top.SMALL, Margin.Bottom.SMALL, AlignItems.CENTER);
        H2 header = new H2("Newsletter abonieren");
        header.addClassNames(FontSize.XXXLARGE, Margin.Bottom.NONE, AlignItems.CENTER);
        headerContainer.add(header);

        mainContainer.add(headerContainer);
        mainContainer.add(createFormLayout());
        mainContainer.add(createButtonLayout());
        add(mainContainer);

        binder.bindInstanceFields(this);
        binder.readBean(newsletter);
        binder.setBean(newsletter);

        clear.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            Notification.show("Vielen Dank! Sie haben unseren Newsletter aboniert");
            getUI().ifPresent(ui -> ui.navigate(HomeView.class));
        });
        cancel.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(HomeView.class)));
    }

    private void clearForm() {
        newsletter = new Newsletter();
        binder.setBean(new Newsletter());
        binder.readBean(newsletter);
    }

    private Component createFormLayout() {
        VerticalLayout formLayout = new VerticalLayout();
        formLayout.addClassNames(Margin.Top.SMALL, Margin.Bottom.SMALL, AlignItems.CENTER);
        email.setErrorMessage("Bitte geben sie eine valide Email Adresse ein");

        firstName.setWidth("50%");
        lastName.setWidth("50%");
        email.setWidth("50%");

        formLayout.add(firstName);
        formLayout.add(lastName);
        formLayout.add(email);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonLayout.add(save);
        buttonLayout.add(cancel);
        buttonLayout.add(clear);
        return buttonLayout;
    }
}
