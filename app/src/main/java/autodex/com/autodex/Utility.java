package autodex.com.autodex;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by yasar on 7/9/17.
 */

public class Utility {


    private static final String TAG = "Utils";
    private static ProgressDialog progressDialog;

    public static void showProgress(Context context, String msg) {
        if (!((Activity) context).isFinishing()) {
            //show dialog

            progressDialog = new ProgressDialog(context);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage(msg);
            progressDialog.setCancelable(true);
            progressDialog.show();
        }
    }

    public static void hideProgress() {
        if (progressDialog != null) {
            progressDialog.cancel();
        }
    }


    public static void showMsg(Context context, String msg) {
        Toast.makeText(context, "" + msg, Toast.LENGTH_SHORT).show();
    }


    public static boolean emptyValdate(String values) {

        return (values != null && values.length() > 0) ? true : false;
    }

    public static boolean validateNumber(String S) {
        String Regex = "[^\\d]";
        String PhoneDigits = S.replaceAll(Regex, "");
//        return (PhoneDigits.length() != 10);
        return (PhoneDigits.length() != 10);
    }


}
