package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TasksTest {

    Meeting meeting1 = new Meeting(1, "Пойти в школу", "Учитель", "3:43");
    Meeting meeting2 = new Meeting(2, "Сделать домашку", "Тетрадь", "Сегодня");
    SimpleTask simple1 = new SimpleTask(15, "Пообедать");
    SimpleTask simple2 = new SimpleTask(16, "Ручка");
    String[] subtasks1 = {"Пойти в школу", "Погулять с собакой", "Проверить время"};
    Epic epic1 = new Epic(22, subtasks1);
    String[] subtasks2 = {"Выйти с собакой", "Сделать домашку", "Поболтать"};
    Epic epic2 = new Epic(44, subtasks2);


    @Test
    public void shouldFindSimpleTask() {

        boolean expected = true;
        boolean actual = simple1.matches("Пообедать");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSimpleTask() {

        boolean expected = false;
        boolean actual = simple2.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMeeting() {

        boolean expected = true;
        boolean actual = meeting2.matches("Тетрадь");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMeeting() {

        boolean expected = false;
        boolean actual = meeting1.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicTask() {

        boolean expected = true;
        boolean actual = epic1.matches("Пойти в школу");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpicTask() {

        boolean expected = false;
        boolean actual = epic2.matches("Лечь спать");
        Assertions.assertEquals(expected, actual);
    }
}