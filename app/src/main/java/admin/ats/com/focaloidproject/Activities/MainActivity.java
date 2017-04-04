package admin.ats.com.focaloidproject.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import admin.ats.com.focaloidproject.Home;
import admin.ats.com.focaloidproject.R;

public class MainActivity extends AppCompatActivity {
    EditText uname,pwd;
    TextView forgot,signup;
    Button login;
    String username,password;
    SQLiteDatabase db=null;
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=(EditText)findViewById(R.id.uname);
        pwd=(EditText)findViewById(R.id.pwd);
        forgot=(TextView)findViewById(R.id.forgot);
        signup=(TextView)findViewById(R.id.signup);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = uname.getText().toString();
                password = pwd.getText().toString();
               db = SQLiteDatabase.openDatabase("data/data/admin.ats.com.focaloidproject/databases/pjt_db", null, SQLiteDatabase.OPEN_READONLY);
                String s = "select username,password from RegistrationData";
                Cursor c = db.rawQuery(s, null);
                if (c != null) {
                    if (c.moveToFirst()) {
                        do {
                            String UserName = c.getString(c.getColumnIndex("username"));
                            Log.e("username", UserName);
                            String Password = c.getString(c.getColumnIndex("password"));
                            Log.e("password", Password);
                            if ((UserName.equals(username)) && (Password.equals(password))) {
                                 flag = 1;
                            }

                        } while (c.moveToNext());
                    }
                }
                if(flag==1){
                    Intent i=new Intent(MainActivity.this,Home.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"U must Register",Toast.LENGTH_LONG).show();
                }
            }

        });


        //Signup procedures
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Signup.class);
                startActivity(i);
            }
        });
    }
}
