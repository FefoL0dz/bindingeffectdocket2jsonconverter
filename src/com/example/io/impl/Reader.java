package com.loganima.io.impl;

import com.loganima.io.base.IOHandler;
import com.loganima.io.base.IOProtocol;
import com.loganima.models.Docket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reader extends IOHandler implements IOProtocol.IReadable<List<Docket>> {

    static private class Splitter {
        final static String SEMICOLON = ";";
        final static String COMMA = ",";
        final static String SV = "SV";
        final static String COLON = ":";
        final static String QUOTES = "\"";
        final static String BREAK_LINE = "\n";
        final static String WHITE_SPACE = " ";
    }

    public Reader() {
        super(INPUT_FILE_PATH);
    }

    @Override
    public List<Docket> readFile(String fileName) {

        File file = new File(fileName);
        Scanner sc = null;
        List<Docket> list = new ArrayList<>();

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        sc.useDelimiter("\\A");
        String[] dockets = (sc.hasNext() ? sc.next() : null).split(Splitter.SV);

        for (int i = 0; i < dockets.length; i++) {
            String docket = dockets[i];
            if (docket.length() > 1) {
                int sv = extractSV(docket);
                String description = extractDescription(docket);
                List<String> tags = extractTags(docket);
                list.add(new Docket(sv, description, tags));
            }
        }
        return list;
    }

    private List<String> extractTags(final String docket) {
        String tagsText = docket.substring(docket.indexOf(Splitter.BREAK_LINE ) - 1, docket.indexOf(Splitter.BREAK_LINE + Splitter.BREAK_LINE));
        List<String> tags = Arrays.asList(tagsText.split(Splitter.SEMICOLON));
        return tags;
    }

    private String extractDescription(final String docket) {
        int count = 1;
        while (docket.substring(docket.indexOf(Splitter.COLON) + count, docket.indexOf(Splitter.COLON) + count + 1).equals(Splitter.WHITE_SPACE))
            count++;
        return docket.substring(docket.indexOf(Splitter.COLON) + count, docket.indexOf(Splitter.BREAK_LINE));
    }

    private int extractSV(final String docket) {
        String svStr = docket.substring(0, docket.indexOf(Splitter.COLON));
        Scanner in = new Scanner(svStr).useDelimiter("[^0-9]+");
        return in.nextInt();
    }

    public List<Docket> execute() {
        return this.readFile(this.filePath);
    }
}
