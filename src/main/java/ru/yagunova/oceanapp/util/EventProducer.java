package ru.yagunova.oceanapp.util;

import ru.yagunova.oceanapp.entity.Killerwhale;

import static ru.yagunova.oceanapp.entity.Killerwhale.MOUTH;

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
        killerwhale.setEnergy(energy);
        checkEnergyHungred(killerwhale);
        checkEnergy(killerwhale);
        System.out.println("Косатка поспала. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void swim(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        energy = energy - 5;
        killerwhale.setEnergy(energy);
        checkEnergyZero(killerwhale);
        checkEnergy(killerwhale);
        System.out.println("Косатка поплавала в океане. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void eatSeal(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        energy = energy - 20;
        health = health + ((int) MOUTH * 6);
        if (health > 100) health = 100;
        killerwhale.setEnergy(energy);
        killerwhale.setHealth(health);
        checkEnergyZero(killerwhale);
        checkHealthHungred(killerwhale);
        checkEnergy(killerwhale);
        System.out.println("Косатка съела дельфина. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void eatPinguin(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        energy = energy - 25;
        health = health + ((int) MOUTH * 10);
        killerwhale.setEnergy(energy);
        killerwhale.setHealth(health);
        checkEnergyZero(killerwhale);
        checkHealthHungred(killerwhale);
        checkEnergy(killerwhale);
        System.out.println("Косатка съела пингвина. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void eatDolphin(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        energy = energy - 15;
        health = health + ((int) MOUTH * 8);
        killerwhale.setEnergy(energy);
        killerwhale.setHealth(health);
        checkEnergyZero(killerwhale);
        checkHealthHungred(killerwhale);
        checkEnergy(killerwhale);
        System.out.println("Косатка съела тюленя. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void hunterAttack(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        health = health - 20;
        energy = energy - 8;
        killerwhale.setHealth(health);
        killerwhale.setEnergy(energy);
        checkEnergyZero(killerwhale);
        checkHealthZero(killerwhale);
        checkEnergy(killerwhale);
        System.out.println("На косатку напал браконьер. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void swimUnderIce(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        int health = killerwhale.getHealth();
        health = health - 5;
        energy = energy - 15;
        killerwhale.setHealth(health);
        killerwhale.setEnergy(energy);
        checkHealthZero(killerwhale);
        checkEnergyZero(killerwhale);
        checkEnergy(killerwhale);
        System.out.println("Косатка плавает подо льдом. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void swimTourist(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        energy = energy - 20;
        killerwhale.setEnergy(energy);
        checkEnergyZero(killerwhale);
        checkEnergy(killerwhale);
        System.out.println("Косатка уплывает от туристов. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void learning(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        energy = energy - 15;
        killerwhale.setEnergy(energy);
        checkEnergyZero(killerwhale);
        checkEnergy(killerwhale);
        System.out.println("Косатка обучает молодежь. Текущая энергия: " + killerwhale.getEnergy() + " Текущее здоровье: " + killerwhale.getHealth());
    }

    private void jump(Killerwhale killerwhale) {
        int energy = killerwhale.getEnergy();
        energy = energy - 10;
        killerwhale.setEnergy(energy);
        checkEnergyZero(killerwhale);
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

    private void checkEnergyZero(Killerwhale killerwhale) {
        if (killerwhale.getEnergy() < 0) {
            killerwhale.setEnergy(0);
        }
    }

    private void checkEnergyHungred(Killerwhale killerwhale) {
        if (killerwhale.getEnergy() > 100) {
            killerwhale.setEnergy(100);
        }
    }

    private void checkHealthZero(Killerwhale killerwhale) {
        if (killerwhale.getHealth() < 0) {
            killerwhale.setHealth(0);
        }
    }

    private void checkHealthHungred(Killerwhale killerwhale) {
        if (killerwhale.getHealth() > 100) {
            killerwhale.setHealth(100);
        }
    }
}
