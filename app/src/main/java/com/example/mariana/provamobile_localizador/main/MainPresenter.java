package com.example.mariana.provamobile_localizador.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.mariana.provamobile_localizador.show_addresses.ShowAddressesActivity;

import java.util.ArrayList;

/**
 * Created by mariana on 08/11/17.
 */

//MainPresenter criado para a realização do MVP.
public class MainPresenter {

    private final MainView mainView;
    private Context mainContext;

    MainPresenter(MainView mainView, Context context){
        this.mainView = mainView;
        this.mainContext = context;
    }

    public void adicionarLocal() {
        mainView.adicionar();
    }

    public void mostrarLocal(ArrayList<String> lstAddresses){
        if(lstAddresses.size() <= 0){
            Toast.makeText(mainContext, "Não há endereços cadastrados", Toast.LENGTH_SHORT).show();
        }else{
            mainView.mostrar();
        }
    }
}
