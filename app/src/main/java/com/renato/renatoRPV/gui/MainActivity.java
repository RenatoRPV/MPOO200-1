package com.renato.renatoRPV.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.renato.renatoRPV.R;
import com.renato.renatoRPV.infra.Dev00GuiUtil;
import com.renato.renatoRPV.infra.Dev00Sessao;
import com.renato.renatoRPV.negocio.Dev00Renato;


public class MainActivity extends AppCompatActivity {
    private Dev00GuiUtil guiUtil = Dev00GuiUtil.getGuiUtil();
    private Dev00Sessao sessao = Dev00Sessao.getInstancia();
    private Dev00Renato dev00Renato  = new Dev00Renato(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.botao_logout) {
            sessao.reset();

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClickMain(View v) {
        if (v.getId() == R.id.main_btn_perfil_biologico) {
            guiUtil.toastLong(getApplicationContext(), sessao.getUsuario().getPerfBio());

        }

        if(v.getId() == R.id.main_btn_recomendar_medicamento) {
            Intent intent = new Intent(getApplicationContext(), PesquisaRemedioActivity.class);
            startActivity(intent);
        }

        if(v.getId() == R.id.main_btn_cadastrar_biosensor) {
            guiUtil.toastLong(getApplicationContext(), getString(R.string.main_pair_new_biosensor));
            guiUtil.toastShort(getApplicationContext(), getString(R.string.reg_biosensor_paired));
        }
    }
}
