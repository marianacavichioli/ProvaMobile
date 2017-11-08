package com.example.mariana.provamobile_localizador.show_addresses;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mariana.provamobile_localizador.R;

import java.util.List;

import butterknife.OnClick;

/**
 * Created by mariana on 08/11/17.
 */

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder>{

    private List<String> addressesList;
    OnRecyclerViewSelected onRecyclerViewSelected;

    //Construtor para receber a lista
    AddressesAdapter(List<String> addressesList){
        this.addressesList = addressesList;
    }

    //Infla o layout XML
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_list_item, parent, false);
        return new ViewHolder(v);
    }

    //Seta os dados na lista
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAddress.setText(addressesList.get(position));
    }

    //Retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return addressesList.size();
    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected) {
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }

    //Mapeamento dos componentes da View
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAddress = itemView.findViewById(R.id.tv_address);
        }

        //Método Onclick para selecionar um item da lista.
        @OnClick(R.id.address_item)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());
        }
    }
}