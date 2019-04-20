package iis.yuni.praktikumppb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    RecyclerView menu;
    String[] ksp={"menu1","menu2","menu3","menu4","menu5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu= findViewById(R.id.Menu);
        sp = getSharedPreferences("jumPesanan", Context.MODE_PRIVATE);
        spEditor = sp.edit();

        RecyclerAdapter adapter=new RecyclerAdapter(this);
        //membuat adapter baru untuk reyclerview
        menu.setAdapter(adapter);
        //menset nilai dari adapter
        menu.setHasFixedSize(true);
        //menset setukuran
        menu.setLayoutManager(new LinearLayoutManager(this));

        if (sp.getString("back", "").equals("true")){
            spEditor.putString("back", "false");
            spEditor.commit();
            Intent intent=new Intent(getApplication(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu1){
            startActivity(new Intent(this, aboutM4.class));
        }
        if (item.getItemId() == R.id.menu2) {
            spEditor.putBoolean("login",false);
            spEditor.commit();
            Intent intent=new Intent(getApplication(),loginM4.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void order(View view) {
        String m1=sp.getString(ksp[0], "");
        String m2=sp.getString(ksp[1], "");
        String m3=sp.getString(ksp[2], "");
        String m4=sp.getString(ksp[3], "");
        String m5=sp.getString(ksp[4], "");

        if (m1.equals("0") && m2.equals("0") && m3.equals("0")&& m4.equals("0")&& m5.equals("0")){
            Toast.makeText(getApplication(), "Pesanan kosong", Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent=new Intent(getApplication(),NotaPembelian.class);
            startActivity(intent);
        }
    }
}
