package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    Meeting meeting1 = new Meeting(1, "Пойти в школу", "Учитель", "3:43");
    Meeting meeting2 = new Meeting(2, "Сделать домашку", "Тетрадь", "Сегодня");
    SimpleTask simple1 = new SimpleTask(15, "Пообедать");
    SimpleTask simple2 = new SimpleTask(16, "Ручка");
    String[] subtasks1 = {"Пойти в школу", "Погулять с собакой", "Проверить время"};
    Epic epic1 = new Epic(22, subtasks1);
    String[] subtasks2 = {"Выйти с собакой", "Сделать домашку", "Поболтать"};
    Epic epic2 = new Epic(44, subtasks2);

    @Test
    public void shouldFindHomeworkInSimpleTask() {
        Todos todos = new Todos();

        todos.add(simple1);
        todos.add(simple2);

        Task[] expected = {simple2};
        Task[] actual = todos.search("Ручка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSimpleTask() {
        Todos todos = new Todos();

        todos.add(simple1);
        todos.add(simple2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("Помыть собаку");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMeeting() {
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMeetingWithMom() {
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = {meeting1};
        Task[] actual = todos.search("Учитель");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFlowers() {
        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);

        Task[] expected = {epic2};
        Task[] actual = todos.search("Поболтать");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpicTask() {
        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("Мел");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskInDifferentType() {
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(simple1);
        todos.add(simple2);

        Task[] expected = {meeting1, epic1};
        Task[] actual = todos.search("Пойти в школу");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTaskInDifferentType() {
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(simple1);
        todos.add(simple2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("Полететь в Турцию");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

   @Test
    public void shouldFindAllTasks() {
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(simple1);
        todos.add(simple2);

        Task[] expected = {meeting1, meeting2, epic1, epic2, simple1, simple2};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}