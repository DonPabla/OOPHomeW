package org.example.demogui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label label1;
    @FXML
    private Label Result;


    @FXML
    private TextField text1;
    @FXML
    private TextField text2;

    @FXML
    private void clearFields() {
        text1.clear();
        text2.clear();
        label1.setText("");
        Result.setText("");
    }

    @FXML
    private void closeItem() {
        Platform.exit();
    }

    @FXML
    private void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Как использовать");
        alert.setContentText("Введите вес (в кг, например 68, ввожу как 68).\n \n"
                + "Введите рост (в метрах, например 168 см, ввожу как 1.68).\n \n"
                + "Затем нажмите на кнопку 'Calculate BMI' для получения результата.");
        alert.showAndWait();
    }




    @FXML
    private void onClickButton() {
        try {
            String val1 = text1.getText();
            String val2 = text2.getText();

            // Преобразуем строки в числа
            double weight = Double.parseDouble(val1);
            double height = Double.parseDouble(val2);

            // Вычисляем BMI по формуле: BMI = weight / (height^2)
            double bmi = weight / Math.pow(height, 2);

            // Устанавливаем результат в label1
            label1.setText(String.format("BMI: %.2f", bmi));
            if (bmi < 18.5) {
                Result.setText("Underweight");
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                Result.setText("Normal");
            } else if (bmi >= 25 && bmi <= 29.9) {
                Result.setText("Overweight");
            } else if (bmi >= 30) {
                Result.setText("Obese");
            }

        } catch (NumberFormatException e) {
            // В случае ошибки преобразования
            label1.setText("Введите правильные числа");
            Result.setText("");
        }
    }

}


