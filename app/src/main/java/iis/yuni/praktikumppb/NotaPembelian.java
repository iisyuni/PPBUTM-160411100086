package iis.yuni.praktikumppb;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NotaPembelian extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    String[] ksp={"menu1","menu2","menu3","menu4", "menu5"};
    TextView cMenu1,cMenu2,cMenu3, cMenu4, cMenu5;
    TextView toMenu1,toMenu2,toMenu3, toMenu4, toMenu5;
    TextView jTotal,kembalian;
    EditText pembayaran;
    String[] harga;
    Integer total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_pembelian);

        sp = getSharedPreferences("jumPesanan", Context.MODE_PRIVATE);
        spEditor = sp.edit();
        harga = getResources().getStringArray(R.array.hMenu);

        cMenu1=findViewById(R.id.CMenu1);
        cMenu2=findViewById(R.id.CMenu2);
        cMenu3=findViewById(R.id.CMenu3);
        cMenu4=findViewById(R.id.CMenu4);
        cMenu5=findViewById(R.id.CMenu5);

        toMenu1=findViewById(R.id.ToMenu1);
        toMenu2=findViewById(R.id.ToMenu2);
        toMenu3=findViewById(R.id.ToMenu3);
        toMenu4=findViewById(R.id.ToMenu4);
        toMenu5=findViewById(R.id.ToMenu5);

        jTotal=findViewById(R.id.JTotal);
        kembalian=findViewById(R.id.JKembalian);
        pembayaran=findViewById(R.id.JPembayaran);

        String m1=sp.getString(ksp[0], "");
        String m2=sp.getString(ksp[1], "");
        String m3=sp.getString(ksp[2], "");
        String m4=sp.getString(ksp[3], "");
        String m5=sp.getString(ksp[4], "");

        total=0;
        if (Integer.parseInt(m1)>0){
            cMenu1.setText("x "+m1);
            Integer jumlah = Integer.parseInt(harga[0])*Integer.parseInt(m1);
            toMenu1.setText(Integer.toString(jumlah));
            total+=jumlah;
            RelativeLayout RL=findViewById(R.id.RL1);
            RL.setVisibility(View.VISIBLE);
        }
        if (Integer.parseInt(m2)>0){
            cMenu2.setText("x "+m2);
            Integer jumlah = Integer.parseInt(harga[1])*Integer.parseInt(m2);
            toMenu2.setText(Integer.toString(jumlah));
            total+=jumlah;
            RelativeLayout RL=findViewById(R.id.RL2);
            RL.setVisibility(View.VISIBLE);
        }
        if (Integer.parseInt(m3)>0){
            cMenu3.setText("x "+m3);
            Integer jumlah = Integer.parseInt(harga[2])*Integer.parseInt(m3);
            toMenu3.setText(Integer.toString(jumlah));
            total+=jumlah;
            RelativeLayout RL=findViewById(R.id.RL3);
            RL.setVisibility(View.VISIBLE);
        }
        if (Integer.parseInt(m4)>0){
            cMenu4.setText("x "+m4);
            Integer jumlah = Integer.parseInt(harga[3])*Integer.parseInt(m4);
            toMenu4.setText(Integer.toString(jumlah));
            total+=jumlah;
            RelativeLayout RL=findViewById(R.id.RL4);
            RL.setVisibility(View.VISIBLE);
        }
        if (Integer.parseInt(m5)>0){
            cMenu5.setText("x "+m5);
            Integer jumlah = Integer.parseInt(harga[4])*Integer.parseInt(m5);
            toMenu5.setText(Integer.toString(jumlah));
            total+=jumlah;
            RelativeLayout RL=findViewById(R.id.RL5);
            RL.setVisibility(View.VISIBLE);
        }
        jTotal.setText(Integer.toString(total));
    }

    public void bayar(View view) {
        if (pembayaran.getText().toString().isEmpty()){
            Toast.makeText(getApplication(), "Masukan uang pembayaran", Toast.LENGTH_LONG).show();
        }
        else {
            Integer bayar = Integer.parseInt(pembayaran.getText().toString());
            if (bayar >= total) {
                kembalian.setText(Integer.toString(bayar - total));
                Toast.makeText(getApplication(), "Berhasil dibayar", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplication(), "Uang kurang", Toast.LENGTH_LONG).show();
            }
        }
    }
}
