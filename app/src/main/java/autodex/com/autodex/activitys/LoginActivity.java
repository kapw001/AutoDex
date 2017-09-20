package autodex.com.autodex.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import autodex.com.autodex.R;
import autodex.com.autodex.Utility;

/**
 * Created by yasar on 7/9/17.
 */

public class LoginActivity extends BaseActivity {

    private EditText phonenumber, password;
    private TextView signup, forgotPassword;
    private Button signin;

    private TextInputLayout phonenumbertxt, passwordtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signin);
        init();
        listener();

    }


    private void init() {
        phonenumber = (EditText) findViewById(R.id.phonenumber);
        password = (EditText) findViewById(R.id.password);
        phonenumbertxt = (TextInputLayout) findViewById(R.id.phonenumbertxt);
        passwordtxt = (TextInputLayout) findViewById(R.id.passwordtxt);

        signup = (TextView) findViewById(R.id.signup);
        forgotPassword = (TextView) findViewById(R.id.forgotpassword);

        signin = (Button) findViewById(R.id.signin);
    }


    private void listener() {

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(LoginActivity.this, "Sign In", Toast.LENGTH_SHORT).show();
                if (validate(phonenumber.getText().toString(), password.getText().toString())) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
//                transitionActivity();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                showT("Sign Up");

                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
//                transitionActivity();


            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForgotActivity.class);
                startActivity(intent);
//                transitionActivity();
            }
        });

    }


    private boolean validate(String pnumber, String pword) {

        phonenumbertxt.setError(null);
        passwordtxt.setError(null);
        if (!Utility.emptyValdate(pnumber)) {
            phonenumbertxt.setError("Enter a valid mobile number.");
            return false;
        } else if (!Utility.emptyValdate(pword)) {
            passwordtxt.setError("Password cannot be empty.");
            return false;
        } else {
            return true;
        }

    }

    public static void setErrorMsg(String msg, EditText viewId) {
        //Osama ibrahim 10/5/2013
        int ecolor = Color.BLACK; // whatever color you want
        String estring = msg;
        ForegroundColorSpan fgcspan = new ForegroundColorSpan(ecolor);
        SpannableStringBuilder ssbuilder = new SpannableStringBuilder(estring);
        ssbuilder.setSpan(fgcspan, 0, estring.length(), 0);
        viewId.setError(ssbuilder);

    }
}
