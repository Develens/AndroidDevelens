package com.develens.andydevelens;

import android.content.Context;
import android.widget.EditText;

import java.util.ArrayList;

public class Services {

    private Context context;

    public Services(Context context){
        this.context = context;
    }

    public String EdittextFieldsValidation(ArrayList<EditText> list) {
        String checking = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().toString().trim().equalsIgnoreCase("")) {
                list.get(i).setError("This Field is empty");
                checking = "Failed";
                break;
            } else {
                checking = "Success";
            }
        }
        if (checking.equals("Success")){
            return "Success";
        }else {
            return "Failed";
        }
    }

}
