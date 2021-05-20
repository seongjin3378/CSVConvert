package application;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;

public class Controller implements Initializable{

private Stage stage = new Stage();
private String FileName = "";
private String FilePath = "";
private int SELECT_COUNT = 0;
private int[] SELECT_ARRAY = new int[20];
private boolean SELECT_CHECK = false;
private int SELECT_START = 0;
private int SELECT_INDEX = 0;

@FXML
public ComboBox<String> combo_box0;

@SuppressWarnings("exports")
@FXML
public List<TextField> TextFieldList ;
@FXML
public List<Text> FilePathNameFieldList;
@FXML
public List<CheckBox> SELECT_ALL_N_CANCEL_FIELD_LIST;
@FXML
public Button CANCEL;
@FXML	
public void open(ActionEvent event)
{
	FileChooser fileChooser = new FileChooser();
	fileChooser.setTitle("Open CSV File");
	fileChooser.getExtensionFilters().addAll(new ExtensionFilter("CSV Files", "*.csv"));
	File Choose_File = fileChooser.showOpenDialog(stage);
	FileName = Choose_File.getName();
	FilePath = Choose_File.getPath();
	for (TextField PrintFileName : TextFieldList) {
    if(PrintFileName.getText().equals(""))
    {
    	PrintFileName.setText(FileName);
    	break;
    }
	}
	for (Text PrintFilePath : FilePathNameFieldList) {
	    if(PrintFilePath.getText().equals(""))
	    {
	    	PrintFilePath.setText(FilePath);
	    	break;
	    }
		}
}
@FXML
public void open_Folder_File(ActionEvent event)
{
	DirectoryChooser dc = new DirectoryChooser();
	File selectedDc = dc.showDialog(stage);
	String selectedDcPath = selectedDc.getPath();
}
@FXML
public void SELECT_INDEX(ActionEvent event)
{
	for (CheckBox SUCCESE_CHECK_CHECKBOX : SELECT_ALL_N_CANCEL_FIELD_LIST) {
		 if(SUCCESE_CHECK_CHECKBOX.isSelected())
		 {
			    SUCCESE_CHECK_CHECKBOX.setSelected(true);
		 }
		 else
		 {
			 SUCCESE_CHECK_CHECKBOX.setSelected(false);
		 }
	}
}

@FXML
public void SELECT_All_N_CANCEL(ActionEvent event)
{
	for (CheckBox SUCCESE_CHECK_CHECKBOX : SELECT_ALL_N_CANCEL_FIELD_LIST) {
	 if(SELECT_START == 0)
	 {	 
	    SUCCESE_CHECK_CHECKBOX.setSelected(true);
	    CANCEL.setText("해제");
	    CANCEL.setMinWidth(70.4);
	 }
	 if(SUCCESE_CHECK_CHECKBOX.isSelected() && SELECT_START == 1) { 	    	
		 SUCCESE_CHECK_CHECKBOX.setSelected(false);
		 CANCEL.setText("전체선택");
		 if(SUCCESE_CHECK_CHECKBOX.equals("selectNcancel19"))
		 {	 
			 SELECT_CHECK = false;
			 break;
		 }
	 }
}
	SELECT_START +=1;
	if(SELECT_START == 2)
		SELECT_START = 0;
}

@FXML
public void DELETE_LIST(ActionEvent event)
{
}
@Override
public void initialize(URL location, ResourceBundle resources) {
	String combo_box_name[] = {"HTML", "XML", "JSON"};
	ObservableList<String> stateList = FXCollections.observableArrayList(combo_box_name);
    combo_box0.setItems(stateList);

}
/*
public void comboChanged(ActionEvent event){
    System.out.println("chose the " + combo_box0.getValue().toString());
}
*/


}
