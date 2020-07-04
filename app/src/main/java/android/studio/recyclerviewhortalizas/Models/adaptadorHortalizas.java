package android.studio.recyclerviewhortalizas.Models;

import android.content.Context;
import android.studio.recyclerviewhortalizas.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adaptadorHortalizas extends RecyclerView.Adapter<adaptadorHortalizas.MyViewHolder> {
    private static final int TYPE_HEADER=0;
    private static final int TYPE_LIST=0;


    private Context mContext;

    //Lista de productos q va a llegar al adaptador
    private ArrayList<producto> mLista;
    public TextView nombre;
    public TextView lblNombre;
    public TextView lblDescripcion;
    public TextView lblPrecio;
    public TextView lblUnidad;
    public TextView lblHeader;
    public ImageView imgFoto;

    public adaptadorHortalizas(Context context, ArrayList<producto> lista) {
        mContext = context;
        mLista=lista;
    }

    //Métodos propios del RecyclerdView

    //infla los items al recyclerd
    @NonNull
    @Override
    public adaptadorHortalizas.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
           view= LayoutInflater.from(mContext)
                   .inflate(R.layout.ly_itemhortalizas,null,false);
           return new MyViewHolder(view);

    }

    //enlaza cada vista del viewholder con los datos de la Lista de productos
    @Override
    public void onBindViewHolder(@NonNull adaptadorHortalizas.MyViewHolder holder, int position) {

        lblNombre.setText(mLista.get(position).getNombre());
        lblDescripcion.setText(mLista.get(position).getDescripcion());
        lblPrecio.setText(mLista.get(position).getPrecio());
        lblUnidad.setText(mLista.get(position).getUnidad());
        Glide.with(mContext)
                .load(mLista.get(position).getUrl())
                .into(imgFoto);
    }

    //Devuelve la cantidad del elementos del recyclerd
    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        int view_type;
        //Obtener los elementos q irán en cada item
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

                lblNombre=(TextView)itemView.findViewById(R.id.lblNombre);
                lblDescripcion=(TextView)itemView.findViewById(R.id.lblDescripcion);
                lblPrecio=(TextView)itemView.findViewById(R.id.lblPrecio);
                lblUnidad=(TextView)itemView.findViewById(R.id.lblUnidad);
                imgFoto=(ImageView) itemView.findViewById(R.id.imageView);

        }
    }

}
