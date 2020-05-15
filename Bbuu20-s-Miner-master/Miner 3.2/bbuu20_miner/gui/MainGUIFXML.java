package scripts.bbuu20_miner.gui;

public class MainGUIFXML {

	public static String get = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"\n" +
			"<?import javafx.scene.*?>\n" +
			"<?import javafx.scene.control.*?>\n" +
			"<?import javafx.scene.image.*?>\n" +
			"<?import javafx.scene.layout.*?>\n" +
			"<?import javafx.scene.shape.*?>\n" +
			"<?import javafx.scene.text.*?>\n" +
			"\n" +
			"<AnchorPane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"400.0\" prefWidth=\"1000.0\" xmlns=\"http://javafx.com/javafx/10.0.2-internal\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"scripts.bbuu20_miner.gui.GUIController\">\n" +
			"   <children>\n" +
			"      <TabPane fx:id=\"tabPane\" tabClosingPolicy=\"UNAVAILABLE\" tabMaxHeight=\"25.0\" tabMaxWidth=\"150.0\" tabMinHeight=\"25.0\" tabMinWidth=\"150.0\" AnchorPane.bottomAnchor=\"50.0\" AnchorPane.leftAnchor=\"0.0\" AnchorPane.rightAnchor=\"0.0\" AnchorPane.topAnchor=\"0.0\">\n" +
			"        <tabs>\n" +
			"          <Tab onSelectionChanged=\"#traditionalTabChanged\" text=\"Traditional Mining\">\n" +
			"            <content>\n" +
			"              <AnchorPane>\n" +
			"                     <children>\n" +
			"                        <GridPane layoutX=\"30.0\" layoutY=\"8.0\" prefHeight=\"316.0\" prefWidth=\"940.0\">\n" +
			"                          <columnConstraints>\n" +
			"                            <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" maxWidth=\"400.0\" minWidth=\"400.0\" prefWidth=\"400.0\" />\n" +
			"                              <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" maxWidth=\"10.0\" minWidth=\"10.0\" prefWidth=\"10.0\" />\n" +
			"                            <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" maxWidth=\"337.0\" minWidth=\"150.0\" prefWidth=\"337.0\" />\n" +
			"                              <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" maxWidth=\"169.0\" minWidth=\"8.0\" prefWidth=\"8.0\" />\n" +
			"                              <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" maxWidth=\"365.0\" minWidth=\"-Infinity\" prefWidth=\"185.0\" />\n" +
			"                          </columnConstraints>\n" +
			"                          <rowConstraints>\n" +
			"                              <RowConstraints maxHeight=\"281.0\" minHeight=\"10.0\" prefHeight=\"36.0\" vgrow=\"SOMETIMES\" />\n" +
			"                            <RowConstraints maxHeight=\"281.0\" minHeight=\"10.0\" prefHeight=\"233.0\" vgrow=\"SOMETIMES\" />\n" +
			"                              <RowConstraints maxHeight=\"89.0\" minHeight=\"38.0\" prefHeight=\"48.0\" vgrow=\"SOMETIMES\" />\n" +
			"                          </rowConstraints>\n" +
			"                           <children>\n" +
			"                              <Label text=\"Add To Progressive Tasks\" GridPane.columnIndex=\"4\">\n" +
			"                                 <font>\n" +
			"                                    <Font name=\"System Bold\" size=\"14.0\" />\n" +
			"                                 </font>\n" +
			"                              </Label>\n" +
			"                              <GridPane GridPane.columnIndex=\"4\" GridPane.rowIndex=\"1\">\n" +
			"                                <columnConstraints>\n" +
			"                                  <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                </columnConstraints>\n" +
			"                                <rowConstraints>\n" +
			"                                  <RowConstraints maxHeight=\"73.0\" minHeight=\"6.0\" prefHeight=\"10.0\" valignment=\"BOTTOM\" vgrow=\"SOMETIMES\" />\n" +
			"                                  <RowConstraints maxHeight=\"100.0\" minHeight=\"100.0\" prefHeight=\"100.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                  <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" valignment=\"TOP\" vgrow=\"SOMETIMES\" />\n" +
			"                                </rowConstraints>\n" +
			"                                 <children>\n" +
			"                                    <Label text=\"Enter Task Name\">\n" +
			"                                       <font>\n" +
			"                                          <Font name=\"System Bold\" size=\"12.0\" />\n" +
			"                                       </font></Label>\n" +
			"                                    <TextField fx:id=\"taskTextField\" GridPane.rowIndex=\"1\" />\n" +
			"                                    <Button fx:id=\"addTaskButton\" mnemonicParsing=\"false\" onAction=\"#addTaskButtonPressed\" text=\"Add Task\" GridPane.rowIndex=\"2\" />\n" +
			"                                 </children>\n" +
			"                              </GridPane>\n" +
			"                              <GridPane>\n" +
			"                                <columnConstraints>\n" +
			"                                  <ColumnConstraints hgrow=\"SOMETIMES\" maxWidth=\"210.0\" minWidth=\"10.0\" prefWidth=\"206.0\" />\n" +
			"                                  <ColumnConstraints hgrow=\"SOMETIMES\" maxWidth=\"197.0\" minWidth=\"10.0\" prefWidth=\"194.0\" />\n" +
			"                                </columnConstraints>\n" +
			"                                <rowConstraints>\n" +
			"                                  <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                </rowConstraints>\n" +
			"                                 <children>\n" +
			"                                    <Label text=\"Available Rocks\" GridPane.halignment=\"CENTER\">\n" +
			"                                       <font>\n" +
			"                                          <Font name=\"System Bold\" size=\"14.0\" />\n" +
			"                                       </font>\n" +
			"                                    </Label>\n" +
			"                                    <Label text=\"Selected Rocks\" GridPane.columnIndex=\"1\" GridPane.halignment=\"CENTER\">\n" +
			"                                       <font>\n" +
			"                                          <Font name=\"System Bold\" size=\"14.0\" />\n" +
			"                                       </font>\n" +
			"                                    </Label>\n" +
			"                                 </children>\n" +
			"                              </GridPane>\n" +
			"                              <GridPane GridPane.rowIndex=\"1\">\n" +
			"                                <columnConstraints>\n" +
			"                                  <ColumnConstraints hgrow=\"SOMETIMES\" maxWidth=\"218.0\" minWidth=\"10.0\" prefWidth=\"218.0\" />\n" +
			"                                  <ColumnConstraints hgrow=\"SOMETIMES\" maxWidth=\"195.0\" minWidth=\"10.0\" prefWidth=\"182.0\" />\n" +
			"                                </columnConstraints>\n" +
			"                                <rowConstraints>\n" +
			"                                  <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                    <RowConstraints />\n" +
			"                                </rowConstraints>\n" +
			"                                 <children>\n" +
			"                                    <GridPane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"210.0\" prefWidth=\"210.0\" GridPane.halignment=\"LEFT\" GridPane.rowIndex=\"1\">\n" +
			"                                      <columnConstraints>\n" +
			"                                        <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                          <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                        <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                          <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                      </columnConstraints>\n" +
			"                                      <rowConstraints>\n" +
			"                                        <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" valignment=\"CENTER\" vgrow=\"SOMETIMES\" />\n" +
			"                                        <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" valignment=\"CENTER\" vgrow=\"SOMETIMES\" />\n" +
			"                                        <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" valignment=\"CENTER\" vgrow=\"SOMETIMES\" />\n" +
			"                                          <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" valignment=\"CENTER\" vgrow=\"SOMETIMES\" />\n" +
			"                                      </rowConstraints>\n" +
			"                                       <children>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" />\n" +
			"                                          <ImageView fx:id=\"clayImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#clayMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"1\" />\n" +
			"                                          <ImageView fx:id=\"limestoneImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#limestoneMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"1\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"1\" />\n" +
			"                                          <ImageView fx:id=\"ironOreImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#ironMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"1\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.rowIndex=\"2\" />\n" +
			"                                          <ImageView fx:id=\"silverOreImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#silverMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.rowIndex=\"2\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"2\" />\n" +
			"                                          <ImageView fx:id=\"sandstoneImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#sandstoneMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"2\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"3\" GridPane.rowIndex=\"2\" />\n" +
			"                                          <ImageView fx:id=\"gemImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#gemMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"3\" GridPane.rowIndex=\"2\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"3\" />\n" +
			"                                          <ImageView fx:id=\"graniteImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#graniteMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"3\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"1\" GridPane.rowIndex=\"3\" />\n" +
			"                                          <ImageView fx:id=\"adamantiteOreImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#adamantiteMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"1\" GridPane.rowIndex=\"3\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"3\" />\n" +
			"                                          <ImageView fx:id=\"runiteOreImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#runiteMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"3\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"3\" GridPane.rowIndex=\"3\" />\n" +
			"                                          <ImageView fx:id=\"amethystImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#amethystMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"3\" GridPane.rowIndex=\"3\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.rowIndex=\"1\" />\n" +
			"                                          <ImageView fx:id=\"copperOreImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#copperMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.rowIndex=\"1\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"1\" GridPane.rowIndex=\"1\" />\n" +
			"                                          <ImageView fx:id=\"tinOreImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#tinMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"1\" GridPane.rowIndex=\"1\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"3\" GridPane.rowIndex=\"1\" />\n" +
			"                                          <ImageView fx:id=\"coalImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#coalMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"3\" GridPane.rowIndex=\"1\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"1\" GridPane.rowIndex=\"2\" />\n" +
			"                                          <ImageView fx:id=\"goldOreImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#goldMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"1\" GridPane.rowIndex=\"2\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.rowIndex=\"3\" />\n" +
			"                                          <ImageView fx:id=\"mithrilOreImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#mithrilMouseClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.rowIndex=\"3\">\n" +
			"                                             <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                          <Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1e1e1e\" height=\"50.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" width=\"50.0\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"2\" />\n" +
			"                                          <ImageView fx:id=\"essenceImage\" fitHeight=\"45.0\" fitWidth=\"45.0\" onMouseClicked=\"#essenceImageClicked\" pickOnBounds=\"true\" preserveRatio=\"true\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"2\">\n" +
			"                                               <cursor>\n" +
			"                                                <Cursor fx:constant=\"HAND\" />\n" +
			"                                             </cursor>\n" +
			"                                          </ImageView>\n" +
			"                                       </children>\n" +
			"                                    </GridPane>\n" +
			"                                    <ListView fx:id=\"selectedRocksListView\" prefHeight=\"200.0\" prefWidth=\"200.0\" GridPane.columnIndex=\"1\" GridPane.rowIndex=\"1\" />\n" +
			"                                 </children>\n" +
			"                              </GridPane>\n" +
			"                              <GridPane prefWidth=\"309.0\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"1\">\n" +
			"                                <columnConstraints>\n" +
			"                                  <ColumnConstraints hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                  <ColumnConstraints hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                    <ColumnConstraints hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                </columnConstraints>\n" +
			"                                <rowConstraints>\n" +
			"                                  <RowConstraints maxHeight=\"56.0\" minHeight=\"10.0\" prefHeight=\"56.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                  <RowConstraints maxHeight=\"61.0\" minHeight=\"10.0\" prefHeight=\"61.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                  <RowConstraints maxHeight=\"57.0\" minHeight=\"10.0\" prefHeight=\"57.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                    <RowConstraints maxHeight=\"58.0\" minHeight=\"20.0\" prefHeight=\"58.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                </rowConstraints>\n" +
			"                                 <children>\n" +
			"                                    <CheckBox fx:id=\"walkToTileCheckBox\" mnemonicParsing=\"false\" onAction=\"#walkToTileClicked\" text=\"Walk To Tile\" GridPane.halignment=\"LEFT\" GridPane.valignment=\"CENTER\" />\n" +
			"                                    <Spinner fx:id=\"tileSpinnerX\" disable=\"true\" editable=\"true\" GridPane.columnIndex=\"1\" />\n" +
			"                                    <Label text=\"RSTile X\" GridPane.columnIndex=\"1\" GridPane.halignment=\"CENTER\" GridPane.valignment=\"TOP\" />\n" +
			"                                    <Spinner fx:id=\"tileSpinnerY\" disable=\"true\" editable=\"true\" GridPane.columnIndex=\"2\" />\n" +
			"                                    <Label text=\"RSTile Y\" GridPane.columnIndex=\"2\" GridPane.halignment=\"CENTER\" GridPane.valignment=\"TOP\" />\n" +
			"                                    <CheckBox fx:id=\"useLevelRangeCheckBox\" mnemonicParsing=\"false\" onAction=\"#useLevelRangeClicked\" text=\"Use level range\" GridPane.rowIndex=\"1\" />\n" +
			"                                    <Spinner fx:id=\"lowLevelSpinner\" disable=\"true\" editable=\"true\" GridPane.columnIndex=\"1\" GridPane.rowIndex=\"1\" />\n" +
			"                                    <Spinner fx:id=\"highLevelSpinner\" disable=\"true\" editable=\"true\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"1\" />\n" +
			"                                    <Label text=\"Start At Level:\" GridPane.columnIndex=\"1\" GridPane.halignment=\"CENTER\" GridPane.rowIndex=\"1\" GridPane.valignment=\"TOP\" />\n" +
			"                                    <Label text=\"End At Level:\" GridPane.columnIndex=\"2\" GridPane.halignment=\"CENTER\" GridPane.rowIndex=\"1\" GridPane.valignment=\"TOP\" />\n" +
			"                                    <ChoiceBox fx:id=\"picksChoiceBox\" prefWidth=\"150.0\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"3\" />\n" +
			"                                    <Spinner fx:id=\"radiusSpinner\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"2\" />\n" +
			"                                    <Label text=\"Radius\" GridPane.columnIndex=\"2\" GridPane.halignment=\"CENTER\" GridPane.rowIndex=\"2\" GridPane.valignment=\"TOP\" />\n" +
			"                                    <CheckBox fx:id=\"endFullInvCheckBox\" mnemonicParsing=\"false\" text=\"End On Full Inv\" GridPane.columnIndex=\"1\" GridPane.halignment=\"LEFT\" GridPane.rowIndex=\"2\" />\n" +
			"                                    <CheckBox fx:id=\"bankCheckBox\" mnemonicParsing=\"false\" text=\"Bank\" GridPane.halignment=\"LEFT\" GridPane.rowIndex=\"2\" />\n" +
			"                                    <CheckBox fx:id=\"membersCheckBox\" mnemonicParsing=\"false\" text=\"Members\" GridPane.columnIndex=\"1\" GridPane.halignment=\"LEFT\" GridPane.rowIndex=\"3\" />\n" +
			"                                    <CheckBox fx:id=\"hopWorldsCheckBox\" mnemonicParsing=\"false\" text=\"Hop Depleted\" GridPane.halignment=\"LEFT\" GridPane.rowIndex=\"3\" />\n" +
			"                                    <Label text=\"Pickaxe\" GridPane.columnIndex=\"2\" GridPane.halignment=\"CENTER\" GridPane.rowIndex=\"3\" GridPane.valignment=\"TOP\" />\n" +
			"                                 </children>\n" +
			"                              </GridPane>\n" +
			"                           </children>\n" +
			"                        </GridPane>\n" +
			"                     </children></AnchorPane>\n" +
			"            </content>\n" +
			"          </Tab>\n" +
			"          <Tab onSelectionChanged=\"#progressiveTabChanged\" text=\"Progressive Mining\">\n" +
			"            <content>\n" +
			"              <AnchorPane>\n" +
			"                     <children>\n" +
			"                        <GridPane layoutX=\"250.0\" maxWidth=\"930.0\" minWidth=\"500.0\" prefHeight=\"318.0\" prefWidth=\"500.0\" AnchorPane.bottomAnchor=\"0.0\" AnchorPane.leftAnchor=\"250.0\" AnchorPane.rightAnchor=\"250.0\" AnchorPane.topAnchor=\"0.0\">\n" +
			"                          <columnConstraints>\n" +
			"                            <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                          </columnConstraints>\n" +
			"                          <rowConstraints>\n" +
			"                            <RowConstraints maxHeight=\"40.0\" minHeight=\"40.0\" prefHeight=\"40.0\" vgrow=\"SOMETIMES\" />\n" +
			"                            <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"                            <RowConstraints maxHeight=\"40.0\" minHeight=\"40.0\" prefHeight=\"40.0\" vgrow=\"SOMETIMES\" />\n" +
			"                          </rowConstraints>\n" +
			"                           <children>\n" +
			"                              <ListView fx:id=\"selectedTaskListView\" prefHeight=\"200.0\" prefWidth=\"671.0\" GridPane.rowIndex=\"1\" />\n" +
			"                              <Label text=\"Selected Tasks\">\n" +
			"                                 <font>\n" +
			"                                    <Font name=\"System Bold\" size=\"14.0\" />\n" +
			"                                 </font>\n" +
			"                              </Label>\n" +
			"                              <Button fx:id=\"deselectTaskButton\" mnemonicParsing=\"false\" onAction=\"#deselectTaskButtonPressed\" text=\"Remove Task\" GridPane.rowIndex=\"2\" />\n" +
			"                           </children>\n" +
			"                        </GridPane>\n" +
			"                     </children></AnchorPane>\n" +
			"            </content>\n" +
			"          </Tab>\n" +
			"          <Tab onSelectionChanged=\"#antibanTabChanged\" text=\"Anti-Ban Settings\">\n" +
			"              <content>\n" +
			"                  <AnchorPane>\n" +
			"                     <children>\n" +
			"                        <GridPane layoutX=\"80.0\" layoutY=\"18.0\" prefHeight=\"300.0\" prefWidth=\"630.0\" AnchorPane.bottomAnchor=\"80.0\" AnchorPane.leftAnchor=\"80.0\" AnchorPane.rightAnchor=\"90.0\" AnchorPane.topAnchor=\"18.0\">\n" +
			"                          <columnConstraints>\n" +
			"                            <ColumnConstraints hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                              <ColumnConstraints hgrow=\"SOMETIMES\" maxWidth=\"100.0\" minWidth=\"100.0\" prefWidth=\"100.0\" />\n" +
			"                            <ColumnConstraints hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                          </columnConstraints>\n" +
			"                          <rowConstraints>\n" +
			"                            <RowConstraints maxHeight=\"60.0\" minHeight=\"60.0\" prefHeight=\"60.0\" vgrow=\"SOMETIMES\" />\n" +
			"                              <RowConstraints maxHeight=\"75.0\" minHeight=\"37.0\" prefHeight=\"37.0\" vgrow=\"SOMETIMES\" />\n" +
			"                            <RowConstraints maxHeight=\"143.0\" minHeight=\"100.0\" prefHeight=\"143.0\" vgrow=\"SOMETIMES\" />\n" +
			"                          </rowConstraints>\n" +
			"                           <children>\n" +
			"                              <Slider fx:id=\"reactionTimeSlider\" blockIncrement=\"1.0\" max=\"50.0\" min=\"1.0\" value=\"25.5\" />\n" +
			"                              <Slider fx:id=\"fatigueRateSlider\" max=\"1.0E-4\" value=\"5.0E-5\" GridPane.columnIndex=\"2\" />\n" +
			"                              <Label text=\"Reaction Time Modifier\" GridPane.halignment=\"CENTER\" GridPane.valignment=\"TOP\" />\n" +
			"                              <Label text=\"Slow\" GridPane.halignment=\"LEFT\" GridPane.valignment=\"BOTTOM\" />\n" +
			"                              <Label text=\"Normal\" GridPane.halignment=\"CENTER\" GridPane.valignment=\"BOTTOM\" />\n" +
			"                              <Label text=\"Quick\" GridPane.halignment=\"RIGHT\" GridPane.valignment=\"BOTTOM\" />\n" +
			"                              <Label text=\"Fatigue Rate\" GridPane.columnIndex=\"2\" GridPane.halignment=\"CENTER\" GridPane.valignment=\"TOP\" />\n" +
			"                              <Label text=\"No Fatigue\" GridPane.columnIndex=\"2\" GridPane.halignment=\"LEFT\" GridPane.valignment=\"BOTTOM\" />\n" +
			"                              <Label text=\"Normal Fatigue\" GridPane.columnIndex=\"2\" GridPane.halignment=\"CENTER\" GridPane.valignment=\"BOTTOM\" />\n" +
			"                              <Label text=\"Rapid Fatigue\" GridPane.columnIndex=\"2\" GridPane.halignment=\"RIGHT\" GridPane.valignment=\"BOTTOM\" />\n" +
			"                              <CheckBox fx:id=\"hopPlayerCountCheckBox\" mnemonicParsing=\"false\" text=\"Hop On High Competition\" GridPane.halignment=\"LEFT\" GridPane.rowIndex=\"2\" GridPane.valignment=\"BOTTOM\" />\n" +
			"                              <CheckBox fx:id=\"hopOnChatCheckBox\" mnemonicParsing=\"false\" text=\"Hop On Chat\" GridPane.halignment=\"LEFT\" GridPane.rowIndex=\"2\" GridPane.valignment=\"CENTER\" />\n" +
			"                              <CheckBox fx:id=\"antiPkCheckBox\" mnemonicParsing=\"false\" text=\"Use Anti-PK\" GridPane.halignment=\"LEFT\" GridPane.rowIndex=\"2\" GridPane.valignment=\"TOP\" />\n" +
			"                           </children>\n" +
			"                        </GridPane>\n" +
			"                     </children></AnchorPane>\n" +
			"              </content>\n" +
			"          </Tab>\n" +
			"          <Tab onSelectionChanged=\"#saveLoadTabChanged\" text=\"Load/Save Profile\">\n" +
			"              <content>\n" +
			"                  <AnchorPane>\n" +
			"                     <children>\n" +
			"                        <GridPane layoutX=\"200.0\" layoutY=\"50.0\" AnchorPane.bottomAnchor=\"25.0\" AnchorPane.leftAnchor=\"200.0\" AnchorPane.rightAnchor=\"200.0\" AnchorPane.topAnchor=\"50.0\">\n" +
			"                          <columnConstraints>\n" +
			"                            <ColumnConstraints hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                              <ColumnConstraints hgrow=\"SOMETIMES\" maxWidth=\"100.0\" minWidth=\"100.0\" prefWidth=\"100.0\" />\n" +
			"                            <ColumnConstraints hgrow=\"SOMETIMES\" maxWidth=\"250.0\" minWidth=\"250.0\" prefWidth=\"250.0\" />\n" +
			"                          </columnConstraints>\n" +
			"                          <rowConstraints>\n" +
			"                            <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"                              <RowConstraints maxHeight=\"40.0\" minHeight=\"40.0\" prefHeight=\"40.0\" vgrow=\"SOMETIMES\" />\n" +
			"                          </rowConstraints>\n" +
			"                           <children>\n" +
			"                              <GridPane>\n" +
			"                                <columnConstraints>\n" +
			"                                  <ColumnConstraints hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                </columnConstraints>\n" +
			"                                <rowConstraints>\n" +
			"                                  <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                  <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                  <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                </rowConstraints>\n" +
			"                                 <children>\n" +
			"                                    <TextField fx:id=\"profileTextField\" prefWidth=\"303.0\" GridPane.rowIndex=\"1\" />\n" +
			"                                    <Label text=\"Enter Profile Save Name\" GridPane.halignment=\"CENTER\" GridPane.valignment=\"BOTTOM\" />\n" +
			"                                    <Button fx:id=\"saveProfileButton\" mnemonicParsing=\"false\" onAction=\"#saveProfileButtonPressed\" text=\"Save\" GridPane.halignment=\"CENTER\" GridPane.rowIndex=\"2\" GridPane.valignment=\"TOP\" />\n" +
			"                                 </children>\n" +
			"                              </GridPane>\n" +
			"                              <ListView fx:id=\"profilesListView\" prefHeight=\"200.0\" prefWidth=\"200.0\" GridPane.columnIndex=\"2\" />\n" +
			"                              <GridPane prefHeight=\"30.0\" prefWidth=\"250.0\" GridPane.columnIndex=\"2\" GridPane.rowIndex=\"1\">\n" +
			"                                <columnConstraints>\n" +
			"                                  <ColumnConstraints hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                  <ColumnConstraints hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                                </columnConstraints>\n" +
			"                                <rowConstraints>\n" +
			"                                  <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"                                </rowConstraints>\n" +
			"                                 <children>\n" +
			"                                    <Button fx:id=\"loadProfileButton\" mnemonicParsing=\"false\" onAction=\"#loadProfileButtonPressed\" prefHeight=\"25.0\" prefWidth=\"110.0\" text=\"Load Profile\" GridPane.halignment=\"CENTER\" />\n" +
			"                                    <Button fx:id=\"deleteProfileButton\" mnemonicParsing=\"false\" onAction=\"#deleteProfileButtonPressed\" prefHeight=\"25.0\" prefWidth=\"110.0\" text=\"Delete Profile\" GridPane.columnIndex=\"1\" GridPane.halignment=\"CENTER\" />\n" +
			"                                 </children>\n" +
			"                              </GridPane>\n" +
			"                           </children>\n" +
			"                        </GridPane>\n" +
			"                        <Label layoutX=\"656.0\" layoutY=\"33.0\" text=\"Profiles\" />\n" +
			"                     </children></AnchorPane>\n" +
			"              </content>\n" +
			"          </Tab>\n" +
			"        </tabs>\n" +
			"      </TabPane>\n" +
			"      <ToolBar layoutY=\"360.0\" nodeOrientation=\"RIGHT_TO_LEFT\" AnchorPane.bottomAnchor=\"0.0\" AnchorPane.leftAnchor=\"0.0\" AnchorPane.rightAnchor=\"0.0\" AnchorPane.topAnchor=\"355.0\">\n" +
			"         <items>\n" +
			"            <GridPane maxHeight=\"35.0\" maxWidth=\"955.0\" minHeight=\"35.0\" minWidth=\"680.0\" prefHeight=\"35.0\" prefWidth=\"955.0\">\n" +
			"              <columnConstraints>\n" +
			"                <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" maxWidth=\"120.0\" minWidth=\"120.0\" prefWidth=\"120.0\" />\n" +
			"                <ColumnConstraints halignment=\"LEFT\" hgrow=\"SOMETIMES\" maxWidth=\"155.0\" minWidth=\"10.0\" prefWidth=\"155.0\" />\n" +
			"                  <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" maxWidth=\"570.0\" minWidth=\"10.0\" prefWidth=\"452.0\" />\n" +
			"                  <ColumnConstraints halignment=\"RIGHT\" hgrow=\"SOMETIMES\" maxWidth=\"130.0\" minWidth=\"100.0\" prefWidth=\"130.0\" />\n" +
			"                  <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" maxWidth=\"163.0\" minWidth=\"10.0\" prefWidth=\"111.0\" />\n" +
			"              </columnConstraints>\n" +
			"              <rowConstraints>\n" +
			"                <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"              </rowConstraints>\n" +
			"               <children>\n" +
			"                  <CheckBox fx:id=\"drawPaintCheckBox\" mnemonicParsing=\"false\" text=\"Draw Paint\" GridPane.columnIndex=\"4\" />\n" +
			"                  <CheckBox fx:id=\"drawDebugCheckBox\" mnemonicParsing=\"false\" text=\"Draw Debug\" GridPane.columnIndex=\"3\" />\n" +
			"                <Button fx:id=\"startMiningButton\" mnemonicParsing=\"false\" onAction=\"#startMiningButtonPressed\" text=\"Start Traditional Mining\" GridPane.columnIndex=\"2\" />\n" +
			"                  <GridPane>\n" +
			"                    <columnConstraints>\n" +
			"                      <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                      <ColumnConstraints halignment=\"CENTER\" hgrow=\"SOMETIMES\" minWidth=\"10.0\" prefWidth=\"100.0\" />\n" +
			"                    </columnConstraints>\n" +
			"                    <rowConstraints>\n" +
			"                      <RowConstraints minHeight=\"10.0\" prefHeight=\"30.0\" vgrow=\"SOMETIMES\" />\n" +
			"                    </rowConstraints>\n" +
			"                     <children>\n" +
			"                        <Button fx:id=\"tribotButton\" maxHeight=\"40.0\" maxWidth=\"40.0\" minHeight=\"40.0\" minWidth=\"40.0\" mnemonicParsing=\"false\" onAction=\"#tribotButtonPressed\" prefHeight=\"40.0\" prefWidth=\"40.0\">\n" +
			"                           <graphic>\n" +
			"                              <ImageView fx:id=\"tribotImage\" fitHeight=\"35.0\" fitWidth=\"35.0\" pickOnBounds=\"true\" preserveRatio=\"true\" />\n" +
			"                           </graphic>\n" +
			"                        </Button>\n" +
			"                        <Button fx:id=\"discordButton\" maxHeight=\"40.0\" maxWidth=\"40.0\" minHeight=\"40.0\" minWidth=\"40.0\" mnemonicParsing=\"false\" onAction=\"#discordButtonPressed\" prefHeight=\"40.0\" prefWidth=\"40.0\" GridPane.columnIndex=\"1\">\n" +
			"                           <graphic>\n" +
			"                              <ImageView fx:id=\"discordImage\" fitHeight=\"40.0\" fitWidth=\"40.0\" pickOnBounds=\"true\" preserveRatio=\"true\" />\n" +
			"                           </graphic>\n" +
			"                        </Button>\n" +
			"                     </children>\n" +
			"                  </GridPane>\n" +
			"                  <Label text=\"Support:\" GridPane.columnIndex=\"1\">\n" +
			"                     <font>\n" +
			"                        <Font name=\"System Bold\" size=\"14.0\" />\n" +
			"                     </font>\n" +
			"                  </Label>\n" +
			"               </children>\n" +
			"            </GridPane>\n" +
			"         </items>\n" +
			"      </ToolBar>\n" +
			"   </children>\n" +
			"</AnchorPane>\n";
}