package iis.yuni.praktikumppb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Modul1Tugas2 extends AppCompatActivity {

    Button btn_hitung;
    EditText berat_badan;
    EditText tinggi_badan;
    TextView hasil_perhitungan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul1_tugas2);

        btn_hitung = findViewById(R.id.btn_hitung);
        berat_badan = findViewById(R.id.berat_badan);
        tinggi_badan = findViewById(R.id.tinggi_badan);
        hasil_perhitungan = findViewById(R.id.hasil_perhitungan);

    }

    public void menghitung(View view) {
        double berat, tinggi, BMI;

        berat = Double.parseDouble(berat_badan.getText().toString());
        tinggi = Double.parseDouble(tinggi_badan.getText().toString());

        BMI = berat / ((tinggi / 100) * (tinggi / 100));


        if (BMI < 18.5) {
            hasil_perhitungan.setText(Double.toString(BMI) + " " + "Underweight");
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            hasil_perhitungan.setText(Double.toString(BMI) + " " + "Normal Weight");

        } else if (BMI >= 25 && BMI <= 29.9) {
            hasil_perhitungan.setText(Double.toString(BMI) + " " + "Over Weight");

        } else if (BMI >= 30 && BMI <= 34.9) {
            hasil_perhitungan.setText(Double.toString(BMI) + " " + "Obesity 1");

        } else if (BMI >= 35 && BMI <= 39.9) {
            hasil_perhitungan.setText(Double.toString(BMI) + " " + "Obesity 2");

        } else {
            hasil_perhitungan.setText(Double.toString(BMI) + " " + "Obesity 3");

        }
    }
}
