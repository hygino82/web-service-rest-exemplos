package br.data;

import java.util.ArrayList;

public class CrudCidade {

    private static ArrayList<Cidade> lcid = new ArrayList<>();

    public void add(Cidade cid) {
        lcid.add(cid);
    }

    public ArrayList<Cidade> getAll() {
        return lcid;
    }

    public Cidade getCidade(int id) {
        for (Cidade cidade : lcid) {
            if (cidade.getId() == id) {
                return cidade;
            }
        }
        return null;
    }
}
