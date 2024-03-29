package org.hbrs.se2.project.hellocar.views;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import org.hbrs.se2.project.hellocar.control.ManageCarControl;
import org.hbrs.se2.project.hellocar.dtos.impl.CarDTOImpl;
import org.hbrs.se2.project.hellocar.dtos.UserDTO;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.hellocar.util.Globals;

@Route(value = Globals.Pages.ENTER_Service, layout = AppView.class)
@PageTitle("Enter Service")
@CssImport("./styles/views/entercar/enter-car-view.css")
public class Student extends Div {

    private TextField services = new TextField("Services");


    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<CarDTOImpl> binder = new Binder(CarDTOImpl.class);

    public Student(ManageCarControl carService) {
        addClassName("enter-Student-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        // Default Mapping of Cars attributes and the names of this View based on names
        // Source: https://vaadin.com/docs/flow/binding-data/tutorial-flow-components-binder-beans.html
        binder.bindInstanceFields(this);
        clearForm();

        // Registrierung eines Listeners Nr. 1 (moderne Variante mit Lambda-Expression)
        cancel.addClickListener(event -> clearForm());

        // Registrierung eines Listeners Nr. 2 (traditionelle Variante mit anonymen Objekt)
        cancel.addAttachListener( new ComponentEventListener() {
            @Override
            public void onComponentEvent(ComponentEvent event) {
                clearForm();

            }
        } );

        save.addClickListener(e -> {
            // Speicherung der Daten über das zuhörige Control-Object.
            // Daten des Autos werden aus Formular erfasst und als DTO übergeben.
            // Zusätzlich wird das aktuelle UserDTO übergeben.
            UserDTO userDTO = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
            carService.createCar(binder.getBean() ,  userDTO );

            Notification.show("Car details stored.");
            clearForm();
        });
    }

    private void clearForm() {
        binder.setBean(new CarDTOImpl());
    }

    private Component createTitle() {
        return new H3("Car information");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(services);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }
    private void navigateToVacPage()  {
        // Navigation zur Startseite, hier die jeweilige Profilseite, die noch eingebunden werden muss
        UI.getCurrent().navigate(Globals.Pages.ENTER_Service);
    }


}
