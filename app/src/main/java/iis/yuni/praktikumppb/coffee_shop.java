package iis.yuni.praktikumppb;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class coffee_shop extends AppCompatActivity {

    RadioButton bhs_ing, bhs_indo, hang, hang1, hang2, ding,ding1,ding2;
    CheckBox arabica, robusta, americano;
    EditText nama, jmlh, jmlh1, jmlh2, bayaran;
    Button pesan, bayar;
    Button min_arabica, plus_arabica, min_robusta, plus_robusta, min_americano, plus_americano;
    TextView total, kembalian, label_nama,label_bayar, label_total, label_kembalian, label_menu, label_sajian, label_jumlah;
    Integer total_hrg = 0;
    String errorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shop);

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
        String bahasa;
        if(bhs_ing.isChecked()){
            bahasa = "inggris";
        }else{
            bahasa = "indonesia";
        }
        total_hrg = 0;
        Intent p = new Intent(getApplicationContext(), struk_pembelian.class);
        p.putExtra("bahasa", bahasa);
        p.putExtra("c1","false");
        p.putExtra("c2","false");
        p.putExtra("c3","false");
        if(nama.getText().toString().isEmpty()) {
            nama.setError(errorName);
        } else {
            int harga1;
            p.putExtra("nama",nama.getText().toString());
            if (arabica.isChecked()) {
                p.putExtra("c1","true");
                p.putExtra("arabica", arabica.getText().toString());
                if (ding.isChecked()) {
                    harga1 = (8000 * Integer.parseInt(jmlh.getText().toString()));
                } else {
                    harga1 = (7000 * Integer.parseInt(jmlh.getText().toString()));
                }
                p.putExtra("arabica1", jmlh.getText().toString());
                total_hrg += harga1;
                p.putExtra("arabica2", Integer.toString(harga1));
            }
            int harga2;
            if (robusta.isChecked()) {
                p.putExtra("c2","true");
                p.putExtra("robusta", robusta.getText().toString());
                if (ding1.isChecked()) {
                    harga2 = (9000 * Integer.parseInt(jmlh1.getText().toString()));
                } else {
                    harga2 = (8000 * Integer.parseInt(jmlh1.getText().toString()));
                }
                p.putExtra("robusta1", jmlh1.getText().toString());
                total_hrg += harga2;
                p.putExtra("robusta2", Integer.toString(harga2));
            }
            int harga3;
            if (americano.isChecked()) {
                p.putExtra("c3","true");
                p.putExtra("american", americano.getText().toString());
                if (ding2.isChecked()) {
                    harga3 = (10000 * Integer.parseInt(jmlh2.getText().toString()));
                } else {
                    harga3 = (9000 * Integer.parseInt(jmlh2.getText().toString()));
                }
                p.putExtra("american1", jmlh2.getText().toString());
                total_hrg += harga3;
                p.putExtra("american2", Integer.toString(harga3));
            }
            p.putExtra("total", Integer.toString(total_hrg));
            startActivity(p);
        }
    }

    public void id(View view) {
        label_nama.setText("Nama Pemesan");
        label_sajian.setText("Sajian");
        label_jumlah.setText("Jumlah ");
        hang.setText("Hangat");
        hang1.setText("Hangat");
        hang2.setText("Hangat");
        ding.setText("Dingin");
        ding1.setText("Dingin");
        ding2.setText("Dingin");
        pesan.setText("Pesan");
        nama.setHint("Masukkan Nama Anda");
        errorName = "Nama Kosong";
    }

    public void en(View view) {
        label_nama.setText("Name Of The Buyer");
        label_sajian.setText("Dish");
        label_jumlah.setText("Total");
        hang.setText("Hot");
        hang1.setText("Hot");
        hang2.setText("Hot");
        ding.setText("Cold");
        ding1.setText("Cold");
        ding2.setText("Cold");
        pesan.setText("Order");
        nama.setHint("Enter Your Name");
        errorName = "Empty Name";
    }

    public void callme(View view) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:085232829303"));
        startActivity(call);
    }
}
