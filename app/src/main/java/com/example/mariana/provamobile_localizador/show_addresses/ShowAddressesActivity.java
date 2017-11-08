package com.example.mariana.provamobile_localizador.show_addresses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mariana.provamobile_localizador.R;
import com.example.mariana.provamobile_localizador.show_addresses.AddressesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mariana on 08/11/17.
 */

public class ShowAddressesActivity extends AppCompatActivity{

    //Realizando o Bind da RecyclerView.
    @BindView(R.id.rv_addresses) RecyclerView rvAddresses;

    OnRecyclerViewSelected onRecyclerViewSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_addresses);

        //Necessário para a realização do bind.
        ButterKnife.bind(this);

        //captura a lista enviada pela MainActivity
        ArrayList<String> lstAddresses = getIntent().getStringArrayListExtra("addresses_list");
        //instancia um AddressesAdapter passando a lista de endereços
        AddressesAdapter addressesAdapter = new AddressesAdapter(lstAddresses);

        //Criação de métodos para implementar a seleção de um item da RecyclerView.
        addressesAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            //Clique simples
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(ShowAddressesActivity.this, "Clique Rápido", Toast.LENGTH_SHORT).show();
            }
            //Clique longo
            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(ShowAddressesActivity.this, "Clique Longo", Toast.LENGTH_SHORT).show();
            }
        });

        //seta o adapter no Recycler View
        rvAddresses.setAdapter(addressesAdapter);

        //cria o gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //seta o gerenciador de layouts no Recycler View
        rvAddresses.setLayoutManager(layoutManager);
    }


//    @Override
//    public void abrir() {
////        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode("Avenida São Carlos"));
////        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
////        mapIntent.setPackage("com.google.android.apps.maps");
////        startActivity(mapIntent);
//    }
}