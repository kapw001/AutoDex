package autodex.com.autodex.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
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

public class SignUpActivity extends BaseActivity {


    private EditText name, phonenumber;
    private TextView signin;
    private Button signup;
    private TextInputLayout phonenumbertxt, nametxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);
        init();
        listener();

    }


    private void init() {
        phonenumber = (EditText) findViewById(R.id.phonenumber);
        name = (EditText) findViewById(R.id.name);
        phonenumbertxt = (TextInputLayout) findViewById(R.id.phonenumbertxt);
        nametxt = (TextInputLayout) findViewById(R.id.nametxt);
        signup = (Button) findViewById(R.id.signup);
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

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate(phonenumber.getText().toString(), name.getText().toString())) {
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

    private boolean validate(String pnumber, String n) {

        phonenumbertxt.setError(null);
        nametxt.setError(null);
        if (!Utility.emptyValdate(n)) {
            nametxt.setError("Name cannot be empty.");
            return false;
        } else if (!Utility.emptyValdate(pnumber)) {
            phonenumbertxt.setError("Enter a valid mobile number.");
            return false;
        } else {
            return true;
        }

    }
}
