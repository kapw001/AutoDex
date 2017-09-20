package autodex.com.autodex.activitys;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import autodex.com.autodex.R;
import autodex.com.autodex.Utility;

/**
 * Created by yasar on 7/9/17.
 */

public class ForgotActivity extends BaseActivity {


    private EditText phonenumber;
    private TextView signin;
    private Button forgotpassword;
    private TextInputLayout phonenumbertxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgotpassword);
        init();
        listener();

    }


    private void init() {
        phonenumber = (EditText) findViewById(R.id.phonenumber);
        forgotpassword = (Button) findViewById(R.id.forgotpassword);
        phonenumbertxt = (TextInputLayout) findViewById(R.id.phonenumbertxt);
        signin = (TextView) findViewById(R.id.signin);
    }


    private void listener() {

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.slide_out_down, R.anim.slide_in_down);
                onBackPressed();
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate(phonenumber.getText().toString())) {
                    showT("Success");
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_out_down, R.anim.slide_in_down);

    }

    private boolean validate(String pnumber) {

        phonenumbertxt.setErrorEnabled(false);
        phonenumbertxt.setError(null);
        if (!Utility.emptyValdate(pnumber)) {
            phonenumbertxt.setErrorEnabled(true);
            phonenumbertxt.setError("Enter a valid mobile number.");
            return false;
        } else {
            return true;
        }

    }
}
