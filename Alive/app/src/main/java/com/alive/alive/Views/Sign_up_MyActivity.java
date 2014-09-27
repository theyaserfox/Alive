package com.alive.alive.Views;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alive.alive.Controllers.UserController;
import com.alive.alive.Models.AppCommon.User;
import com.alive.alive.R;

public class Sign_up_MyActivity extends Activity {
    protected AutoCompleteTextView username;
    protected AutoCompleteTextView email;
    protected EditText password;
    protected AutoCompleteTextView phone;
    protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = (AutoCompleteTextView)findViewById(R.id.username);
        email = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        password = (EditText)findViewById(R.id.password);
        phone = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);

        button = (Button)findViewById(R.id.email_sign_up_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserController userController = new UserController();
                userController.CreateUser(email.toString(), username.toString(), password.toString());
                Toast.makeText(getApplication(), "Registered Successfully", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign_up__my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
