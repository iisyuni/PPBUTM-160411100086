package iis.yuni.praktikumppb;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView tv1,tv2;
    ImageView imageView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        tv1= itemView.findViewById(R.id.daftar_judul);
        tv2= itemView.findViewById(R.id.daftar_harga);
        imageView= itemView.findViewById(R.id.daftar_icon);
    }
}
