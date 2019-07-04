package com.renato.renatoRPV.infra;

import com.renato.renatoRPV.dominio.Dev00Usuario;

import java.util.Date;

public class Dev00Sessao {
    private static Dev00Sessao instancia = new Dev00Sessao();
    private Dev00Usuario usuario;
    private Date horaLogin;

    private Dev00Sessao(){
    }

    public static Dev00Sessao getInstancia(){

        return instancia;
    }

    public Date getHoraLogin()
    {
        return horaLogin;
    }

    public void setHoraLogin(Date horaLogin) {
        this.horaLogin = horaLogin;
    }

    public void reset(){
        this.usuario = null;
        this.horaLogin = null;
    }

    public Dev00Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Dev00Usuario usuario) {

        this.usuario = usuario;
    }
}
