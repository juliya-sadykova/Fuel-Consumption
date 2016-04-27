/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuelconsumption;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Some
 */
public class FuelConsumption extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Расчет расхода топлива");

        Parent root = FXMLLoader.load(getClass().getResource("FuelConsumption.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
<?xml version="1.0" encoding="UTF-8"?>

<?import java.lang.*?>
<?import java.util.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.paint.*?>
<?import javafx.scene.text.*?>

<AnchorPane id="AnchorPane" maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns:fx="http://javafx.com/fxml/1" xmlns="http://javafx.com/javafx/2.2" fx:controller="fuelconsumption.FuelConsumptionController">
  <children>
    <VBox layoutX="-10.0" layoutY="5.0" prefHeight="400.0" prefWidth="600.0">
      <children>
        <GridPane>
          <children>
            <Label fx:id="lbl_Distance" alignment="CENTER_RIGHT" prefWidth="300.0" text="Расстояние пройдено" GridPane.columnIndex="0" GridPane.rowIndex="0">
              <GridPane.margin>
                <Insets right="10.0" fx:id="x1" />
              </GridPane.margin>
            </Label>
            <Label fx:id="lbl_Fuel" alignment="CENTER_RIGHT" prefWidth="300.0" text="Топливо израсходовано" GridPane.columnIndex="0" GridPane.margin="$x1" GridPane.rowIndex="1" />
            <TextField fx:id="text_Distance" prefWidth="200.0" GridPane.columnIndex="1" GridPane.rowIndex="0">
              <GridPane.margin>
                <Insets left="10.0" right="10.0" fx:id="x2" />
              </GridPane.margin>
            </TextField>
            <TextField fx:id="text_Fuel" prefWidth="200.0" GridPane.columnIndex="1" GridPane.margin="$x2" GridPane.rowIndex="1" />
            <Label fx:id="lbl_MeasureMethod" alignment="CENTER_RIGHT" prefWidth="300.0" text="Способ учета" GridPane.columnIndex="0" GridPane.margin="$x1" GridPane.rowIndex="2" />
            <HBox alignment="CENTER_LEFT" prefHeight="100.0" prefWidth="200.0" spacing="20.0" GridPane.columnIndex="1" GridPane.rowIndex="2">
              <children>
                <RadioButton fx:id="rb_MeasureMetric" mnemonicParsing="false" selected="true" text="метрический">
                  <toggleGroup>
                    <ToggleGroup fx:id="group_Measure" />
                  </toggleGroup>
                </RadioButton>
                <RadioButton fx:id="rb_MeasureBritain" mnemonicParsing="false" text="британский" toggleGroup="$group_Measure" />
              </children>
              <padding>
                <Insets left="10.0" fx:id="x3" />
              </padding>
            </HBox>
          </children>
          <columnConstraints>
            <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
            <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
          </columnConstraints>
          <rowConstraints>
            <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
            <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
            <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
          </rowConstraints>
        </GridPane>
        <GridPane>
          <children>
            <Label fx:id="lbl_ConsumptionTitle" alignment="CENTER_RIGHT" prefWidth="300.0" text="Расход топлива" GridPane.columnIndex="0" GridPane.margin="$x1" GridPane.rowIndex="0">
              <font>
                <Font name="System Bold" size="11.0" />
              </font>
            </Label>
            <Label fx:id="lbl_Consumption" prefWidth="300.0" text="(пока не рассчитан)" GridPane.columnIndex="1" GridPane.margin="$x3" GridPane.rowIndex="0" />
          </children>
          <columnConstraints>
            <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
            <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
          </columnConstraints>
          <rowConstraints>
            <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
          </rowConstraints>
        </GridPane>
        <Button fx:id="btn_Compute" defaultButton="true" mnemonicParsing="false" onAction="#onClickMethod" text="Рассчитать">
          <VBox.margin>
            <Insets left="20.0" />
          </VBox.margin>
        </Button>
      </children>
    </VBox>
  </children>
</AnchorPane>
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuelconsumption;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Some
 */
public class FuelConsumptionController implements Initializable {
    
    private boolean isMethodMetric;
    private double Distance;
    private double Fuel;
    private double Consumption;
    private String suffix;
    
    @FXML
    private Label lbl_Distance;
    @FXML
    private Insets x1;
    @FXML
    private Label lbl_Fuel;
    @FXML
    private TextField text_Distance;
    @FXML
    private Insets x2;
    @FXML
    private TextField text_Fuel;
    @FXML
    private Label lbl_MeasureMethod;
    @FXML
    private RadioButton rb_MeasureMetric;
    @FXML
    private RadioButton rb_MeasureBritain;
    @FXML
    private Insets x3;
    @FXML
    private Label lbl_ConsumptionTitle;
    @FXML
    private Label lbl_Consumption;
    @FXML
    private Button btn_Compute;
    @FXML
    private ToggleGroup group_Measure;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isMethodMetric = true;
        Distance = 1.0;
        Fuel = 1.0;
        Consumption = 1.0;
    }    
    
    public void onClickMethod() {
        // определить метод расчета
        isMethodMetric = rb_MeasureMetric.isSelected();
        
        // получить значения для расчета
        Distance =  Double.parseDouble(text_Distance.getText());
        Fuel = Double.parseDouble(text_Fuel.getText());
        
        if (isMethodMetric) 
        {
            Consumption = Fuel / Distance * 100;
            suffix = "л на 100 км";
        }
        else
        {
            Consumption = Distance / Fuel;
            suffix = "миль на галлон";
        }
        String Result = "";
        Result = Result + Consumption + " " + suffix;
        
        lbl_Consumption.setText(Result);
    }

}
