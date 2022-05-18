package ru.netology.repository;

import ru.netology.domain.FilmItem;

public class PlaybillRepository {
    private FilmItem[] items = new FilmItem[0];

    public FilmItem[] findAll() {
        return items;
    } //вернуть все элементы

    public void save(FilmItem item) { //добавить элемент
        int len = items.length + 1;
        FilmItem[] tmp = new FilmItem[len];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;

    }

    public int findId(int id) { // найти индекс в массиве по id
        int findNumber = -1;
        for (int i = 0; i < items.length; i++) {
            if (id == items[i].getId()) {
                findNumber = i;
            }
        }
        return findNumber;
    }

    public FilmItem findById(int id) { //найти элемент по id
        int findNumber = findId(id);
        if (findNumber == -1) {
            return null;
        } else {
            return items[findNumber];
        }
    }

    public void removeById(int id) { //удалить элемент по id
        int findNumber = findId(id);
        if (findNumber != -1) {
            int len = items.length;
            FilmItem[] tmp;

            tmp = new FilmItem[len - 1];
            int j = 0;
            for (int i = 0; i < items.length; i++) {
                if (i != findNumber) {
                    tmp[j] = items[i];
                    j++;
                }
            }
            items = tmp;
        }
    }

    public void removeAll() { //удалить все элементы
        FilmItem[] tmp = new FilmItem[0];
        items = tmp;
    }

}
