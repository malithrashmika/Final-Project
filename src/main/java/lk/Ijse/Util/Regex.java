package lk.Ijse.Util;

import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean isTextFieldValid(TextFieldRegex textField,String text) {
        String filed="";
        switch (textField) {
            case ID:
                filed="^([A-Z][0-9]{3})$";
                break;
            case NAME:
                filed="^[A-z|\\\\s]{3,}$";
                break;
            case PRICE:
                filed=text;
                break;
            case ADDRESS:
                filed=text;
                break;
            case CONTACT:
                filed=text;
                break;
            case SALARY:
                filed=text;
                break;
        }
        Pattern pattern = Pattern.compile(filed);
        if (text!=null){
            if (text.trim().isEmpty()){
                return false;
            }
        }else {
            return false;
        }
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()){
            return true;
        }
        return true;
    }
    public static boolean setTextColor(TextFieldRegex location, TextField textField) {
        if (Regex.isTextFieldValid(location,textField.getText())){
            textField.setStyle("-fx-background-color: rgba(0,255,0,255);");
            return true;
        }else {
            textField.setStyle("-fx-background-color: rgba(255,0,0,255);");
            return false;
        }
    }
}

