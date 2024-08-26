package com.ulpmovil.tp1;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TraduccionActivity extends AppCompatActivity {

    private EditText etTraduccion;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_traduccion);

        etTraduccion = findViewById(R.id.etTraduccion);
        imageView = findViewById(R.id.imageView);

        Palabra palabra = (Palabra) getIntent().getSerializableExtra("palabra");

        if (palabra != null) {
            etTraduccion.setText(palabra.getTraduccion());
            imageView.setImageResource(palabra.getImageId());
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}