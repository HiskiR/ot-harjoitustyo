package metuse.ui;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metuse.dao.SQLUserDao;
import metuse.dao.Database;
import metuse.domain.MetuseService;

public class MetuseUi extends Application {

    private Scene registerScene;
    private Scene loginScene;
    private Scene mainScene;
    private Label menuLabel = new Label();
    private MetuseService metuseService;
    private Stage primaryStage;
    private Label message;
    
    @Override
    public void init() throws Exception {
        Database db = new Database();
        SQLUserDao uDao = new SQLUserDao(db);
        metuseService = new MetuseService(uDao);
    }

    @Override
    public void start(Stage primaryStage) {
        message = new Label();
        this.primaryStage = primaryStage;
        createLoginScene();
        createRegisterScene();
        createMainScene();
        primaryStage.setTitle("MeTuSe");
        primaryStage.setScene(loginScene);
        primaryStage.show();

    }

    public void createLoginScene() {
        VBox loginPane = new VBox(20);
        HBox inputPane = new HBox(20);
        loginPane.setPadding(new Insets(20));
        Label loginLabel = new Label("username");
        TextField usernameInput = new TextField();

        inputPane.getChildren().addAll(loginLabel, usernameInput);

        Button loginButton = new Button("login");
        Button createButton = new Button("create new user");
        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            menuLabel.setText(username + " logged in");
            if (metuseService.login(username)) {
                message.setText("");
                primaryStage.setScene(mainScene);
                usernameInput.setText("");
            } else {
                message.setText("user does not exist");
                message.setTextFill(Color.RED);
            }
        });

        createButton.setOnAction(e -> {
            usernameInput.setText("");
            primaryStage.setScene(registerScene);
        });

        loginPane.getChildren()
                .addAll(message, inputPane, loginButton, createButton);

        loginScene = new Scene(loginPane, 500, 350);
    }

    public void createRegisterScene() {
        VBox newUserPane = new VBox(20);

        HBox newUsernamePane = new HBox(20);
        newUsernamePane.setPadding(new Insets(20));
        TextField newUsernameInput = new TextField();
        Label newUsernameLabel = new Label("username");
        newUsernameLabel.setPrefWidth(100);
        newUsernamePane.getChildren().addAll(newUsernameLabel, newUsernameInput);

        HBox newNamePane = new HBox(20);
        newNamePane.setPadding(new Insets(20));
        TextField newNameInput = new TextField();
        Label newNameLabel = new Label("name");
        newNameLabel.setPrefWidth(100);
        newNamePane.getChildren().addAll(newNameLabel, newNameInput);

        Button createNewUserButton = new Button("create");
        createNewUserButton.setPadding(new Insets(15));

        createNewUserButton.setOnAction(e -> {
            String username = newUsernameInput.getText();
            String name = newNameInput.getText();

            if (username.length() < 3 || name.length() < 3) {
                message.setText("username or name too short");
                message.setTextFill(Color.RED);
            } else try {
                if (metuseService.createUser(name, username)) {
                    message.setText("new user created");
                    message.setTextFill(Color.GREEN);
                    primaryStage.setScene(loginScene);
                } else {
                    message.setText("username has to be unique");
                    message.setTextFill(Color.RED);

                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        });
        newUserPane.getChildren().addAll(message, newUsernamePane, newNamePane, createNewUserButton);

        registerScene = new Scene(newUserPane, 500, 350);
    }
    
    public void createMainScene() {
        ScrollPane todoScollbar = new ScrollPane();       
        BorderPane mainPane = new BorderPane(todoScollbar);
        mainScene = new Scene(mainPane, 500, 350);
                
        HBox menuPane = new HBox(20);    
        Region menuSpacer = new Region();
        HBox.setHgrow(menuSpacer, Priority.ALWAYS);
        Button logoutButton = new Button("logout");      
        menuPane.getChildren().addAll(menuLabel, menuSpacer, logoutButton);
        logoutButton.setOnAction(e->{
            metuseService.logout();
            primaryStage.setScene(loginScene);
        });        
        
        mainPane.setTop(menuPane); 
    }

    @Override
    public void stop() {
        System.out.println("Bye");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
