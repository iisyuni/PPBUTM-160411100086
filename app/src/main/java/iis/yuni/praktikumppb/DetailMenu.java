package iis.yuni.praktikumppb;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailMenu extends AppCompatActivity {

    TextView judulMenu,hargaMenu,keterangan,jumlah1;
    ImageView image;
    String [] jMenu,hMenu,ketMenu;
    Integer [] imageDrawable={R.drawable.expresso,R.drawable.americano,R.drawable.cappuccino,
            R.drawable.latte, R.drawable.mochaccino};
    String[] ksp={"menu1","menu2","menu3","menu4","menu5"};
    int indek;
    String jumlahPesanan;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        sp = getSharedPreferences("jumPesanan", Context.MODE_PRIVATE);
        spEditor = sp.edit();

        image = findViewById(R.id.image);
        judulMenu = findViewById(R.id.judulMenu);
        hargaMenu = findViewById(R.id.hargaMenu);
        keterangan = findViewById(R.id.keterangan);
        jumlah1 = findViewById(R.id.jumlah1);

        jMenu = getResources().getStringArray(R.array.jMenu);
        hMenu = getResources().getStringArray(R.array.hMenu);
        ketMenu = getResources().getStringArray(R.array.ketMenu);
        indek = Integer.parseInt(getIntent().getStringExtra("indek"));

        image.setImageResource(imageDrawable[indek]);
        judulMenu.setText(jMenu[indek]);
        hargaMenu.setText(getString(R.string.tHarga)+hMenu[indek]);
        keterangan.setText(ketMenu[indek]);
        jumlahPesanan=sp.getString(ksp[indek], "");
        jumlah1.setText(jumlahPesanan);
    }

    public void pesan(View view) {
        Toast.makeText(getApplication(), "Pesanan berhasil disimpan", Toast.LENGTH_LONG).show();
        spEditor.putString(ksp[indek], jumlah1.getText().toString());

        spEditor.putString("back", "true");
        spEditor.commit();
        finish();
    }

    public void plus(View view) {
        int nilai=Integer.parseInt(jumlah1.getText().toString());
        if(nilai<100){
            jumlah1.setText(Integer.toString(nilai+1));
        }
    }

    public void min(View view) {
        int nilai=Integer.parseInt(jumlah1.getText().toString());
        if(nilai>0){
            jumlah1.setText(Integer.toString(nilai-1));
        }
    }


}
