package com.loganima.io.base;

public abstract class IOHandler {

    private static final String ROOT_PATH = "/home/flodes/Desktop/bindingeffectdocket2jsonconverter/src/com/loganima/resources/";

    public IOHandler(final String filePath) {
        this.filePath = filePath;
    }

    protected final String filePath;

    protected static final String INPUT_FILE_PATH = ROOT_PATH + "input/TESTE_SÚMULA.txt";

    protected static final String OUTPUT_FILE_PATH = ROOT_PATH + "output/sumula.json";
}
