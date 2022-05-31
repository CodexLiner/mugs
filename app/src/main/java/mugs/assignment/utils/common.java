package mugs.assignment.utils;

import android.widget.EditText;

public class common {
    private static final String required = "required";
    public static boolean isEmpty(EditText text){
        if (text == null || (text.getText().toString().equals(""))){
            text.setError(required);
            return false;
        }
        return true;
    }
}
