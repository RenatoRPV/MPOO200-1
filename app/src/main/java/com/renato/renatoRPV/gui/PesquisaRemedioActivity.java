package com.renato.renatoRPV.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.renato.renatoRPV.R;
import com.renato.renatoRPV.dao.Dev00Pedrosa;
import com.renato.renatoRPV.dominio.Dev00Drug;
import com.renato.renatoRPV.infra.Dev00GuiUtil;
import com.renato.renatoRPV.infra.Dev00Sessao;
import com.renato.renatoRPV.negocio.Dev00Renato;

public class PesquisaRemedioActivity extends AppCompatActivity {
    private Dev00Sessao sessao = Dev00Sessao.getInstancia();
    private Dev00Renato prevençãoDsaúde = new Dev00Renato(this);
    private Dev00GuiUtil guiUtil = Dev00GuiUtil.getGuiUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_remedio);
    }

    public void onButtonClickPesquisa(View v) {
        if(v.getId() == R.id.busca_botao) {
            Spinner busca = (Spinner) findViewById(R.id.busca_parametro);
            TextView titleResultado = (TextView) findViewById(R.id.busca_titulo_resultado);
            TextView melhorRemedio = (TextView) findViewById(R.id.busca_remedio_resultado);

            String buscaString = busca.getSelectedItem().toString().toLowerCase();
            String bioProfile = sessao.getUsuario().getPerfBio();

            Dev00Drug bestDrug = prevençãoDsaúde.getBestOption(buscaString, bioProfile);

            titleResultado.setText(R.string.search_pretext);
            melhorRemedio.setText(bestDrug.getName());

        }
    }
}
