package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.PlaybillManager;

import static org.junit.jupiter.api.Assertions.*;

class PlaybillTest {
    FilmItem film1 = new FilmItem(1, "Властелин колец");
    FilmItem film2 = new FilmItem(2, "Шрек");
    FilmItem film3 = new FilmItem(3, "Интерстеллар");
    FilmItem film4 = new FilmItem(4, "Матрица");
    FilmItem film5 = new FilmItem(5, "Ходячий замок Хоула");
    FilmItem film6 = new FilmItem(6, "Маска");
    FilmItem film7 = new FilmItem(7, "Зеленая миля");
    FilmItem film8 = new FilmItem(8, "Унесенные призраками");
    FilmItem film9 = new FilmItem(9, "Унесенные ветром");
    FilmItem film10 = new FilmItem(10, "Тихий дон");
    FilmItem film11 = new FilmItem(11, "Девчата");
    FilmItem film12 = new FilmItem(12, "Обливион");
    FilmItem film13 = new FilmItem(13, "Оно");
    FilmItem film14 = new FilmItem(14, "Другие");

    @Test
    //добавление фильма в пустой список
    public void addFilmEmptyList() {
        PlaybillManager rep = new PlaybillManager();

        rep.add(film1);

        FilmItem[] expected = {film1};
        FilmItem[] actual = rep.findAllManager();

        assertArrayEquals(expected, actual);
    }

    @Test
        //добавление фильма в непустой список
    void addFilmNotEmptyList() {
        PlaybillManager rep = new PlaybillManager();

        rep.add(film1);
        rep.add(film2);
        rep.add(film3);

        rep.add(film4);

        FilmItem[] expected = {film1, film2, film3, film4};
        FilmItem[] actual = rep.findAllManager();

        assertArrayEquals(expected, actual);
    }

    @Test
        //показать все
    void findAll() {
        PlaybillManager rep = new PlaybillManager();

        rep.add(film1);
        rep.add(film2);
        rep.add(film3);
        rep.add(film4);
        rep.add(film5);

        FilmItem[] expected = {film1, film2, film3, film4, film5};
        FilmItem[] actual = rep.findAllManager();

        assertArrayEquals(expected, actual);

    }

    @Test
        //показать последние 10, список > 10
    void findLastTenListIsMoreThanTen() {
        PlaybillManager rep = new PlaybillManager();

        rep.add(film1);
        rep.add(film2);
        rep.add(film3);
        rep.add(film4);
        rep.add(film5);
        rep.add(film6);
        rep.add(film7);
        rep.add(film8);
        rep.add(film9);
        rep.add(film10);
        rep.add(film11);
        rep.add(film12);
        rep.add(film13);
        rep.add(film14);

        FilmItem[] expected = {film14, film13, film12, film11, film10, film9, film8, film7, film6, film5};
        FilmItem[] actual = rep.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
        //показать последние 10, список < 10
    void findLastTenListIsLessThanTen() {
        PlaybillManager rep = new PlaybillManager();

        rep.add(film1);
        rep.add(film2);
        rep.add(film3);
        rep.add(film4);
        rep.add(film5);
        rep.add(film6);
        rep.add(film7);

        FilmItem[] expected = {film7, film6, film5, film4, film3, film2, film1};
        FilmItem[] actual = rep.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
//показать последние N, список > N
    void testFindLastListIsMoreThanN() {
        PlaybillManager rep = new PlaybillManager();

        rep.add(film1);
        rep.add(film2);
        rep.add(film3);
        rep.add(film4);
        rep.add(film5);
        rep.add(film6);
        rep.add(film7);
        rep.add(film8);
        rep.add(film9);
        rep.add(film10);

        FilmItem[] expected = {film10, film9, film8, film7, film6};
        FilmItem[] actual = rep.findLast(5);

        assertArrayEquals(expected, actual);
    }

    @Test
        //показать последние N, список < N
    void testFindLastListIsLessThanN() {
        PlaybillManager rep = new PlaybillManager();

        rep.add(film1);
        rep.add(film2);
        rep.add(film3);

        FilmItem[] expected = {film3, film2, film1};
        FilmItem[] actual = rep.findLast(5);

        assertArrayEquals(expected, actual);
    }

}