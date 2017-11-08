package com.example.mariana.provamobile_localizador.show_addresses;

import android.view.View;

/**
 * Created by mariana on 08/11/17.
 */

public interface OnRecyclerViewSelected {
    void onClick(View view, int position);
    void onLongClick(View view, int position);
}
