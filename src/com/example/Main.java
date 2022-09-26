package com.loganima;

import com.loganima.io.impl.Reader;
import com.loganima.io.impl.Writer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to BindingEffectDocket2Json Converter!");
        new Writer(new Reader().execute()).execute();
        //new Reader().execute();
    }
}
