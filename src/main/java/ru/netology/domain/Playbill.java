package ru.netology.domain;


public class Playbill {

    public String[] addFilm(String[] playbill, String film) {
        String[] playbillNew;
        int len = playbill.length;

        if (len == 1 && playbill[0] == null) {
            playbillNew = new String[1];
            playbillNew[0] = film;
        } else {
            playbillNew = new String[len + 1];
            for (int i = 0; i < playbill.length; i++) {
                playbillNew[i] = playbill[i];
            }
            playbillNew[playbillNew.length - 1] = film;
        }
        return playbillNew;
    }

    public String[] findAll(String[] playbill) {
        return playbill;
    }

    public String[] findLast(String[] playbill) {
        String[] playbillNew;
        int len = playbill.length;

        if (len <= 10) {
            playbillNew = playbill;
        } else {
            String[] playbillLast = new String[10];
            len = playbill.length - 10;

            for (int i = 0; i < 10; i++) {
                playbillLast[i] = playbill[len + i];
            }
            playbillNew = playbillLast;
        }

        String[] playbillNewLast = new String[playbillNew.length];
        len = playbillNew.length;
        for (int i = 0; i < len; i++) {
            playbillNewLast[i] = playbillNew[len - 1 - i];
        }
        return playbillNewLast;
    }

    public String[] findLast(String[] playbill, int last) {

        String[] playbillNew;
        int len = playbill.length;

        if (len <= last) {
            playbillNew = playbill;
        } else {
            String[] playbillLast = new String[last];
            len = playbill.length - last;

            for (int i = 0; i < last; i++) {
                playbillLast[i] = playbill[len + i];
            }
            playbillNew = playbillLast;
        }

        String[] playbillNewLast = new String[playbillNew.length];
        len = playbillNew.length;
        for (int i = 0; i < len; i++) {
            playbillNewLast[i] = playbillNew[len - 1 - i];
        }
        return playbillNewLast;
    }

}