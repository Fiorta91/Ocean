package ru.yagunova.oceanapp.util;

import ru.yagunova.oceanapp.entity.Killerwhale;

//15% косатка спит +20
//10% косатка плавает в океане -5
//10% косатка съела тюленя -15 энергии + const*8 здоровья
//10% косатка съела дельфина -20 энергии + const*6 здоровья
//10% косатка съела пингвина -25 энергии + const*10 здоровья
//10% косатка плавает подо льдом -15 энергии -5 здоровья
//10% косатку атакует браконьер -10 энергии -20 здоровья
//10% косатка уплывает от туристов -20 энергии
//10% косатка обучает детенышей -15 энергии
//5% косатка выпрыгивает из воды -10 энергии
public class EventProducer {

    public void startSimulate(Killerwhale killerwhale) throws InterruptedException {
        while (checkStatus(killerwhale)) {
            int eventProc = (int) (Math.random() * 100);
            if (eventProc >= 0 && eventProc < 15)
                sleepEvent(killerwhale);
            else if (eventProc >= 15 && eventProc < 25) {
                swim(killerwhale);
            } else if (eventProc >= 25 & eventProc < 35) {
                eatSeal(killerwhale);
            } else if (eventProc >= 35 && eventProc < 45) {
                eatDolphin(killerwhale);
            } else if (eventProc >= 45 && eventProc < 55) {
                eatPinguin(killerwhale);
            } else if (eventProc >= 55 && eventProc < 65) {
                swimUnderIce(killerwhale);
            } else if (eventProc >= 65 && eventProc < 75) {
                hunterAttack(killerwhale);
            } else if (eventProc >= 75 && eventProc < 85) {
                swimTourist(killerwhale);
            } else if (eventProc >= 85 && eventProc < 95) {
                learning(killerwhale);
            } else jump(killerwhale);
            Thread.sleep(1000);
        }

        System.out.println("Косатка умерла. The end. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void sleepEvent(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        energy = energy + 20;
        if (energy > 100) energy = 100;
        killerwhale.setEnergy(energy);
        checkEnergy(killerwhale);
        System.out.println("Косатка поспала. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void swim(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        energy = energy - 5;
        if (energy < 0) energy = 0;
        killerwhale.setEnergy(energy);
        checkEnergy(killerwhale);
        System.out.println("Косатка поплавала в океане. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void eatSeal(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        energy = energy - 20;
        if (energy < 0) energy = 0;
        health = health + (int) (killerwhale.getMouth() * 6);
        if (health > 100) health = 100;
        killerwhale.setEnergy(energy);
        killerwhale.setHealth(health);
        checkEnergy(killerwhale);
        System.out.println("Косатка съела дельфина. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void eatPinguin(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        energy = energy - 25;
        if (energy < 0) energy = 0;
        health = health + (int) (killerwhale.getMouth() * 10);
        if (health > 100) health = 100;
        killerwhale.setEnergy(energy);
        killerwhale.setHealth(health);
        checkEnergy(killerwhale);
        System.out.println("Косатка съела пингвина. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void eatDolphin(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        energy = energy - 15;
        if (energy < 0) energy = 0;
        health = health + (int) (killerwhale.getMouth() * 8);
        if (health > 100) health = 100;
        killerwhale.setEnergy(energy);
        killerwhale.setHealth(health);
        checkEnergy(killerwhale);
        System.out.println("Косатка съела тюленя. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void hunterAttack(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        health = health - 20;
        if (health < 0) health = 0;
        energy = energy - 8;
        if (energy < 0) energy = 0;
        killerwhale.setHealth(health);
        killerwhale.setEnergy(energy);
        checkEnergy(killerwhale);
        System.out.println("На косатку напал браконьер. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void swimUnderIce(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        health = health - 5;
        if (health < 0) health = 0;
        energy = energy - 15;
        if (energy < 0) energy = 0;
        killerwhale.setHealth(health);
        killerwhale.setEnergy(energy);
        checkEnergy(killerwhale);
        System.out.println("Косатка плавает подо льдом. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void swimTourist(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        energy = energy - 20;
        if (energy < 0) energy = 0;
        killerwhale.setEnergy(energy);
        checkEnergy(killerwhale);
        System.out.println("Косатка уплывает от туристов. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void learning(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        energy = energy - 15;
        if (energy < 0) energy = 0;
        killerwhale.setEnergy(energy);
        checkEnergy(killerwhale);
        System.out.println("Косатка обучает молодежь. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void jump(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        energy = energy - 10;
        if (energy < 0) energy = 0;
        killerwhale.setEnergy(energy);
        checkEnergy(killerwhale);
        System.out.println("Косатка выпригивает из воды и играет. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private boolean checkStatus(Killerwhale killerwhale) {
        return killerwhale.getHealth() > 0;
    }

    private void checkEnergy(Killerwhale killerwhale) {
        if (killerwhale.getEnergy() <= 0) {
            int health = killerwhale.getHealth();
            health = health - 5;
            if (health < 0) health = 0;
            killerwhale.setHealth(health);
        }
    }
}
