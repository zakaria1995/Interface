package com.example.zakaria.aninterface;

import java.io.Serializable;

/**
 * Created by ZAKARIA on 18/04/2017.
 */

public class Employe implements Serializable {
    private String name;
    private int old;
    private int mark;

    public Employe(String name, int old, int mark) {
        this.name = name;
        this.old = old;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "{ name=" + name + ", old=" + old + ", mark=" + mark + "}\n";
    }
}
