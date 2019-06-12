package com.renato.renatoRPV.negocio;

import android.content.Context;

import com.renato.renatoRPV.dao.Dev00Pedrosa;
import com.renato.renatoRPV.dominio.Dev00Drug;
import com.renato.renatoRPV.dominio.Dev00PerfilBiologico;
import com.renato.renatoRPV.dominio.Dev00Usuario;
import com.renato.renatoRPV.infra.Dev00Sessao;

public  class Dev00Renato{
    private Dev00Sessao sessao = Dev00Sessao.getInstancia();
    private Dev00Pedrosa Dev00PedrosaDAO;

    public Dev00Renato(Context context) {
        Dev00PedrosaDAO = new Dev00Pedrosa(context);

    }

    public void cadastrarUsuario(String nome, String email, String senha, Dev00PerfilBiologico perfilBiologico)
            throws Exception{ sessao.reset();

        Dev00Usuario usuario = Dev00PedrosaDAO.getUsuario(email);

        if (usuario!=null){
            throw new Exception("E-mail já registrado");
        }

        usuario = new Dev00Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setPass(senha);
        usuario.setPerfBio(perfilBiologico);

        long idUsuario = Dev00PedrosaDAO.inserir(usuario);

        usuario.setId(idUsuario);

        sessao.setUsuario(usuario);

    }

    public Dev00Usuario login(String email, String senha)
            throws Exception{ sessao.reset();

        Dev00Usuario usuario = Dev00PedrosaDAO.getUsuario(email, senha);

        if(usuario==null) {
            throw new Exception("E-mail ou senha inválida");
        }

        sessao.setUsuario(usuario);

        return usuario;
    }

    public void setDev00PerfilBiologico(Dev00Usuario usuario, Dev00PerfilBiologico perfilBiologico) {
        Dev00PedrosaDAO.cadastrarPerfilBiologico(usuario, perfilBiologico);
    }

    public Dev00Drug getBestOption(String sintoma, String perfBio) {
        return Dev00PedrosaDAO.getBestOption(sintoma, perfBio);
    }
}
