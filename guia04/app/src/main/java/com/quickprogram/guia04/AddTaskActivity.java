package com.quickprogram.guia04;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity {
    Button btnFecha, btnHora, btnGuardar;
    EditText edtTitulo, edtDescripcion, edtFecha, edtHora;
    private boolean isEdit = false;
    private int editPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        btnFecha = findViewById(R.id.btnFecha);
        btnHora = findViewById(R.id.btnHora);
        btnGuardar = findViewById(R.id.btnGuardar);
        edtTitulo = findViewById(R.id.edtTitulo);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtFecha = findViewById(R.id.edtFecha);
        edtHora = findViewById(R.id.edtHora);

        // Configurar edición si se trata de editar una tarea
        Tareas tareaEditada = (Tareas) getIntent().getSerializableExtra("tarea");
        if (tareaEditada != null) {
            edtTitulo.setText(tareaEditada.getTitulo());
            edtDescripcion.setText(tareaEditada.getDescripcion());
            edtFecha.setText(tareaEditada.getFecha());
            edtHora.setText(tareaEditada.getHora());
            isEdit = true;
            editPosition = getIntent().getIntExtra("position", -1);
        }

        // Seleccionar hora
        btnHora.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(AddTaskActivity.this, (timePicker, hourOfDay, minute1) -> {
                String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute1);
                edtHora.setText(selectedTime);
            }, hour, minute, true);
            timePickerDialog.show();
        });

        // Seleccionar fecha
        btnFecha.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();
            int day = c.get(Calendar.DAY_OF_MONTH);
            int month = c.get(Calendar.MONTH);
            int year = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(AddTaskActivity.this, (datePicker, year1, month1, dayOfMonth) -> {
                String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%04d", dayOfMonth, month1 + 1, year1);
                edtFecha.setText(selectedDate);
            }, year, month, day);
            datePickerDialog.show();
        });

        // Guardar tarea (nueva o editada)
        btnGuardar.setOnClickListener(v -> {
            Tareas tarea = new Tareas();
            tarea.setTitulo(edtTitulo.getText().toString());
            tarea.setDescripcion(edtDescripcion.getText().toString());
            tarea.setFecha(edtFecha.getText().toString());
            tarea.setHora(edtHora.getText().toString());

            if (isEdit && editPosition != -1) {
                MainActivity.lstTareas.set(editPosition, tarea);
            } else {
                MainActivity.lstTareas.add(tarea);
            }
            finish();
        });
    }
}
