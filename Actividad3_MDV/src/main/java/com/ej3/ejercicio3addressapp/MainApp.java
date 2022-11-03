package com.ej3.ejercicio3addressapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private static final String APP_XML = "RootLayout.fxml";
    private static final String USER_MENU_XML = "PersonOverview.fxml";

    private AnchorPane menu;
    private BorderPane rootLayout;

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("AddressApp");
        loadLayouts();
        Scene scene = new Scene(rootLayout);
        stage.setScene(scene);
        stage.show();
    }

    private void loadLayouts(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(APP_XML));
            rootLayout = loader.load();

            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(MainApp.class.getResource(USER_MENU_XML));
            menu = loader2.load();

            rootLayout.setCenter(menu);

            PersonOverviewController controller = loader2.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MainApp() {
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }


    public static void main(String[] args) {
        launch();
    }
}