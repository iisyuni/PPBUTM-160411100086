package iis.yuni.praktikumppb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginM4 extends AppCompatActivity {

    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_m4);

        user = findViewById(R.id.edt_username);
        pass = findViewById(R.id.edt_password);
    }

    public void cek_login(View view) {
        if (user.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"username tidak boleh kosong", Toast.LENGTH_LONG).show();
        }
        else if (pass.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"password tidak boleh kosong", Toast.LENGTH_LONG).show();
        }
        else{
            if (user.getText().toString().equals("iisyuni") && pass.getText().toString().equals("86") || user.getText().toString().equals("Iisyuni") && pass.getText().toString().equals("160411100086")){
                Intent i = new Intent(getApplicationContext(),Menu.class);
                startActivity(i);
                finish();
            }
            else{
                Toast.makeText(getApplicationContext(),"username atau password salah!!!", Toast.LENGTH_LONG).show();
            }
        }

    }
}
