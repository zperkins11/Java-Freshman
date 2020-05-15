package scripts.bbuu20_miner.gui;

import com.allatori.annotations.DoNotRename;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;
import org.tribot.util.Util;
import scripts.bbuu20_miner.data.Finals;
import scripts.bbuu20_miner.data.PlayerInfo;
import scripts.bbuu20_api.enums.MainTask;
import scripts.bbuu20_api.enums.Pick;
import scripts.bbuu20_api.enums.Rock;
import scripts.bbuu20_miner.util.MinerProfile;
import scripts.bbuu20_miner.util.ProgressiveTask;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

@DoNotRename
public class GUIController implements Initializable {

    private GUI gui;

	private final File PATH_TO_PROFILES = new File(Util.getWorkingDirectory().getAbsolutePath() + "/bbuu20/miner/");

	public void setGUI(GUI gui) {
		this.gui = gui;
	}

	public GUI getGUI() {
		return this.gui;
	}


	@DoNotRename @FXML
	public TabPane tabPane;

	@DoNotRename @FXML
	public void traditionalTabChanged() {
		if (startMiningButton != null) {
			PlayerInfo.INSTANCE.setSelectedTask(MainTask.TRADITIONAL_MINING);
			startMiningButton.setText("Start Traditional Mining");
			startMiningButton.setDisable(false);
		}
	}

	@DoNotRename @FXML
	public void progressiveTabChanged() {
		if (startMiningButton != null) {
			PlayerInfo.INSTANCE.setSelectedTask(MainTask.PROGRESSIVE_MINING);
			startMiningButton.setText("Start Progressive Mining");
			startMiningButton.setDisable(false);
		}
	}

	@DoNotRename @FXML
	public void antibanTabChanged() {
		if (startMiningButton != null) {
			startMiningButton.setDisable(true);
		}
	}

	@DoNotRename @FXML
	public void saveLoadTabChanged() {
		if (startMiningButton != null) {
			startMiningButton.setDisable(true);
		}
	}


	@DoNotRename @FXML
	public Button tribotButton;

	@DoNotRename @FXML
	public ImageView tribotImage;

	@DoNotRename @FXML
	public Button discordButton;

	@DoNotRename @FXML
	public ImageView discordImage;

	@DoNotRename @FXML
	public void tribotButtonPressed() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URL("https://tribot.org/forums/topic/81450-bbuu20s-aio-miner-beta-3-tick-mining-world-hopping-abc2-level-10/").toURI());
	}

	@DoNotRename @FXML
	public void discordButtonPressed() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URL("https://discord.gg/nF7fsjx").toURI());
	}


	private ColorAdjust brightenImage = new ColorAdjust();
	private ColorAdjust darkenImage = new ColorAdjust();


	@DoNotRename @FXML
	public ImageView copperOreImage;

	@DoNotRename @FXML
	public void copperMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.COPPER)) {
			selectedRocksListView.getItems().add(Rock.COPPER);
			copperOreImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.COPPER);
			copperOreImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView tinOreImage;

	@DoNotRename @FXML
	public void tinMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.TIN)) {
			selectedRocksListView.getItems().add(Rock.TIN);
			tinOreImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.TIN);
			tinOreImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView clayImage;

	@DoNotRename @FXML
	public void clayMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.CLAY)) {
			selectedRocksListView.getItems().add(Rock.CLAY);
			clayImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.CLAY);
			clayImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView limestoneImage;

	@DoNotRename @FXML
	public void limestoneMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.LIMESTONE)) {
			selectedRocksListView.getItems().add(Rock.LIMESTONE);
			limestoneImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.LIMESTONE);
			limestoneImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView ironOreImage;

	@DoNotRename @FXML
	public void ironMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.IRON)) {
			selectedRocksListView.getItems().add(Rock.IRON);
			ironOreImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.IRON);
			ironOreImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView silverOreImage;

	@DoNotRename @FXML
	public void silverMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.SILVER)) {
			selectedRocksListView.getItems().add(Rock.SILVER);
			silverOreImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.SILVER);
			silverOreImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView coalImage;

	@DoNotRename @FXML
	public void coalMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.COAL)) {
			selectedRocksListView.getItems().add(Rock.COAL);
			coalImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.COAL);
			coalImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView sandstoneImage;

	@DoNotRename @FXML
	public void sandstoneMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.SANDSTONE)) {
			selectedRocksListView.getItems().add(Rock.SANDSTONE);
			sandstoneImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.SANDSTONE);
			sandstoneImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView goldOreImage;

	@DoNotRename @FXML
	public void goldMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.GOLD)) {
			selectedRocksListView.getItems().add(Rock.GOLD);
			goldOreImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.GOLD);
			goldOreImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView gemImage;

	@DoNotRename @FXML
	public void gemMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.GEM)) {
			selectedRocksListView.getItems().add(Rock.GEM);
			gemImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.GEM);
			gemImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView graniteImage;

	@DoNotRename @FXML
	public void graniteMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.GRANITE)) {
			selectedRocksListView.getItems().add(Rock.GRANITE);
			graniteImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.GRANITE);
			graniteImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView mithrilOreImage;

	@DoNotRename @FXML
	public void mithrilMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.MITHRIL)) {
			selectedRocksListView.getItems().add(Rock.MITHRIL);
			mithrilOreImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.MITHRIL);
			mithrilOreImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView adamantiteOreImage;

	@DoNotRename @FXML
	public void adamantiteMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.ADAMANTITE)) {
			selectedRocksListView.getItems().add(Rock.ADAMANTITE);
			adamantiteOreImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.ADAMANTITE);
			adamantiteOreImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView runiteOreImage;

	@DoNotRename @FXML
	public void runiteMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.RUNITE)) {
			selectedRocksListView.getItems().add(Rock.RUNITE);
			runiteOreImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.RUNITE);
			runiteOreImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView amethystImage;

	@DoNotRename @FXML
	public void amethystMouseClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.AMETHYST)) {
			selectedRocksListView.getItems().add(Rock.AMETHYST);
			amethystImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.AMETHYST);
			amethystImage.setEffect(brightenImage);
		}
	}

	@DoNotRename @FXML
	public ImageView essenceImage;

	@DoNotRename @FXML
	public void essenceImageClicked() {
		if (!selectedRocksListView.getItems().contains(Rock.PURE_ESSENCE)) {
			selectedRocksListView.getItems().add(Rock.PURE_ESSENCE);
			essenceImage.setEffect(darkenImage);
		}
		else {
			selectedRocksListView.getItems().remove(Rock.PURE_ESSENCE);
			essenceImage.setEffect(brightenImage);
		}
	}


	@DoNotRename @FXML
	public ListView<Rock> selectedRocksListView;

	@DoNotRename @FXML
	public Spinner<Integer> tileSpinnerX;

	@DoNotRename @FXML
	public Spinner<Integer> tileSpinnerY;

	@DoNotRename @FXML
	public Spinner<Integer> radiusSpinner;

	@DoNotRename @FXML
	public CheckBox walkToTileCheckBox;

	@DoNotRename @FXML
	public CheckBox bankCheckBox;

	@DoNotRename @FXML
	public CheckBox hopWorldsCheckBox;

	@DoNotRename @FXML
	public CheckBox membersCheckBox;

	@DoNotRename @FXML
	public CheckBox endFullInvCheckBox;

	@DoNotRename @FXML
	public void walkToTileClicked() {
		tileSpinnerX.setDisable(!tileSpinnerX.isDisabled());
		tileSpinnerY.setDisable(!tileSpinnerY.isDisabled());
	}

	@DoNotRename @FXML
	public ChoiceBox<Pick> picksChoiceBox;

	@DoNotRename @FXML
	public CheckBox drawPaintCheckBox;

	@DoNotRename @FXML
	public CheckBox drawDebugCheckBox;

	@DoNotRename @FXML
	public Button startMiningButton;

	@DoNotRename @FXML
	public void startMiningButtonPressed() {
		if (!canInitializeVars()) {
			return;
		}
		PlayerInfo.INSTANCE.getGui().close();
	}

	@DoNotRename @FXML
	public CheckBox useLevelRangeCheckBox;

	@DoNotRename @FXML
	public Spinner<Integer> highLevelSpinner;

	@DoNotRename @FXML
	public Spinner<Integer> lowLevelSpinner;

	@DoNotRename @FXML
	public void useLevelRangeClicked() {
		lowLevelSpinner.setDisable(!lowLevelSpinner.isDisabled());
		highLevelSpinner.setDisable(!highLevelSpinner.isDisabled());
	}

	@DoNotRename @FXML
	public TextField taskTextField;

	@DoNotRename @FXML
	public Button addTaskButton;

	@DoNotRename @FXML
	public void addTaskButtonPressed() {
		ProgressiveTask taskToAdd;
		if (!tileSpinnerX.isDisabled() && !tileSpinnerY.isDisabled()) {
			taskToAdd = new ProgressiveTask(taskTextField.getText(), selectedRocksListView.getItems(), picksChoiceBox.getSelectionModel().getSelectedItem(), radiusSpinner.getValue(), lowLevelSpinner.getValue(), highLevelSpinner.getValue(), endFullInvCheckBox.isSelected(), bankCheckBox.isSelected(), hopWorldsCheckBox.isSelected(), membersCheckBox.isSelected(), walkToTileCheckBox.isSelected(), new RSTile(tileSpinnerX.getValue(), tileSpinnerY.getValue()));
		}
		else {
			taskToAdd = new ProgressiveTask(taskTextField.getText(), selectedRocksListView.getItems(), picksChoiceBox.getSelectionModel().getSelectedItem(), radiusSpinner.getValue(), lowLevelSpinner.getValue(), highLevelSpinner.getValue(), endFullInvCheckBox.isSelected(), bankCheckBox.isSelected(), hopWorldsCheckBox.isSelected(), membersCheckBox.isSelected(), walkToTileCheckBox.isSelected(), new RSTile(0, 0));
		}
		selectedTaskListView.getItems().add(taskToAdd);
	}


	@DoNotRename @FXML
	public ListView<ProgressiveTask> selectedTaskListView;


	@DoNotRename @FXML
	public Button deselectTaskButton;

	@DoNotRename @FXML
	public void deselectTaskButtonPressed() {
		ProgressiveTask taskToDeselect = selectedTaskListView.getSelectionModel().getSelectedItem();
		if (taskToDeselect != null) {
			selectedTaskListView.getItems().remove(taskToDeselect);
		}
	}


	@DoNotRename @FXML
	public Slider reactionTimeSlider;

	@DoNotRename @FXML
	public Slider fatigueRateSlider;

	@DoNotRename @FXML
	public CheckBox hopPlayerCountCheckBox;

	@DoNotRename @FXML
	public CheckBox hopOnChatCheckBox;

	@DoNotRename @FXML
	public CheckBox antiPkCheckBox;


	@DoNotRename @FXML
	public TextField profileTextField;

	@DoNotRename @FXML
	public Button saveProfileButton;

	@DoNotRename @FXML
	public ListView<MinerProfile> profilesListView;

	@DoNotRename @FXML
	public Button loadProfileButton;

	@DoNotRename @FXML
	public Button deleteProfileButton;

	@DoNotRename @FXML
	public void saveProfileButtonPressed() {
		MinerProfile minerProfile = new MinerProfile(profileTextField.getText(), endFullInvCheckBox.isSelected(), membersCheckBox.isSelected(), bankCheckBox.isSelected(), hopWorldsCheckBox.isSelected(), radiusSpinner.getValue(), picksChoiceBox.getSelectionModel().getSelectedItem(), selectedRocksListView.getItems(), new RSTile(tileSpinnerX.getValue(), tileSpinnerY.getValue()), lowLevelSpinner.getValue(), highLevelSpinner.getValue(), selectedTaskListView.getItems(), hopPlayerCountCheckBox.isSelected(), hopOnChatCheckBox.isSelected(), antiPkCheckBox.isSelected(), drawPaintCheckBox.isSelected(), drawDebugCheckBox.isSelected(), reactionTimeSlider.getValue(), fatigueRateSlider.getValue());
		try {
			if (minerProfile.getProfileName().equals("") || profilesListView.getItems().contains(minerProfile)) {
				System.out.println("Profile wasn't created");
				return;
			}
			if (!minerProfile.saveMinerProfile()) {
				System.out.println("Profile wasn't created");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		profilesListView.getItems().add(minerProfile);
	}

	@DoNotRename @FXML
	public void loadProfileButtonPressed() {
		MinerProfile minerProfile = profilesListView.getSelectionModel().getSelectedItem();
		if (minerProfile != null) {
			loadProfile(minerProfile);
		}
	}

	@DoNotRename @FXML
	public void deleteProfileButtonPressed() throws IOException {
		for (MinerProfile currentProfile : profilesListView.getItems()) {
			if (currentProfile.equals(profilesListView.getSelectionModel().getSelectedItem())) {
				currentProfile.deleteMinerProfile(new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + currentProfile.getProfileName()));
				profilesListView.getItems().remove(currentProfile);
				return;
			}
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tribotImage.setImage(new Image("https://i.imgur.com/KL7M0Ie.png"));
		discordImage.setImage(new Image("https://i.imgur.com/MzWqh1Z.png"));

		copperOreImage.setImage(new Image("https://i.imgur.com/W4u25Cg.png"));
		tinOreImage.setImage(new Image("https://i.imgur.com/MKowMjI.png"));
		clayImage.setImage(new Image("https://i.imgur.com/8juqenJ.png"));
		limestoneImage.setImage(new Image("https://i.imgur.com/1mQWkRD.png"));
		ironOreImage.setImage(new Image("https://i.imgur.com/ON9eeHd.png"));
		silverOreImage.setImage(new Image("https://i.imgur.com/xynYpRG.png"));
		coalImage.setImage(new Image("https://i.imgur.com/kU97uUG.png"));
		sandstoneImage.setImage(new Image("https://i.imgur.com/CfJPSKc.png"));
		goldOreImage.setImage(new Image("https://i.imgur.com/N2uTpxa.png"));
		gemImage.setImage(new Image("https://i.imgur.com/2QI7UWf.png"));
		graniteImage.setImage(new Image("https://i.imgur.com/r0HaTAR.png"));
		mithrilOreImage.setImage(new Image("https://i.imgur.com/wQlOD8P.png"));
		adamantiteOreImage.setImage(new Image("https://i.imgur.com/1Kq39qc.png"));
		runiteOreImage.setImage(new Image("https://i.imgur.com/M02GIoT.png"));
		amethystImage.setImage(new Image("https://i.imgur.com/0L5NUMn.png"));
		essenceImage.setImage(new Image("https://i.imgur.com/SBYYN2w.png"));

		tileSpinnerX.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 0));
		tileSpinnerY.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 0));
		radiusSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 25, 1));
		lowLevelSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, 1));
		highLevelSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100, 100));

		for (Pick pick : Pick.values()) {
			picksChoiceBox.getItems().add(pick);
		}
		picksChoiceBox.getSelectionModel().select(Pick.ANY_PICK);
		if (PlayerInfo.INSTANCE.getShouldShowGui()) {
			PlayerInfo.INSTANCE.setSelectedTask(MainTask.TRADITIONAL_MINING);
		}
		tileSpinnerX.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				tileSpinnerX.increment(0);
			}
		});
		tileSpinnerY.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				tileSpinnerY.increment(0);
			}
		});
		lowLevelSpinner.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				lowLevelSpinner.increment(0);
			}
		});
		highLevelSpinner.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				highLevelSpinner.increment(0);
			}
		});

		File pathToProfiles = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner");

		if (!pathToProfiles.exists()) {
			pathToProfiles.mkdirs();
		}

		File[] profilesList = Objects.requireNonNull(pathToProfiles.listFiles());

		if (profilesList.length > 0) {
			for (File profile : profilesList) {
				MinerProfile minerProfile = new MinerProfile();
				try {
					minerProfile.loadProfile(profile.getName());
					profilesListView.getItems().add(minerProfile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

		brightenImage.setBrightness(0.0);
		darkenImage.setBrightness(-0.6);
	}

	private boolean canInitializeVars() {
		switch (PlayerInfo.INSTANCE.getSelectedTask()) {
			case TRADITIONAL_MINING:
				if (selectedRocksListView.getItems().size() < 1) {
					return false;
				}
				PlayerInfo.INSTANCE.setShouldEndFullInv(endFullInvCheckBox.isSelected());
				PlayerInfo.INSTANCE.setMembers(membersCheckBox.isSelected());
				PlayerInfo.INSTANCE.setShouldBank(bankCheckBox.isSelected());
				PlayerInfo.INSTANCE.setShouldHopDepleted(hopWorldsCheckBox.isSelected());
				PlayerInfo.INSTANCE.setMiningRadius(radiusSpinner.getValue());
				PlayerInfo.INSTANCE.setSelectedPick(picksChoiceBox.getSelectionModel().getSelectedItem());
				PlayerInfo.INSTANCE.setSelectedRockTypes(new ArrayList<>(selectedRocksListView.getItems()));
				if (walkToTileCheckBox.isSelected()) {
					PlayerInfo.INSTANCE.setStartingTile(new RSTile(tileSpinnerX.getValue(), tileSpinnerY.getValue()));
				}
				else {
					PlayerInfo.INSTANCE.setStartingTile(Player.getPosition());
				}
				if (useLevelRangeCheckBox.isSelected()) {
					PlayerInfo.INSTANCE.setLevelToStartAt(lowLevelSpinner.getValue());
					PlayerInfo.INSTANCE.setLevelToEndAt(highLevelSpinner.getValue());
				}
				break;
			case PROGRESSIVE_MINING:
				PlayerInfo.INSTANCE.setProgressiveTasks(new HashSet<>(selectedTaskListView.getItems()));
				break;
		}
		PlayerInfo.INSTANCE.setShouldHopHighCompetition(hopPlayerCountCheckBox.isSelected());
		PlayerInfo.INSTANCE.setShouldHopOnChat(hopOnChatCheckBox.isSelected());
		PlayerInfo.INSTANCE.setShouldUseAntiPK(antiPkCheckBox.isSelected());
		PlayerInfo.INSTANCE.setShouldPaint(drawPaintCheckBox.isSelected());
		PlayerInfo.INSTANCE.setShouldDrawDebug(drawDebugCheckBox.isSelected());
		PlayerInfo.INSTANCE.setReactionTime(reactionTimeSlider.getValue());
		PlayerInfo.INSTANCE.setFatigueRate(fatigueRateSlider.getValue());
		return true;
	}

	private void loadProfile(MinerProfile minerProfile) {
		endFullInvCheckBox.setSelected(minerProfile.isShouldEndFullInv());
		membersCheckBox.setSelected(minerProfile.isMembers());
		bankCheckBox.setSelected(minerProfile.isShouldBank());
		hopWorldsCheckBox.setSelected(minerProfile.isShouldHopDepleted());
		radiusSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 25, minerProfile.getMiningRadius()));
		picksChoiceBox.getSelectionModel().select(minerProfile.getSelectedPick());
		tileSpinnerX.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, minerProfile.getStartingTile().getX()));
		tileSpinnerY.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, minerProfile.getStartingTile().getY()));
		lowLevelSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, minerProfile.getLevelToStartAt()));
		highLevelSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100, minerProfile.getLevelToEndAt()));

		selectedRocksListView.getItems().clear();
		selectedRocksListView.getItems().addAll(minerProfile.getSelectedRockTypes());

		selectedTaskListView.getItems().clear();
		selectedTaskListView.getItems().addAll(minerProfile.getProgressiveTasks());

		hopPlayerCountCheckBox.setSelected(minerProfile.isShouldHopHighCompetition());
		hopOnChatCheckBox.setSelected(minerProfile.isShouldHopOnChat());
		antiPkCheckBox.setSelected(minerProfile.isShouldUseAntiPK());
		drawPaintCheckBox.setSelected(minerProfile.isShouldPaint());
		drawDebugCheckBox.setSelected(minerProfile.isShouldDrawDebug());
		reactionTimeSlider.setValue(minerProfile.getReactionTime());
		fatigueRateSlider.setValue(minerProfile.getFatigueRate());

		for (Rock rock : selectedRocksListView.getItems()) {
			switch (rock) {
				case CLAY:
					clayImage.setEffect(darkenImage);
					break;
				case LIMESTONE:
					limestoneImage.setEffect(darkenImage);
					break;
				case SANDSTONE:
					sandstoneImage.setEffect(darkenImage);
					break;
				case GRANITE:
					graniteImage.setEffect(darkenImage);
					break;
				case COPPER:
					copperOreImage.setEffect(darkenImage);
					break;
				case TIN:
					tinOreImage.setEffect(darkenImage);
					break;
				case IRON:
					ironOreImage.setEffect(darkenImage);
					break;
				case COAL:
					coalImage.setEffect(darkenImage);
					break;
				case SILVER:
					silverOreImage.setEffect(darkenImage);
					break;
				case GOLD:
					goldOreImage.setEffect(darkenImage);
					break;
				case PURE_ESSENCE:
					essenceImage.setEffect(darkenImage);
					break;
				case GEM:
					gemImage.setEffect(darkenImage);
					break;
				case MITHRIL:
					mithrilOreImage.setEffect(darkenImage);
					break;
				case ADAMANTITE:
					adamantiteOreImage.setEffect(darkenImage);
					break;
				case RUNITE:
					runiteOreImage.setEffect(darkenImage);
					break;
				case AMETHYST:
					amethystImage.setEffect(darkenImage);
					break;
			}
		}
	}
	public static void argsStart() throws FileNotFoundException {
		MinerProfile minerProfile = new MinerProfile();
		if (!minerProfile.loadProfile(PlayerInfo.INSTANCE.getProfile().getName())) {
			System.out.println("Failed to load profile");
		}

		switch (PlayerInfo.INSTANCE.getSelectedTask()) {
			case TRADITIONAL_MINING:
				PlayerInfo.INSTANCE.setShouldEndFullInv(minerProfile.isShouldEndFullInv());
				PlayerInfo.INSTANCE.setMembers(minerProfile.isMembers());
				PlayerInfo.INSTANCE.setShouldBank(minerProfile.isShouldBank());
				PlayerInfo.INSTANCE.setShouldHopDepleted(minerProfile.isShouldHopDepleted());
				PlayerInfo.INSTANCE.setMiningRadius(minerProfile.getMiningRadius());
				PlayerInfo.INSTANCE.setSelectedPick(minerProfile.getSelectedPick());
				PlayerInfo.INSTANCE.setSelectedRockTypes(minerProfile.getSelectedRockTypes());
				if (!minerProfile.getStartingTile().equals(new RSTile(0, 0))) {
					PlayerInfo.INSTANCE.setStartingTile(new RSTile(minerProfile.getStartingTile().getX(), minerProfile.getStartingTile().getY()));
				}
				else {
					PlayerInfo.INSTANCE.setStartingTile(Player.getPosition());
				}
				if (minerProfile.getLevelToStartAt() != 1 || minerProfile.getLevelToEndAt() != 100) {
					PlayerInfo.INSTANCE.setLevelToStartAt(minerProfile.getLevelToStartAt());
					PlayerInfo.INSTANCE.setLevelToEndAt(minerProfile.getLevelToEndAt());
				}
				break;
			case PROGRESSIVE_MINING:
				PlayerInfo.INSTANCE.setProgressiveTasks(new HashSet<>(minerProfile.getProgressiveTasks()));
				break;
		}
		PlayerInfo.INSTANCE.setShouldHopHighCompetition(minerProfile.isShouldHopHighCompetition());
		PlayerInfo.INSTANCE.setShouldHopOnChat(minerProfile.isShouldHopOnChat());
		PlayerInfo.INSTANCE.setShouldUseAntiPK(minerProfile.isShouldUseAntiPK());
		PlayerInfo.INSTANCE.setShouldPaint(minerProfile.isShouldPaint());
		PlayerInfo.INSTANCE.setShouldDrawDebug(minerProfile.isShouldDrawDebug());
		PlayerInfo.INSTANCE.setReactionTime(minerProfile.getReactionTime());
		PlayerInfo.INSTANCE.setFatigueRate(minerProfile.getFatigueRate());
	}
}
