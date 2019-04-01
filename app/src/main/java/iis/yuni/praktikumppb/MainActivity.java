package iis.yuni.praktikumppb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_modul_1;
    Button btn_modul_2;
    Button btn_modul_3;
    Button btn_modul_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_modul_1 = findViewById(R.id.btn_modul_1);
        btn_modul_2 = findViewById(R.id.btn_modul_2);
        btn_modul_3 = findViewById(R.id.btn_modul_3);
        btn_modul_4 = findViewById(R.id.btn_modul_4);

    }

    public void clik_btn_1(View view) {
        Intent clik = new Intent(MainActivity.this, Modul1.class);

        startActivity(clik);
    }

    public void clik_btn_2(View view) {
        Intent clik2 = new Intent(getApplicationContext(),Modul2.class);
        startActivity(clik2);
    }

    public void clik_btn_3(View view) {
        Intent clik3 = new Intent(getApplicationContext(),login.class);
        startActivity(clik3);
    }

    public void clik_btn_4(View view) {
        Intent clik4 = new Intent(getApplicationContext(),loginM4.class);
        startActivity(clik4);

    }
}
