package iis.yuni.praktikumppb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class struk_pembelian extends AppCompatActivity {

    TextView lbl_nm, nm_pelanggan, pesan1, ttl1, jumlah1, pesan2, ttl2, jumlah2, pesan3, ttl3, jumlah3, total, jumlah4, pembayaran, kembalian, jumlah6;
    EditText jumlah5;
    Button button_byr;
    String uangKurang, errorbyr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk_pembelian);

        lbl_nm = findViewById(R.id.label_nama);
        nm_pelanggan = findViewById(R.id.nama_pelanggan);

        pesan1 = findViewById(R.id.Pesan1);
        pesan2 = findViewById(R.id.Pesan2);
        pesan3 = findViewById(R.id.Pesan3);

        ttl1 = findViewById(R.id.ttl1);
        ttl2 = findViewById(R.id.ttl2);
        ttl3 = findViewById(R.id.ttl3);

        jumlah1 = findViewById(R.id.jumlah1);
        jumlah2 = findViewById(R.id.jumlah2);
        jumlah3 = findViewById(R.id.jumlah3);
        jumlah4 = findViewById(R.id.jumlah4);
        jumlah5 = findViewById(R.id.jumlah5);
        jumlah6 = findViewById(R.id.jumlah6);

        total = findViewById(R.id.total);
        pembayaran = findViewById(R.id.pembayaran);
        kembalian = findViewById(R.id.kembalian);
        button_byr = findViewById(R.id.button_byr);

        nm_pelanggan.setText(getIntent().getStringExtra("nama"));
        if(getIntent().getStringExtra("bahasa").equals("inggris")) {
            lbl_nm.setText("Customer Name");
            pembayaran.setText("Payment");
            kembalian.setText("Change");
            button_byr.setText("Pay");
            errorbyr = "Empty Payment";
            uangKurang = "Less Payment";

        }else {
            lbl_nm.setText("Nama Pembeli");
            pembayaran.setText("Pembeyaran");
            kembalian.setText("Kembalian");
            button_byr.setText("Bayar");
            errorbyr = "Pembayaran Kosong";
            uangKurang = "Pembayaran Kurang";

        }
        if(getIntent().getStringExtra("c1").equals("true")){
            pesan1.setText(getIntent().getStringExtra("arabica"));
            ttl1.setText(getIntent().getStringExtra("arabica1"));
            jumlah1.setText(getIntent().getStringExtra("arabica2"));
        }else{
            RelativeLayout RL1 = findViewById(R.id.RL1);
            RL1.setVisibility(View.GONE);
        }
        if(getIntent().getStringExtra("c2").equals("true")){
            pesan2.setText(getIntent().getStringExtra("robusta"));
            ttl2.setText(getIntent().getStringExtra("robusta1"));
            jumlah2.setText(getIntent().getStringExtra("robusta2"));
        }else{
            RelativeLayout RL2 = findViewById(R.id.RL2);
            RL2.setVisibility(View.GONE);
        }
        if(getIntent().getStringExtra("c3").equals("true")){
            pesan3.setText(getIntent().getStringExtra("american"));
            ttl3.setText(getIntent().getStringExtra("american1"));
            jumlah3.setText(getIntent().getStringExtra("american2"));
        }else{
            RelativeLayout RL3 = findViewById(R.id.RL3);
            RL3.setVisibility(View.GONE);
        }
        jumlah4.setText(getIntent().getStringExtra("total"));

    }


    public void bayar(View view) {
        if (jumlah5.getText().toString().isEmpty()){
            jumlah5.setError(errorbyr);
        }else{
            Integer t = Integer.parseInt(jumlah4.getText().toString());
            Integer u = Integer.parseInt(jumlah5.getText().toString());

            if (t <= u) {
                jumlah6.setText(Integer.toString(u - t));
            }else{
                Toast.makeText(getApplicationContext(), uangKurang, Toast.LENGTH_LONG).show();
            }
        }
    }
}
