package com.example;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "String Java_Vinod Nagda",
        shortName = "String_Java",
        description = "Developed by Vinod Nagda",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) {

        // Use TextField for standard text input
        Label a=new Label("Please Enter the String and Char and click on Submit Button.");

        TextField textField = new TextField("String:");
        TextField textField2 = new TextField("Char:");
        textField.addThemeName("bordered");
        textField2.addThemeName("bordered");



        // Button click listeners can be defined as lambda expressions

        Button button = new Button("Other",
                e -> Notification.show(service.printString(textField.getValue(),textField2.getValue())));




        // Theme variants give you predefined extra styles for components.
        // Example: Primary button has a more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        button.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");
        a.addClassName("ok");

        //for button
        Button addButton = new Button("Get Result");
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);


        VerticalLayout todosList = new VerticalLayout();
        addButton.addClickListener(click -> {
            todosList.removeAll();
            todosList.add(service.printString(textField.getValue(),textField2.getValue()));
        });

        //for clear button
        Button clearbutton = new Button("Clear Result ");
        clearbutton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        clearbutton.addClickListener(click -> {
            todosList.removeAll();

        });
        HtmlComponent br = new HtmlComponent("hr");
        add( a,textField,textField2,addButton);
        add(br,
                new H1("Result"),
                todosList, new HorizontalLayout(clearbutton)
        );
    }


}
