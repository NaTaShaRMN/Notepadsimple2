
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Controller controller = new Controller();
		MenuBar menuBar = new MenuBar(); // creat menubar
		// creat menu
		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("Edit");
		Menu helpMenu = new Menu("Help");
		// creat menu item
		MenuItem newItem = new MenuItem("New");
		MenuItem saveItem = new MenuItem("Save");
		MenuItem openItem = new MenuItem("Open");
		MenuItem exitItem = new MenuItem("Exit");
		//set keytat cho cac phim
				exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		// set event for menu item exit
		exitItem.setOnAction(event -> {
			System.exit(0);
		});
		
		MenuItem copyItem = new MenuItem("Copy");
		MenuItem pasteItem = new MenuItem("Paste");
		// add to menu
		fileMenu.getItems().addAll(newItem,saveItem,openItem,exitItem);
		editMenu.getItems().addAll(copyItem,pasteItem);
		//add menu to menubar
		menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu);
		
		// Text area
		TextArea textArea = new TextArea();
		
		textArea.setPrefSize(600, 375);
		//set event for menu item save
				saveItem.setOnAction(event -> {
					String txt = textArea.getText();
					controller.Savefile(txt);
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Messages");
					alert.show();
				});
		// set event for newItem
		newItem.setOnAction(event -> {
			textArea.clear();
		});
		// script
		BorderPane root = new BorderPane();
		root.setTop(menuBar);
		root.setBottom(textArea);
		Scene scene = new Scene(root, 600,400);
		
		primaryStage.setTitle("Doan xem");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
