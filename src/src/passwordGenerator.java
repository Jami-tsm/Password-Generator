import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.input.ClipboardContent;
import java.util.Objects;


/**
 * Application interface for simple password generator
 * @Author: Jameson Baker
 * @DateStarted: 05.13.2024
 */
public class passwordGenerator extends Application {
    private Label label;
    private int passLen;
    private boolean includeSpecials;
    private final simplePasswordGenerator generator = new simplePasswordGenerator();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        FlowPane pane = new FlowPane();
        this.label = new Label("Password Generator");
        label.setFont(new Font("Arial", 20));
        pane.setHgap(20);
        pane.setVgap(20);
        pane.setMaxSize(500,200);
        pane.setMinSize(500,200 );
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(this.label);
        root.setCenter(pane);

        Label question = new Label( "Length of Password: ");
        TextField lenPass = new TextField();
        FlowPane length = new FlowPane();
        length.setAlignment(Pos.CENTER);
        length.setHgap(10);
        length.setVgap(10);
        length.getChildren().addAll(question,lenPass);
        root.setTop(length);
        VBox buttons = new VBox();
        CheckBox specialCharsCheck = new CheckBox("Include Special Characters");
        buttons.getChildren().add(specialCharsCheck);
        Button generate = new Button("Generate");
        generate.setOnAction(event -> {
            this.includeSpecials = specialCharsCheck.isSelected();
            this.passLen = Integer.parseInt(lenPass.getText());
            this.label.setText(generator.generatePassword(this.passLen,this.includeSpecials));
            primaryStage.sizeToScene();
        });
        Button copy = new Button("Copy to Clipboard");
        copy.setOnAction(event -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(this.label.getText());
            clipboard.setContent(content);
        });
        buttons.getChildren().add(copy);
        buttons.getChildren().add(generate);
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.CENTER);
        root.setBottom(buttons);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password Generator");
        primaryStage.getIcons().add(
                new Image(Objects.requireNonNull(passwordGenerator.class.getResourceAsStream("lock.png"))));
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
