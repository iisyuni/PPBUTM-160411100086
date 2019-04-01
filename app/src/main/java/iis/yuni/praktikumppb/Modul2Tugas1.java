package iis.yuni.praktikumppb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Modul2Tugas1 extends AppCompatActivity {

    RadioButton bhs_ing, bhs_indo, hang, hang1, hang2, ding,ding1,ding2;
    CheckBox arabica, robusta, americano;
    EditText nama, jmlh, jmlh1, jmlh2, bayaran;
    Button pesan, bayar;
    Button min_arabica, plus_arabica, min_robusta, plus_robusta, min_americano, plus_americano;
    TextView total, kembalian, label_nama,label_bayar, label_total, label_kembalian, label_menu, label_sajian, label_jumlah;
    Integer total_hrg = 0;
    String errorNama, uangKurang, errorbyr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul2_tugas1);

        bhs_ing = findViewById(R.id.bhs_ing);
        bhs_indo = findViewById(R.id.bhs_indo);

        label_nama = findViewById(R.id.label_nama);
        label_bayar = findViewById(R.id.label_bayar);
        label_total = findViewById(R.id.label_total);
        label_kembalian = findViewById(R.id.label_kembalian);
        label_menu = findViewById(R.id.label_menu);
        label_sajian = findViewById(R.id.label_sajian);
        label_jumlah = findViewById(R.id.label_jumlah);


        nama = findViewById(R.id.edit_nama);
        bayaran = findViewById(R.id.isi_bayar);

        arabica = findViewById(R.id.arabica);
        robusta = findViewById(R.id.robusta);
        americano = findViewById(R.id.americano);

        jmlh = findViewById(R.id.bnyk_pesanan);
        jmlh1 = findViewById(R.id.bnyk_pesanan1);
        jmlh2 = findViewById(R.id.bnyk_pesanan2);

        hang = findViewById(R.id.radio_hang);
        hang1 = findViewById(R.id.radio_hang1);
        hang2 = findViewById(R.id.radio_hang2);

        ding = findViewById(R.id.radio_ding);
        ding1 = findViewById(R.id.radio_ding1);
        ding2 = findViewById(R.id.radio_ding2);

        pesan = findViewById(R.id.order);
        bayar = findViewById(R.id.btn_bayar);
        total = findViewById(R.id.isi_total);
        kembalian = findViewById(R.id.isi_kembalian);

        min_arabica = findViewById(R.id.min);
        min_robusta = findViewById(R.id.min1);
        min_americano = findViewById(R.id.min2);

        plus_arabica = findViewById(R.id.plus);
        plus_robusta = findViewById(R.id.plus1);
        plus_americano = findViewById(R.id.plus2);
    }

    public void min_arabica(View view) {
        Integer jumlah = (Integer.parseInt(jmlh.getText().toString())-1);
        if(jumlah < 0){
            jumlah = 0;
        }
        jmlh.setText(Integer.toString(jumlah));
    }

    public void plus_arabica(View view) {
        jmlh.setText(Integer.toString(Integer.parseInt(jmlh.getText().toString())+1));
    }

    public void min_robusta(View view) {
        Integer jumlah = (Integer.parseInt(jmlh1.getText().toString())-1);
        if(jumlah < 0){
            jumlah = 0;
        }
        jmlh1.setText(Integer.toString(jumlah));
    }

    public void plus_robusta(View view) {
        jmlh1.setText(Integer.toString(Integer.parseInt(jmlh1.getText().toString())+1));
    }

    public void min_americano(View view) {
        Integer jumlah = (Integer.parseInt(jmlh2.getText().toString())-1);
        if(jumlah < 0){
            jumlah = 0;
        }
        jmlh2.setText(Integer.toString(jumlah));
    }

    public void plus_americano(View view) {
        jmlh2.setText(Integer.toString(Integer.parseInt(jmlh2.getText().toString())+1));
    }

    public void memesan(View view) {
        total_hrg = 0;
        if(nama.getText().toString().isEmpty()) {
            nama.setError(errorNama);
        } else {
            if (arabica.isChecked()) {
                if (ding.isChecked()) {
                    total_hrg += (8000 * Integer.parseInt(jmlh.getText().toString()));
                } else {
                    total_hrg += (7000 * Integer.parseInt(jmlh.getText().toString()));
                }
            }
            if (robusta.isChecked()) {
                if (ding1.isChecked()) {
                    total_hrg += (9000 * Integer.parseInt(jmlh1.getText().toString()));
                } else {
                    total_hrg += (8000 * Integer.parseInt(jmlh1.getText().toString()));
                }
            }
            if (americano.isChecked()) {
                if (ding2.isChecked()) {
                    total_hrg += (10000 * Integer.parseInt(jmlh2.getText().toString()));
                } else {
                    total_hrg += (9000 * Integer.parseInt(jmlh2.getText().toString()));
                }
            }
            total.setText("Rp. " + Integer.toString(total_hrg));
        }
    }

    public void bayar_pesanan(View view) {
        if(bayaran.getText().toString().isEmpty()){
            bayaran.setError(errorbyr);
        }else{
            Integer sisa =  Integer.parseInt(bayaran.getText().toString()) - total_hrg;
            if(sisa < 0){
                Toast.makeText(getApplicationContext(), uangKurang, Toast.LENGTH_SHORT).show();
            }
            else {
                kembalian.setText(" Rp. "+ Integer.toString(sisa));
            }
        }
    }

    public void id(View view) {
        label_bayar.setText("Bayar :");
        label_kembalian.setText("Kembalian :");
        label_nama.setText("Nama Pemesan");
        label_sajian.setText("Sajian");
        label_jumlah.setText("Jumlah ");
        label_total.setText("Jumlah Harga :");
        hang.setText("Hangat");
        hang1.setText("Hangat");
        hang2.setText("Hangat");
        ding.setText("Dingin");
        ding1.setText("Dingin");
        ding2.setText("Dingin");
        bayar.setText("Bayar");
        pesan.setText("Pesan");
        nama.setHint("Masukkan Nama Anda");
        bayaran.setHint("Masukkan Nominal Pembayaran");
        errorbyr = "Pembayaran Kosong";
        uangKurang = "Pembayaran Kurang";
        errorNama = "Nama Kosong";

    }

    public void en(View view) {
        label_bayar.setText("Your Paid :");
        label_kembalian.setText("Change :");
        label_nama.setText("Name Of The Buyer");
        label_sajian.setText("Dish");
        label_jumlah.setText("Total");
        label_total.setText("Total Price :");
        hang.setText("Hot");
        hang1.setText("Hot");
        hang2.setText("Hot");
        ding.setText("Cold");
        ding1.setText("Cold");
        ding2.setText("Cold");
        bayar.setText("Pay");
        pesan.setText("Order");
        nama.setHint("Enter Your Name");
        bayaran.setHint("Enter Payment Amount");
        errorbyr = "Empty Payment";
        uangKurang = "Less Payment";
        errorNama = "Empty Name";

    }
}
