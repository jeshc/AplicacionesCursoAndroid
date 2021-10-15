package coursera.android.semana2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.net.URI;

public class DetalleContacto extends AppCompatActivity {
    Bundle parametros;
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {Manifest.permission.READ_CONTACTS, Manifest.permission.CALL_PHONE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        parametros = getIntent().getExtras();

        tvNombre = findViewById(R.id.tvNombre);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        SetVista();
    }

    private void SetVista(){
        tvNombre.setText(parametros.getString("nombre"));
        tvTelefono.setText(parametros.getString("telefono"));
        tvEmail.setText(parametros.getString("email"));
    }

    public void llamar(View view) {

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ tvNombre.getText().toString())));

        }else{
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ tvNombre.getText().toString())));

        }

    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public void enviarMail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL , tvEmail.getText().toString() );
        startActivity(Intent.createChooser(emailIntent,"Email"));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        Intent intent;
        if(keyCode == KeyEvent.KEYCODE_BACK){
            intent = new Intent(DetalleContacto.this,MainActivity.class);
            startActivity(intent);

        }
        return super.onKeyDown(keyCode, event);
    }
}