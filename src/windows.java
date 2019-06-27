import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class windows extends Application{
    Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        HBox last = new HBox();
        Label user = new Label("User");
        Label password = new Label("password");
        Label name = new Label("name");
        TextField userInput = new TextField("");
        TextField passwordInput = new TextField("");
        TextField nameInput = new TextField("");
        first.getChildren().addAll(user,userInput);
        second.getChildren().addAll(password, passwordInput);
        third.getChildren().addAll(name,nameInput);
        Button update = new Button("update");
        Button load = new Button("load");
        Button delete = new Button("delete");
        update.setOnAction(event -> control.update(nameInput.getText(),userInput.getText(),passwordInput.getText()));
        load.setOnAction(event -> {String[] output = control.load(nameInput.getText());userInput.setText(output[0]);passwordInput.setText(output[1]);});
        delete.setOnAction(event -> control.delete(nameInput.getText()));
        last.getChildren().addAll(update,load,delete);
        vBox.getChildren().addAll(first,second,third,last);
        Scene scene = new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("password remember");
        primaryStage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
