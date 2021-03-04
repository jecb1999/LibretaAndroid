package com.example.libretatelefonica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView contactViewList;
    private  LinearLayoutManager layoutManager;
    private ContactsAdapter adapter;

    private EditText nombre;
    private EditText telefono;
    private Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactViewList = findViewById(R.id.contactViewList);
        nombre = findViewById(R.id.nombreIn);
        telefono = findViewById(R.id.telefonoIn);
        agregar = findViewById(R.id.buttonAgregarC);
        agregar.setOnClickListener(this);

        contactViewList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        contactViewList.setLayoutManager(layoutManager);

        adapter = new ContactsAdapter();
        contactViewList.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAgregarC:
                Contact contact = new Contact(UUID.randomUUID().toString(),nombre.getText().toString(),telefono.getText().toString());
                adapter.addContact(contact);
                break;
        }
    }
}