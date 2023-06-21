package com.example.application.views.Kontakt;

import com.example.application.data.entity.Kontakt;
import com.example.application.views.Start.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

@PageTitle("Kontakt")
@Route(value = "Kontakt")
@Uses(Icon.class)
public class KontaktView extends Div {

    private static Kontakt kontakt = new Kontakt();

    private EmailField email = new EmailField("Email Adresse");
    private PhoneNumberField phone = new PhoneNumberField("Telefonnummer");
    private TextArea message = new TextArea("Mittteilung");

    private Button rollback = new Button("Zurücksetzen");
    private Button send = new Button("Absenden");

    private Binder<Kontakt> binder = new Binder<>(Kontakt.class);

    public KontaktView() {
        addClassName("contact-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.MEDIUM, AlignItems.CENTER);

        HorizontalLayout mainContainer = new HorizontalLayout();
        mainContainer.addClassNames(AlignItems.START);

        mainContainer.add(createInformationLayout());
        mainContainer.add(createFormLayout());

        Div backButtonLayout = new Div();
        backButtonLayout.addClassNames(AlignItems.CENTER, Margin.LARGE);
        Button back = new Button("Zurück");
        back.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(HomeView.class)));
        backButtonLayout.add(back);

        add(mainContainer, backButtonLayout);

        binder.bindInstanceFields(this);
        binder.readBean(kontakt);
        binder.setBean(kontakt);

        rollback.addClickListener(e -> clearForm());
        send.addClickListener(e -> {
            Notification.show("Vielen Dank! Ihre Anfrage wurde versendet");
            clearForm();
        });
    }

    private void clearForm() {
        binder.setBean(new Kontakt());
    }

    private Component createInformationLayout() {
        VerticalLayout informationContainer = new VerticalLayout();
        informationContainer.addClassNames(AlignItems.CENTER);
        informationContainer.setWidth("50%");

        H2 header = new H2("Noah's Pizza");
        header.addClassNames(FontSize.XXXLARGE, Margin.Bottom.MEDIUM, AlignItems.CENTER);

        VerticalLayout informations = new VerticalLayout();
        informations.addClassNames(AlignItems.CENTER);
        Paragraph name = new Paragraph("Herr Baumgartner Noah");
        name.addClassNames(Margin.Top.NONE, Margin.Bottom.NONE, TextColor.SECONDARY, AlignItems.CENTER);
        Paragraph street = new Paragraph("Wilerstrasse 97b");
        street.addClassNames(Margin.Top.NONE, Margin.Bottom.NONE, TextColor.SECONDARY, AlignItems.CENTER);
        Paragraph town = new Paragraph("9500 Wil");
        town.addClassNames(Margin.Top.NONE, Margin.Bottom.NONE, TextColor.SECONDARY, AlignItems.CENTER);
        Paragraph country = new Paragraph("CH Schweiz");
        country.addClassNames(Margin.Top.NONE, Margin.Bottom.NONE, TextColor.SECONDARY, AlignItems.CENTER);
        informations.add(name, street, town, country);

        VerticalLayout contactInformations = new VerticalLayout();
        contactInformations.addClassNames(AlignItems.CENTER);
        Paragraph phoneNumber = new Paragraph("+41 77 458 10 06");
        phoneNumber.addClassNames(Margin.Top.MEDIUM, Margin.Bottom.NONE, TextColor.SECONDARY, AlignItems.CENTER);
        Paragraph mailAdress = new Paragraph("noah.baumgartner2005@gmx.ch");
        mailAdress.addClassNames(Margin.Top.NONE, Margin.Bottom.NONE, TextColor.SECONDARY, AlignItems.CENTER);
        contactInformations.add(phoneNumber, mailAdress);

        informationContainer.add(header, informations, contactInformations);

        return informationContainer;
    }

    private Component createFormLayout() {
        VerticalLayout formLayout = new VerticalLayout();
        formLayout.addClassNames(AlignItems.CENTER);
        formLayout.setWidth("50%");

        VerticalLayout forms = new VerticalLayout();
        forms.addClassNames(AlignItems.CENTER);

        H2 header = new H2("Kritik oder Fragen");
        header.addClassNames(FontSize.XXXLARGE, Margin.Bottom.MEDIUM, AlignItems.CENTER);

        email.setErrorMessage("Please enter a valid email address");
        
        phone.setWidth("100%");
        email.setWidth("100%");
        message.setWidth("100%");

        forms.add(phone, email, message);
        formLayout.add(header);
        formLayout.add(forms);
        formLayout.add(createButtonLayout());
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassNames(AlignItems.CENTER);
        buttonLayout.addClassName("button-layout");
        send.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonLayout.add(send);
        buttonLayout.add(rollback);
        return buttonLayout;
    }

    private static class PhoneNumberField extends CustomField<String> {
        private ComboBox<String> countryCode = new ComboBox<>();
        private TextField number = new TextField();

        public PhoneNumberField(String label) {
            setLabel(label);
            countryCode.setWidth("120px");
            countryCode.setPlaceholder("Vorwahl");
            countryCode.setAllowedCharPattern("[\\+\\d]");
            countryCode.setItems("+41");
            countryCode.addCustomValueSetListener(e -> countryCode.setValue(e.getDetail()));
            number.setAllowedCharPattern("\\d");
            number.setMaxLength(7);
            HorizontalLayout layout = new HorizontalLayout(countryCode, number);
            layout.setFlexGrow(1.0, number);
            add(layout);
        }

        @Override
        protected String generateModelValue() {
            if (countryCode.getValue() != null && number.getValue() != null) {
                String s = countryCode.getValue() + " " + number.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String phoneNumber) {
            String[] parts = phoneNumber != null ? phoneNumber.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                countryCode.clear();
                number.setValue(parts[0]);
            } else if (parts.length == 2) {
                countryCode.setValue(parts[0]);
                number.setValue(parts[1]);
            } else {
                countryCode.clear();
                number.clear();
            }
        }
    }

}
