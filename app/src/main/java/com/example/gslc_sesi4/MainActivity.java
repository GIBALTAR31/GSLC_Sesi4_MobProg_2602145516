package com.example.gslc_sesi4;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText name, binusianId;
    private Spinner role;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.Name_Inp);
        binusianId = findViewById(R.id.Id_Inp);
        register = findViewById(R.id.Register_Btn);
        role = findViewById(R.id.Role_Spinner);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = name.getText().toString();
                String Id = binusianId.getText().toString();
                String Role = role.getSelectedItem().toString();

                Toast.makeText(MainActivity.this, "Welcome " + Username + "!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, second_page.class);
                intent.putExtra("Username", Username);
                intent.putExtra("Id", Id);
                intent.putExtra("Role", Role);
                startActivity(intent);
            }
        });


        role.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String role = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Role: " + role, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Student");
        arrayList.add("Lecture");
        arrayList.add("Staff");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);

        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        role.setAdapter(adapter);

    }
}