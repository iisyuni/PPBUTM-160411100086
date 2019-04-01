package iis.yuni.praktikumppb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Modul1Tugas1 extends AppCompatActivity {

    Button btn_tampil;
    EditText ketik_nama;
    TextView tampilan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul1_tugas1);

        btn_tampil = findViewById(R.id.btn_tampil);
        ketik_nama = findViewById(R.id.ketik_nama);
        tampilan = findViewById(R.id.tampilan);

    }

    public void klik_tampil(View view) {
        String nama = ketik_nama.getText().toString();
        tampilan.setText("Hallo " + nama);

    }
}
