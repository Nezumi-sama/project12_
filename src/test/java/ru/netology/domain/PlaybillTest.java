package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaybillTest {

    @Test
        //добавление фильма в пустой список
    void addFilmEmptyList() {
        Playbill service = new Playbill();
        String[] filmList = new String[1];

        filmList = service.addFilm(filmList, "Властелин колец");

        String[] expected = {"Властелин колец"};

        assertArrayEquals(expected, filmList);
    }

    @Test
        //добавление фильма в непустой список
    void addFilmNotEmptyList() {
        Playbill service = new Playbill();
        String[] filmList = {"Властелин колец", "Шрек", "Интерстеллар"};

        filmList = service.addFilm(filmList, "Матрица");

        String[] expected = {"Властелин колец", "Шрек", "Интерстеллар", "Матрица"};

        assertArrayEquals(expected, filmList);

    }

    @Test
        //показать все
    void findAll() {
        Playbill service = new Playbill();
        String[] filmList = {"Властелин колец", "Шрек", "Интерстеллар", "Матрица", "Ходячий замок Хоула"};
        String[] filmListAll;

        filmListAll = service.findAll(filmList);

        String[] expected = {"Властелин колец", "Шрек", "Интерстеллар", "Матрица", "Ходячий замок Хоула"};

        assertArrayEquals(expected, filmListAll);

    }

    @Test
        //показать последние 10, список > 10
    void findLastTenListIsMoreThanTen() {
        Playbill service = new Playbill();
        String[] filmList = {"Властелин колец", "Шрек", "Интерстеллар", "Маска", "Матрица", "Зеленая миля", "Ходячий замок Хоула", "Унесенные призраками", "Унесенные ветром", "Тихий дон", "Девчата", "Обливион", "Оно", "Другие"};

        String[] filmListLast10;

        filmListLast10 = service.findLast(filmList);

        String[] expected = {"Другие", "Оно", "Обливион", "Девчата", "Тихий дон", "Унесенные ветром", "Унесенные призраками", "Ходячий замок Хоула", "Зеленая миля", "Матрица"};

        assertArrayEquals(expected, filmListLast10);
    }

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