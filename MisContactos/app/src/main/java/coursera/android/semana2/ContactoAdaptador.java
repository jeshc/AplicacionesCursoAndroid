package coursera.android.semana2;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {
    ArrayList<Contacto> contactos;
    Activity activity;


    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);
        holder.imgFoto.setImageResource(contacto.getFoto());
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());

        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("devj", "onClick: "+contacto.getNombre());
                //Toast.makeText(activity,contacto.getNombre(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste like a "+contacto.getNombre(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombreCV = itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = itemView.findViewById(R.id.tvTelefonoCV);
            btnLike = itemView.findViewById(R.id.btnLike);
        }


    }

}
