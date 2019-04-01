package iis.yuni.praktikumppb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Modul2 extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul2);

        btn = findViewById(R.id.btn_tugas);
    }

    public void clik_btn_tgs(View view) {
        Intent clik =  new Intent(getApplicationContext(), Modul2Tugas1.class);
        startActivity(clik);
    }
}
