package com.quickprogram.guia04;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Tareas> list;
    private Context context;

    // Constructor para pasar la lista y el contexto
    public MyAdapter(List<Tareas> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Método para eliminar un elemento
    public void removeItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView tvTitulo, tvDescripcion, tvFecha, tvHora;

        public MyViewHolder(View v) {
            super(v);
            tvTitulo = v.findViewById(R.id.tvTitulo);
            tvDescripcion = v.findViewById(R.id.tvDescripcion);
            tvFecha = v.findViewById(R.id.tvFecha);
            tvHora = v.findViewById(R.id.tvHora);

            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
        }

        // Abrir la actividad de edición al hacer clic
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Tareas tarea = list.get(position);

            Intent intent = new Intent(context, EditTaskActivity.class);
            intent.putExtra("tarea", tarea);
            intent.putExtra("position", position);
            context.startActivity(intent);
        }

        // Eliminar tarea al mantener pulsado el item
        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition();
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Eliminar tarea")
                    .setMessage("¿Estás seguro de que deseas eliminar esta tarea?")
                    .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            removeItem(position);
                            Toast.makeText(view.getContext(), "Tarea eliminada", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
            return true;
        }
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Tareas tarea = list.get(position);
        holder.tvTitulo.setText(tarea.getTitulo());
        holder.tvDescripcion.setText(tarea.getDescripcion());
        holder.tvFecha.setText(tarea.getFecha());
        holder.tvHora.setText(tarea.getHora());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
