package com.example.logintable;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.logintable.controllers.LoginTable_Controller;

public class LoginTable_Activity extends AppCompatActivity {

    private LoginTable_Controller loginTableController;
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_table);
        loginTableController = new LoginTable_Controller();
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String password = edtPassword.getText().toString();

                if ((TextUtils.isEmpty(user)) || (TextUtils.isEmpty(password))) {
                    Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.data_empty), Toast.LENGTH_SHORT).show();
                }
                else {
                    int resultCode = loginTableController.validateCredentials(user, password);

                    switch (resultCode) {
                        case LoginTable_Controller.PASSWORD_DIGIT:
                            Snackbar.make(v, getResources().getString(R.string.password_digit), Snackbar.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.PASSWORD_CASE:
                            Snackbar.make(v, getResources().getString(R.string.password_case), Snackbar.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.PASSWORD_LENGTH:
                            Snackbar.make(v, getResources().getString(R.string.password_length), Snackbar.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.OK:
                            // Se lanzaria la Activity después del login
                            break;
                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues();
            }
        });
    }

    private void resetValues() {
        edtUser.setText("");
        edtPassword.setText("");
    }
}
