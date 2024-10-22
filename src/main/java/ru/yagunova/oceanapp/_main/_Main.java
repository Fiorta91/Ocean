package ru.yagunova.oceanapp._main;

import ru.yagunova.oceanapp.entity.Killerwhale;
import ru.yagunova.oceanapp.util.EventProducer;

public class _Main {
    public static void main(String[] args) throws InterruptedException {
        Killerwhale killerwhale = new Killerwhale();
        EventProducer eventProducer = new EventProducer();
        eventProducer.startSimulate(killerwhale);
    }
}
