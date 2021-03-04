package com.example.libretatelefonica;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ContactView extends RecyclerView.ViewHolder implements View.OnClickListener{

    private Contact contact;
    private ConstraintLayout root;
    private TextView nombre;
    private TextView telefono;
    private Button llamar;
    private Button eliminar;
    private onItemContactAction listener;

    public ContactView(ConstraintLayout root) {
        super(root);
        this.root = root;
        nombre = root.findViewById(R.id.contactName);
        telefono = root.findViewById(R.id.contactPhone);
        llamar = root.findViewById(R.id.llamar);
        eliminar = root.findViewById(R.id.eliminar);
        eliminar.setOnClickListener(this);
        llamar.setOnClickListener(this);


    }

    public ConstraintLayout getRoot() {
        return root;
    }

    public TextView getNombre() {
        return nombre;
    }

    public TextView getTelefono() {
        return telefono;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.eliminar:
                if(listener != null) listener.onDeleteAction(this.contact);
                break;
            case R.id.llamar:
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+contact.getTelefono().toString()));
                root.getContext().startActivity(i);
                break;
        }
    }

    public void setListener(onItemContactAction onItemContactAction){
        this.listener = onItemContactAction;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public interface onItemContactAction{
        void onDeleteAction(Contact contact);
    }
}
