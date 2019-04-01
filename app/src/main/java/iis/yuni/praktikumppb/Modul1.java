package iis.yuni.praktikumppb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Modul1 extends AppCompatActivity {

    Button btn_tugas_1;
    Button btn_tugas_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul1);

        btn_tugas_1 = findViewById(R.id.btn_tugas_1);
        btn_tugas_2 = findViewById(R.id.btn_tugas_2);
    }

    public void clik_btn_tgs_1(View view) {
        Intent clik = new Intent(Modul1.this, Modul1Tugas1.class);

        startActivity(clik);
    }

    public void clik_btn_tgs_2(View view) {
        Intent clik2 = new Intent(Modul1.this, Modul1Tugas2.class);

        startActivity(clik2);
    }
}
