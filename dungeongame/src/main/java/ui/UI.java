
package ui;


import dg.Dungeon;
import dg.Player;
import dg.Room;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class UI extends Application {

    private Stage stage;

    Player p = new Player();
    Dungeon dung = new Dungeon();
    private final int tileSize = 128;
    Room[][] rooms = dung.floor();
    Label label1 = new Label("Health : " + p.getHealth());
    Label label2 = new Label("Testi");
    int curroom = 0;
    Label vicLabel = new Label("You won");
    Font font1 = new Font("SansSerif", 128);

    GridPane gridPane = new GridPane();

    BorderPane bp = new BorderPane();

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        gridPane.setStyle("-fx-background-color: blue;");
        Label label1 = new Label("Health : " + p.getHealth());
        Label label2 = new Label("Testi");

        // gridPane.add(label3, 2, 0);
        // gridPane.add(label4, 3, 0);
        // gridPane.add(label5, 4, 0);

        update(p);

        Scene scene = new Scene(gridPane);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        curroom = dung.move(1);
                        update(p);
                        break;
                    case RIGHT:
                        curroom = dung.move(2);
                        update(p);
                        break;
                    case DOWN:
                        curroom = dung.move(3);
                        update(p);
                        break;
                    case LEFT:
                        curroom = dung.move(4);
                        update(p);
                        break;
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void update(Player p) {
        gridPane.getChildren().clear();
        for (int y = 0; y < dung.floor().length; y++) {
            for (int x = 0; x < dung.floor().length; x++) {
                ImageView imageView = new ImageView(rooms[y][x].getImage());
                imageView.setFitWidth(tileSize);
                imageView.setFitHeight(tileSize);
                gridPane.add(imageView, x, y + 1);
            }
        }
        p.healthChange(curroom);
        label1.setText("Health: " + p.getHealth());
        if (p.getHealth() <= 0) {
            reset();
        }
        gridPane.add(label1, 0, 0);
        gridPane.add(label2, 1, 0);
        if (curroom == 5) {
            System.out.println("WTF");
            victory();
        }
    }

    public void reset() {
        dung.reset();
        rooms = dung.floor();
        p = new Player();
        curroom = 0;
        update(p);
    }

    public void victory() {
        vicLabel.setFont(font1);
        bp.setPrefSize(640, 640);
        bp.setCenter(vicLabel);

        this.stage.setScene(new Scene(bp));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
