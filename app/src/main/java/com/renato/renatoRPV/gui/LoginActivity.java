package com.renato.renatoRPV.gui;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.renato.renatoRPV.R;
import com.renato.renatoRPV.dominio.Dev00Usuario;
import com.renato.renatoRPV.infra.Dev00GuiUtil;
import com.renato.renatoRPV.infra.Dev00Sessao;
import com.renato.renatoRPV.infra.Dev00Validacao;
import com.renato.renatoRPV.negocio.Dev00Renato;

public class LoginActivity extends AppCompatActivity {
    private Dev00Validacao validacaoUtil = Dev00Validacao.getValidacaoUtil();
    private Dev00Sessao sessao = Dev00Sessao.getInstancia();
    private Dev00Renato dev00Renato = new Dev00Renato(this);
    private Dev00GuiUtil guiUtil = Dev00GuiUtil.getGuiUtil();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessao.reset();

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.backgroundRenatoRPVDark));
    }

    public void onClickLogin(View v){

        if (v.getId() == R.id.login_btn) {
            EditText usuarioEmail = (EditText) findViewById(R.id.login_email);
            EditText usuarioSenha = (EditText) findViewById(R.id.login_senha);
            String usuarioEmailString = usuarioEmail.getText().toString();
            String usuarioSenhaString = usuarioSenha.getText().toString();

            if (validacaoUtil.isFieldEmpty(usuarioEmail)){
                usuarioEmail.requestFocus();
                usuarioEmail.setError(getString(R.string.login_enter_email));
                return;
            }

            if (validacaoUtil.isFieldEmpty(usuarioSenha)){
                usuarioSenha.requestFocus();
                usuarioSenha.setError(getString(R.string.login_enter_pass));
                return;
            }

            if(!validacaoUtil.isEmailValid(usuarioEmailString)){
                usuarioEmail.requestFocus();
                usuarioEmail.setError(getString(R.string.reg_error_invalid_email));
                return;
            }

            try {
                Dev00Usuario usuario = dev00Renato.login(usuarioEmailString, usuarioSenhaString);
                if (sessao.getUsuario()!=null){
                    Intent Int = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(Int);
                }

            } catch (Exception exception) {
                guiUtil.toastLong(getApplicationContext(), exception.getMessage());
            }

        }



        else if (v.getId() == R.id.link_cadastro_usuario) {
            Intent Int = new Intent(getApplicationContext(), CadastroUsuarioActivity.class);
            startActivity(Int);
        }

    }
}
