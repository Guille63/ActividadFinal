package org.example.actividadfinal.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventario {
    private List<Dispositivo> dispositivos;

    public Inventario(List<Dispositivo> dispositivos) {
        this.dispositivos = new ArrayList<>(dispositivos);
    }

    public List<Dispositivo> altaDispositivo(Dispositivo dispositivo) {
        if (dispositivos.contains(dispositivo)) {
            //si el dispositivo ya existe, se cambia el dispositivo por el nuevo
            dispositivos.set(dispositivos.indexOf(dispositivo), dispositivo);
        } else {
            //si el dispositivo no existe, se añade a la lista
            dispositivos.add(dispositivo);
        }
        return dispositivos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventario that)) return false;
        return Objects.equals(getDispositivos(), that.getDispositivos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDispositivos());
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }
}
