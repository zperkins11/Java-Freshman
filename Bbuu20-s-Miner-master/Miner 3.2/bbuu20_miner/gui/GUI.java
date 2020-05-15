package scripts.bbuu20_miner.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.tribot.api.Timing;
import scripts.bbuu20_miner.data.Finals;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GUI extends Application {
	
	private GUIController controller;

	private Stage stage;
	private Scene scene;

	private boolean isOpen = false;
	
	private String fxml;
	
	public GUI(String fxml) {
		
		this.fxml = fxml;
		
		// We have to start the JFX thread from the EDT otherwise tribot will end it.
		SwingUtilities.invokeLater(() -> {

			new JFXPanel(); // we have to init the toolkit

			Platform.runLater(() -> {
				try {
					final Stage stage = new Stage();

					start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});

		waitForInit();
	}


	public Scene getScene() {
		return this.scene;
	}

	public Stage getStage() {
		return this.stage;
	}

	/**
	 * The main entry point for all JavaFX applications. The start method is called
	 * after the init method has returned, and after the system is ready for the
	 * application to begin running.
	 * <p>
	 * <p>
	 * NOTE: This method is called on the JavaFX Application Thread.
	 * </p>
	 *
	 * @param stage
	 *            the primary stage for this application, onto which the application
	 *            scene can be set. The primary stage will be embedded in the
	 *            browser if the application was launched as an applet. Applications
	 *            may create other stages, if needed, but they will not be primary
	 *            stages and will not be embedded in the browser.
	 */
	@Override
	public void start(Stage stage) throws Exception {

		File bbuu20Directory = new File(Finals.PATH_TO_BBUU20_FOLDER);
		File guiStyleSheet = new File(Finals.PATH_TO_BBUU20_FOLDER + "/gui.css");

		this.stage = stage;
		
		stage.setTitle("Bbuu20's AIO Miner");

		stage.setAlwaysOnTop(false);

		Platform.setImplicitExit(false);

		FXMLLoader loader = new FXMLLoader();

		loader.setClassLoader(this.getClass().getClassLoader());
		
		Parent box = loader.load(new ByteArrayInputStream(fxml.getBytes()));
		
		controller = loader.getController();
		
		controller.setGUI(this);

		scene = new Scene(box);
		
		scene.setFill(Color.TRANSPARENT);

		if (!bbuu20Directory.exists()) {
			bbuu20Directory.mkdirs();
		}

		if (!guiStyleSheet.exists()) {
			guiStyleSheet.createNewFile();
			writeGuiStyleSheet(guiStyleSheet);
		}

		scene.getStylesheets().add(guiStyleSheet.toURI().toURL().toExternalForm());

		stage.getIcons().add(new Image("https://i.imgur.com/wBTvlNv.png"));

		stage.setScene(scene);
		
		stage.setResizable(false);

	}
	
    @SuppressWarnings("unchecked")
	public <T extends GUIController> T getController() {

        return (T) this.controller;

    }

	public void show() {

		if (stage == null)
			return;

		isOpen = true;

		Platform.runLater(() -> stage.show());
	}

	public void close() {

		if (stage == null)
			return;

		isOpen = false;

		Platform.runLater(() -> stage.close());
	}

	public boolean isOpen() {
		return isOpen;
	}

	private void waitForInit() {
		Timing.waitCondition(() -> stage != null, 5000);
	}

	private void writeGuiStyleSheet(File styleSheetPath) throws IOException {
		FileWriter styleSheetWriter = new FileWriter(styleSheetPath);

		styleSheetWriter.write("/*\n" +
				" * This is an adjustment of the original modena.css for a consistent dark theme.\n" +
				" * Original modena.css here: https://gist.github.com/maxd/63691840fc372f22f470.\n" +
				" */\n" +
				"\n" +
				"/* Redefine base colors */\n" +
				".root {\n" +
				"    -fx-base: rgb(50, 50, 50);\n" +
				"    -fx-background: rgb(50, 50, 50);\n" +
				"\n" +
				"    /* make controls (buttons, thumb, etc.) slightly lighter */\n" +
				"    -fx-color: derive(-fx-base, 10%);\n" +
				"\n" +
				"    /* text fields and table rows background */\n" +
				"    -fx-control-inner-background: rgb(20, 20, 20);\n" +
				"    /* version of -fx-control-inner-background for alternative rows */\n" +
				"    -fx-control-inner-background-alt: derive(-fx-control-inner-background, 2.5%);\n" +
				"\n" +
				"    /* text colors depending on background's brightness */\n" +
				"    -fx-light-text-color: rgb(220, 220, 220);\n" +
				"    -fx-mid-text-color: rgb(100, 100, 100);\n" +
				"    -fx-dark-text-color: rgb(20, 20, 20);\n" +
				"\n" +
				"    /* A bright blue for highlighting/accenting objects.  For example: selected\n" +
				"     * text; selected items in menus, lists, trees, and tables; progress bars */\n" +
				"    -fx-accent: rgb(0, 80, 100);\n" +
				"\n" +
				"    /* color of non-focused yet selected elements */\n" +
				"    -fx-selection-bar-non-focused: rgb(50, 50, 50);\n" +
				"}\n" +
				"\n" +
				"/* Fix derived prompt color for text fields */\n" +
				".text-input {\n" +
				"    -fx-prompt-text-fill: derive(-fx-control-inner-background, +50%);\n" +
				"}\n" +
				"\n" +
				"/* Keep prompt invisible when focused (above color fix overrides it) */\n" +
				".text-input:focused {\n" +
				"    -fx-prompt-text-fill: transparent;\n" +
				"}\n" +
				"\n" +
				"/* Fix scroll bar buttons arrows colors */\n" +
				".scroll-bar > .increment-button > .increment-arrow,\n" +
				".scroll-bar > .decrement-button > .decrement-arrow {\n" +
				"    -fx-background-color: -fx-mark-highlight-color, rgb(220, 220, 220);\n" +
				"}\n" +
				"\n" +
				".scroll-bar > .increment-button:hover > .increment-arrow,\n" +
				".scroll-bar > .decrement-button:hover > .decrement-arrow {\n" +
				"    -fx-background-color: -fx-mark-highlight-color, rgb(240, 240, 240);\n" +
				"}\n" +
				"\n" +
				".scroll-bar > .increment-button:pressed > .increment-arrow,\n" +
				".scroll-bar > .decrement-button:pressed > .decrement-arrow {\n" +
				"    -fx-background-color: -fx-mark-highlight-color, rgb(255, 255, 255);\n" +
				"}");
		styleSheetWriter.close();
	}
}
