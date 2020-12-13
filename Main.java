import Methods.MethodDelphi;

public class Main {
    private static float[][] arguments = {
            {2f, 0.7f, 0.2f, 0.3f, 0.08f},
            {6f, 0.9f, 0.5f, 0.02f, 0.05f},
            {8f, 0.2f, 0.1f, 0.05f, 0.04f},
            {6f, 0.4f, 0.2f, 0.02f, 0.08f}};

    private static int[][] evaulation = {
            {10, 8, 8, 9, 6, 5, 4},
            {10, 10, 9, 10, 10, 5, 6},
            {4, 2, 7, 2, 2, 3, 6},
            {8, 4, 3, 6, 4, 2, 7}};

    private static String[] messages = {
            "Оновлення архітектури програмного та апаратного забезпечення.(1)",
            "Навчання персоналу на спеціальних тренінгах.(2)",
            "Використання автоматичної системи інтерактивної взаємодії (IVR) для економії часу.(3)",
            "Переведення операторів на надомну працю.(4)",
            "Ведення статистики та бізнес-аналізу.(5)",
            "Маршрутизація викликів за їх специфікою.(6)",
            "Система заохочень та штрафів для персоналу.(7)"};

    private static MethodDelphi method = new MethodDelphi(arguments, evaulation);

    private static float[] argumentLevel = method.getArgumentLevel();
    private static float[] messageImportance = method.getMessageImportance();
    private static int[] messageRank = method.getMessageRank();


    public static void main(String[] args) {


        System.out.print("Результати експертного аналізу (за методом Дельфі) по визначенню пріоритетних напрямків визначенню експертних потенціалу.\nЗапропоновані основні показники експертного потенціалу:\n");
        for (int i = 0; i < messages.length; i++) {
            System.out.println(i + ". " + messages[i] + ";");
        }
        argumentResult();
        evaulationResult();
        messageImportanceResult();
        messageRankResult();

    }

    private static void argumentResult() {
        System.out.println("Результати оцінки компетентності експертів: ");
        int expertNum = 1;
        for (int i = 0; i < arguments.length; i++) {
            System.out.print("eксперт " + expertNum + "    ");
            expertNum++;
            for (int j = 0; j < arguments[0].length; j++) {
                System.out.print(arguments[i][j] + "  ");
            }
            System.out.println(argumentLevel[i]);
        }
    }

    private static void evaulationResult() {
        System.out.println("Вихідні експертні данні: ");
        int expertNum = 1;
        for (int[] ints : evaulation) {
            System.out.print("eксперт " + expertNum + "    ");
            expertNum++;
            for (int j = 0; j < evaulation[0].length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }

    private static void messageImportanceResult() {
        System.out.println("Обрахована оцінка важливості з урахуванням компетентності експертів: ");
        for (float v : messageImportance) {
            System.out.print(v + "  ");
        }
        System.out.println();

    }

    private static void messageRankResult() {
        System.out.println("Данні після ранжування: ");
        for (int i1 : messageRank) {
            System.out.print(i1 + "  ");
        }
        System.out.println();
        int rank = 1;
        for (int i = 0; i < messageRank.length; i++) {
            for (int j = 0; j < messageRank.length; j++) {
                if (messageRank[j] == rank) {
                    System.out.println(rank + ". " + messages[j]);
                    break;
                }

            }
            rank++;
        }
    }
}


