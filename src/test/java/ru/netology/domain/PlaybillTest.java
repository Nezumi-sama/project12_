package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.PlaybillRepository;

import static org.junit.jupiter.api.Assertions.*;

class PlaybillTest {

    @Test
        //добавление фильма в пустой список
    public void addFilmEmptyList() {
        FilmItem film1 = new FilmItem(1, "Властелин колец");
        PlaybillRepository rep = new PlaybillRepository();

        rep.save(film1);

        FilmItem[] expected = {film1};
        FilmItem[] actual = rep.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
        //добавление фильма в непустой список
    void addFilmNotEmptyList() {
        FilmItem film1 = new FilmItem(1, "Властелин колец");
        FilmItem film2 = new FilmItem(2, "Шрек");
        FilmItem film3 = new FilmItem(3, "Интерстеллар");
        FilmItem film4 = new FilmItem(4, "Матрица");
        PlaybillRepository rep = new PlaybillRepository();

        rep.save(film1);
        rep.save(film2);
        rep.save(film3);

        rep.save(film4);

        FilmItem[] expected = {film1, film2, film3, film4};
        FilmItem[] actual = rep.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
        //показать все
    void findAll() {
        FilmItem film1 = new FilmItem(1, "Властелин колец");
        FilmItem film2 = new FilmItem(2, "Шрек");
        FilmItem film3 = new FilmItem(3, "Интерстеллар");
        FilmItem film4 = new FilmItem(4, "Матрица");
        FilmItem film5 = new FilmItem(5, "Ходячий замок Хоула");
        PlaybillRepository rep = new PlaybillRepository();

        rep.save(film1);
        rep.save(film2);
        rep.save(film3);
        rep.save(film4);
        rep.save(film5);

        FilmItem[] expected = {film1, film2, film3, film4, film5};
        FilmItem[] actual = rep.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
        //показать последние 10, список > 10
    void findLastTenListIsMoreThanTen() {
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
        PlaybillRepository rep = new PlaybillRepository();

        rep.save(film1);
        rep.save(film2);
        rep.save(film3);
        rep.save(film4);
        rep.save(film5);
        rep.save(film6);
        rep.save(film7);
        rep.save(film8);
        rep.save(film9);
        rep.save(film10);
        rep.save(film11);
        rep.save(film12);
        rep.save(film13);
        rep.save(film14);

        FilmItem[] expected = {film14, film13, film12, film11, film10, film9, film8, film7, film6, film5};
        FilmItem[] actual = rep.findLast();

        assertArrayEquals(expected, actual);


    @Test
        //показать последние 10, список < 10
    void findLastTenListIsLessThanTen() {
        Playbill service = new Playbill();
        String[] filmList = {"Ходячий замок Хоула", "Унесенные призраками", "Унесенные ветром", "Тихий дон", "Обливион", "Другие"};

        String[] filmListLast10;

        filmListLast10 = service.findLast(filmList);

        String[] expected = {"Другие", "Обливион", "Тихий дон", "Унесенные ветром", "Унесенные призраками", "Ходячий замок Хоула"};

        assertArrayEquals(expected, filmListLast10);
    }

    @Test
//показать последние N, список > N
    void testFindLastListIsMoreThanN() {
        Playbill service = new Playbill();
        String[] filmList = {"Властелин колец", "Шрек", "Интерстеллар", "Маска", "Матрица", "Зеленая миля", "Ходячий замок Хоула", "Унесенные призраками", "Унесенные ветром", "Тихий дон", "Девчата", "Обливион", "Оно", "Другие"};

        String[] filmListLastN;

        filmListLastN = service.findLast(filmList, 5);

        String[] expected = {"Другие", "Оно", "Обливион", "Девчата", "Тихий дон"};

        assertArrayEquals(expected, filmListLastN);

    }

    @Test
        //показать последние N, список < N
    void testFindLastListIsLessThanN() {
        Playbill service = new Playbill();
        String[] filmList = {"Ходячий замок Хоула", "Унесенные призраками", "Обливион"};

        String[] filmListLastN;

        filmListLastN = service.findLast(filmList, 5);

        String[] expected = {"Обливион", "Унесенные призраками", "Ходячий замок Хоула"};

        assertArrayEquals(expected, filmListLastN);
    }

}