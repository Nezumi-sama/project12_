package ru.netology.manager;

import ru.netology.domain.FilmItem;
import ru.netology.repository.PlaybillRepository;

public class PlaybillManager {
    private PlaybillRepository repository = new PlaybillRepository();

    public PlaybillManager() {
        this.repository = repository;
    }

    public void add(FilmItem item) { // добавить элемент
        repository.save(item);
    }

    public FilmItem[] findAllManager() { //вернуть все фильмы в порядке добавления
        return repository.findAll();
    }

    public FilmItem[] findLast() { //вернуть последние добавленные фильмы в обратном от добавления порядке
        FilmItem[] items = repository.findAll();
        FilmItem[] playbillNew;

        int len = items.length;

        if (len <= 10) {
            playbillNew = items;
        } else {
            playbillNew = new FilmItem[10];
            // FilmItem[] playbillLast = new FilmItem[10];
            len = items.length - 10;

            for (int i = 0; i < 10; i++) {
                playbillNew[i] = items[len + i];
            }
            // playbillNew = playbillLast;
        }

        FilmItem[] playbillNewLast = new FilmItem[playbillNew.length];
        len = playbillNew.length;
        for (int i = 0; i < len; i++) {
            playbillNewLast[i] = playbillNew[len - 1 - i];
        }
        return playbillNewLast;
    }

    public FilmItem[] findLast(int id) { //вернуть последние добавленные фильмы в обратном от добавления порядке
        FilmItem[] items = repository.findAll();
        FilmItem[] playbillNew;

        int len = items.length;

        if (len <= id) {
            playbillNew = items;
        } else {
            playbillNew = new FilmItem[id];
            // FilmItem[] playbillLast = new FilmItem[10];
            len = items.length - id;

            for (int i = 0; i < id; i++) {
                playbillNew[i] = items[len + i];
            }
            // playbillNew = playbillLast;
        }
        FilmItem[] playbillNewLast = new FilmItem[playbillNew.length];
        len = playbillNew.length;
        for (int i = 0; i < len; i++) {
            playbillNewLast[i] = playbillNew[len - 1 - i];
        }
        return playbillNewLast;
    }

    public FilmItem findFilmById(int id) { //найти фильм по id
        return repository.findById(id);
    }

    public void removeFilmById(int id) { //удалить фильм по id
        repository.removeById(id);
    }

    public void removeAllFilms() { //удалить все фильмы
        repository.removeAll();
    }

}