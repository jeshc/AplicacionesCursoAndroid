package coursera.android.ejemplomenusandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvNombre = findViewById(R.id.tvNombre);
        registerForContextMenu(tvNombre);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnuAbout:
                Intent intentAbout = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intentAbout);
                break;
            case R.id.mnuSettings:
                Intent intentSettings = new Intent(MainActivity.this,SettingsActovity.class);
                startActivity(intentSettings);

                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemEdit:
                // Intent
                Toast.makeText(this,"Menu Editar",Toast.LENGTH_LONG).show();
                break;
            case R.id.itemEliminar:
                //Intent

                Toast.makeText(this,"Menu Eliminar",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    public void levantarMenuPopup( View v){
        ImageView imgSol = findViewById(R.id.imgSol);
        PopupMenu popupMenu = new PopupMenu(this, imgSol);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getBaseContext(),"usaste la opcion:" + item.toString(),Toast.LENGTH_LONG ).show();
                return true;
            }
        });

        popupMenu.show();
    }
}