package com.example.mariana.provamobile_localizador.main;

//Mariana Cavichioli Silva
//Victor Cora Colombo

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mariana.provamobile_localizador.add_address.AddAddressActivity;
import com.example.mariana.provamobile_localizador.R;
import com.example.mariana.provamobile_localizador.show_addresses.ShowAddressesActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    //Realizado o Bind dos botões ao invés dos Event Listners.
    @BindView(R.id.btn_add_address) Button btnAddAddress;
    @BindView(R.id.btn_show_addresses) Button btnShowAddresses;

    MainPresenter mainPresenter;

    //código utilizado para adicionar novos endereços
    private final int RC_ADD_ADDRESS = 123;
    //lista de endereços
    private ArrayList<String> lstAddresses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Necessário para a realização do bind.
        ButterKnife.bind(this);

        mainPresenter = new MainPresenter(MainActivity.this, this);
    }

    //Método adicionarLocal para realizar a ação do botão de adicionar
    //um novo endereço através do OnClick.
    @OnClick(R.id.btn_add_address)
    public void adicionarLocal(){
        mainPresenter.adicionarLocal();
    }

    //Método adicionar que chama uma nova activity ao adicionar um novo endereço.
    @Override
    public void adicionar(){
        Intent openAddAddressActivity = new Intent(MainActivity.this, AddAddressActivity.class);
        startActivityForResult(openAddAddressActivity, RC_ADD_ADDRESS);
    }

    //Método mostrarLocal para realizar a ação do botão de mostrar
    //um endereço através do OnClick.
    @OnClick(R.id.btn_show_addresses)
    public void mostrarLocal(){
        mainPresenter.mostrarLocal(lstAddresses);
    }

    //Método mostrar que chama a activity para mostrar a lista de endereços.
    @Override
    public void mostrar(){
        //abre a ShowAddressActivity enviando a lista de endereços
        Intent openShowAddressActivity = new Intent(MainActivity.this, ShowAddressesActivity.class);
        openShowAddressActivity.putStringArrayListExtra("addresses_list", lstAddresses);
        startActivity(openShowAddressActivity);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //captura o resultado da tela de cadastro de endereços e adiciona na lista
        if(requestCode == RC_ADD_ADDRESS && resultCode == Activity.RESULT_OK) {
            lstAddresses.add(data.getStringExtra("movie_name"));
        }
    }
}