package com.example.libretatelefonica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.UUID;

public class ContactsAdapter extends RecyclerView.Adapter<ContactView> implements ContactView.onItemContactAction{

    private ArrayList<Contact> contacts;

    public ContactsAdapter(){
        contacts = new ArrayList<>();

        contacts.add(new Contact(UUID.randomUUID().toString(), "Jaime", "3168718780"));
        contacts.add(new Contact(UUID.randomUUID().toString(), "Eduardo", "3168718710"));
        contacts.add(new Contact(UUID.randomUUID().toString(), "Cardona", "3168712710"));

    }

    public void addContact(Contact contact){
        contacts.add(contact);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.contactrow, null);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        ContactView contactView = new ContactView(rowroot);
        contactView.setListener(this);
        return contactView;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactView holder, int position) {
        holder.setContact(contacts.get(position));
        holder.getNombre().setText(contacts.get(position).getNombre());
        holder.getTelefono().setText(contacts.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public void onDeleteAction(Contact contact) {
        contacts.remove(contact);
        this.notifyDataSetChanged();
    }
}
