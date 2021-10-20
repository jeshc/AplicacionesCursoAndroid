package coursera.android.semana2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contacto> contacts;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        crearLista();
        inicilizarAdaptador();

        /*
        ListView lstContactos = findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,MyLstString));
        lstContactos.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this , DetalleContacto.class );
            intent.putExtra("nombre",contacts.get(position).getNombre());
            intent.putExtra("telefono",contacts.get(position).getTelefono());
            intent.putExtra("email",contacts.get(position).getEmail());
            Log.d("dev", "onCreate: Evento onItem");
            startActivity(intent);
            finish();
        });

        */
    }

    public void crearLista(){
        contacts = new ArrayList<>();
        contacts.add(new Contacto("Jose","55-6677-8899","jose@gmail.com",R.drawable.stripy_1 ));
        contacts.add(new Contacto("Diana","55-7733-8899","didi@gmail.com",R.drawable.stripy_bag));
        contacts.add(new Contacto("Angel","55-0080-8899","angel@gmail.com",R.drawable.stripy_halloween_basket_sweet));
        contacts.add(new Contacto("Santiago","55-1122-8899","santi@gmail.com",R.drawable.stripy_halloween_hat));
        contacts.add(new Contacto("Daniel","55-0000-8899","dany@gmail.com",R.drawable.stripy_halloween_basket_sweet));

    }

    public void inicilizarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contacts);
        listaContactos.setAdapter(adaptador);

    }
}