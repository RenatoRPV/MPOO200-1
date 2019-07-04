package com.renato.renatoRPV.dominio;

public class Dev00PerfilBiologicoEnum {

    public enum Caracteristica {
        A("CTGGTGGT"), B("CACAGCCT"), C("ATCTTCAA"), D("ATCTTCAA");

        private String sequencia;

        Caracteristica(String sequencia) {
            this.sequencia = sequencia;
        }

        public String getSequencia() {
            return sequencia;
        }

        public static Caracteristica getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }
    }
}
