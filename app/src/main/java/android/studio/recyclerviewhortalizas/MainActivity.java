package android.studio.recyclerviewhortalizas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.studio.recyclerviewhortalizas.Models.adaptadorHortalizas;
import android.studio.recyclerviewhortalizas.Models.producto;
import android.studio.recyclerviewhortalizas.WebService.Asynchtask;
import android.studio.recyclerviewhortalizas.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    ArrayList<String> listDatos;
    RecyclerView recyclerview=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=(RecyclerView)findViewById(R.id.rcvListaHortalizas);

        //añadir un Divider a los elementos de la lista->Diseño de la linea de separacion de los items
        recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //Establecer el LayoutManager para definir la forma en la que se muestran los items en este caso en  forma de lista vertical
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Solicitud WebService
        //https://my-json-server.typicode.com/SuannyTigselema/productos/producto
        //https://mercado-a4435.firebaseio.com/producto.json
        Map<String, String> datos = new HashMap<>();
        WebService ws= new WebService("https://mercado-a4435.firebaseio.com/producto.json",datos,
                MainActivity.this, (Asynchtask) MainActivity.this);

        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlistaProductos = new JSONArray(result);
        ArrayList<producto> lstProductos=new ArrayList<producto>();

        //Invoco al metodo de la clase productos que es para el parseo de datos-me devuelve un arraylist de producto
        lstProductos = producto.JsonObjectsBuild(JSONlistaProductos);

        //HASTA AQUÍ SÍ RECIBE LOS 11 PRODUCTOS
        //Envío la lista de productos a l
        adaptadorHortalizas adapatorHortalizas = new adaptadorHortalizas(this, lstProductos);
        recyclerview.setAdapter(adapatorHortalizas);
    }
}
