package ru.job4j.benchmark;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArticleTest {
    @Test
    public void whenFullScanLineGnrTrue() {
        assertThat(
                Article.generateBy(
                        "Мама мыла раму и окно",
                        "мыла окно",
                        new FullScan()
                ),
                is(true)
        );
    }

    @Test
    public void whenFullScanLineGnrFalse() {
        assertThat(
                Article.generateBy(
                        "Мама мыла раму и окно",
                        "мыла пол",
                        new FullScan()
                ),
                is(false)
        );
    }

    @Test
    public void whenFullScanLongTextTrue() {
        assertThat(
                Article.generateBy(
                        "Мой дядя самых честных правил, "
                                + "Когда не в шутку занемог, "
                                + "Он уважать себя заставил "
                                + "И лучше выдумать не мог. "
                                + "Его пример другим наука; "
                                + "Но, боже мой, какая скука "
                                + "С больным сидеть и день и ночь, "
                                + "Не отходя ни шагу прочь! "
                                + "Какое низкое коварство "
                                + "Полуживого забавлять, "
                                + "Ему подушки поправлять, "
                                + "Печально подносить лекарство, "
                                + "Вздыхать и думать про себя: "
                                + "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про тебя и день и ночь",
                        new FullScan()
                ),
                is(true)
        );
    }
    @Test
    public void whenFullScanLongTextFalse() {
        assertThat(
                Article.generateBy(
                        "Мой дядя самых честных правил, "
                                + "Когда не в шутку занемог, "
                                + "Он уважать себя заставил "
                                + "И лучше выдумать не мог. "
                                + "Его пример другим наука; "
                                + "Но, боже мой, какая скука "
                                + "С больным сидеть и день и ночь, "
                                + "Не отходя ни шагу прочь! "
                                + "Какое низкое коварство "
                                + "Полуживого забавлять, "
                                + "Ему подушки поправлять, "
                                + "Печально подносить лекарство, "
                                + "Вздыхать и думать про себя: "
                                + "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про Linux и Java день и ночь",
                        new FullScan()
                ),
                is(false)
        );
    }

    @Test
    public void whenScanWithSetLineGnrTrue() {
        assertThat(
                Article.generateBy(
                        "Мама мыла раму и окно",
                        "мыла окно",
                        new ScanWithSet()
                ),
                is(true)
        );
    }

    @Test
    public void whenScanWithSetLineGnrFalse() {
        assertThat(
                Article.generateBy(
                        "Мама мыла раму и окно",
                        "мыла пол",
                        new ScanWithSet()
                ),
                is(false)
        );
    }

    @Test
    public void whenScanWithSetLongTextTrue() {
        assertThat(
                Article.generateBy(
                        "Мой дядя самых честных правил, "
                                + "Когда не в шутку занемог, "
                                + "Он уважать себя заставил "
                                + "И лучше выдумать не мог. "
                                + "Его пример другим наука; "
                                + "Но, боже мой, какая скука "
                                + "С больным сидеть и день и ночь, "
                                + "Не отходя ни шагу прочь! "
                                + "Какое низкое коварство "
                                + "Полуживого забавлять, "
                                + "Ему подушки поправлять, "
                                + "Печально подносить лекарство, "
                                + "Вздыхать и думать про себя: "
                                + "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про тебя и день и ночь",
                        new ScanWithSet()
                ),
                is(true)
        );
    }
    @Test
    public void whenScanWithSetLongTextFalse() {
        assertThat(
                Article.generateBy(
                        "Мой дядя самых честных правил, "
                                + "Когда не в шутку занемог, "
                                + "Он уважать себя заставил "
                                + "И лучше выдумать не мог. "
                                + "Его пример другим наука; "
                                + "Но, боже мой, какая скука "
                                + "С больным сидеть и день и ночь, "
                                + "Не отходя ни шагу прочь! "
                                + "Какое низкое коварство "
                                + "Полуживого забавлять, "
                                + "Ему подушки поправлять, "
                                + "Печально подносить лекарство, "
                                + "Вздыхать и думать про себя: "
                                + "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про Linux и Java день и ночь",
                        new ScanWithSet()
                ),
                is(false)
        );
    }
}