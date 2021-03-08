package com.ramilaiv.tomiatesttasktesteditor.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceEditor {

    private static final String START_LABEL_STRONG = "<strong>";
    private static final String END_LABEL_STRONG = "</strong>";
    private static final String START_LABEL_ITALIC = "<i>";
    private static final String END_LABEL_ITALIC = "</i>";
    private static final String START_LABEL_UNDERLINE = "<u>";
    private static final String END_LABEL_UNDERLINE  = "</u>";

    private StringBuilder words = new StringBuilder();

    public String add(String s1) {
        return words.append(s1).toString();
    }

    public String addWithPossition(String s, int possition) {
        words = new StringBuilder(deleteLabels(words.toString()));
        if (possition > words.length())
            possition = words.length();
        return words.insert(possition, s).toString();
    }

    public String remove(int fromPosition, int toPosition) {
        words = new StringBuilder(deleteLabels(words.toString()));
        return words.delete(fromPosition, toPosition).toString();
    }

    public String italic(int fromPosition, int toPosition) {
        words = new StringBuilder(deleteLabels(words.toString()));
        words.insert(fromPosition, START_LABEL_ITALIC);
        words.insert(toPosition + START_LABEL_ITALIC.length() + 1, END_LABEL_ITALIC);
        return words.toString();
    }

    public String bold(int fromPosition, int toPosition) {
        words = new StringBuilder(deleteLabels(words.toString()));
        words.insert(fromPosition, START_LABEL_STRONG);
        words.insert(toPosition + START_LABEL_STRONG.length() + 1, END_LABEL_STRONG);
        return words.toString();
    }

    public String underline(int fromPosition, int toPosition) {
        words = new StringBuilder(deleteLabels(words.toString()));
        words.insert(fromPosition, START_LABEL_UNDERLINE);
        words.insert(toPosition + START_LABEL_UNDERLINE.length() + 1, END_LABEL_UNDERLINE);
        return words.toString();
    }

    public void redo() {
    }

    public void undo() {
    }

    public String print() {
        return words.toString();
    }

    private String deleteLabels(String s) {
        if (s.contains(START_LABEL_STRONG) && s.contains(END_LABEL_STRONG)) {
            s = s.replaceAll(START_LABEL_STRONG,"");
            s = s.replaceAll(END_LABEL_STRONG,"");
            return s;
        }
        if (s.contains(START_LABEL_ITALIC) && s.contains(END_LABEL_ITALIC)) {
            s = s.replaceAll(START_LABEL_ITALIC, "");
            s = s.replaceAll(END_LABEL_ITALIC, "");
            return s;
        }
        if (s.contains(START_LABEL_UNDERLINE) && s.contains(END_LABEL_UNDERLINE)) {
            s = s.replaceAll(START_LABEL_UNDERLINE, "");
            s = s.replaceAll(END_LABEL_UNDERLINE, "");
            return s;
        }
        else {
            return words.toString();
        }
    }
}
