package smartHome;

import smartHome.ConsoleColors.ConsoleColors;
import smartHome.Devices.SmartCamera;
import smartHome.Devices.SmartLight;
import smartHome.Devices.SmokeDetector;
import smartHome.Devices.Thermostat;
import smartHome.FILE.Logger;
import smartHome.InterfacesAndAbstractClasses.AbstractDevices;
import smartHome.InterfacesAndAbstractClasses.AbstractSensors;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SmartHome extends ConsoleColors {

    private final List<AbstractDevices> devices = new ArrayList<>();
    private final List<AbstractSensors> sensors = new ArrayList<>();
    private final String SEPARATOR = BOLD + BRIGHT_PURPLE + "=".repeat(60);
    private final Logger logger = new Logger();

    public SmartHome() {
        run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int startChoice;
        while(true) {
            startMenu();
            startChoice = correctInputStartChoice(scanner);
            switch (startChoice) {
                case 1:
                    addSmartLight(scanner);
                    break;
                case 2:
                    addSmartCamera(scanner);
                    break;
                case 3:
                    addThermostat(scanner);
                    break;
                case 4:
                    addSmokeDetector(scanner);
                    break;
                case 5:
                    printDevicesAndSensors();
                    break;
                case 6:
                    remove(scanner);
                    break;
                case 7:
                    deviceControl(scanner);
                    break;
                case 8:
                    diagnosticSystem();
                    break;
                case 9:
                    statisticSystem();
                    break;
                case 0:
                    exit();
                    break;
            }
            if(startChoice == 0) break;
            System.out.println();
        }
    }

    public void addSmartLight(Scanner scanner) {
        String nameSmartLight;
        String serialNumber;
        int brightLevel;
                System.out.println(BOLD + BRIGHT_PURPLE + "Введите название лампы:");
                while ((nameSmartLight = scanner.nextLine()).isEmpty())
                    System.out.println(BOLD + BRIGHT_PURPLE + "Имя умной лампы не может быть пустым");
                System.out.println(BOLD + BRIGHT_PURPLE + "Введите серийный номер:");
                while ((serialNumber = scanner.nextLine()).isEmpty())
                    System.out.println(BOLD + BRIGHT_PURPLE + "Серийный номер не может быть пустым");
                System.out.println(BOLD + BRIGHT_PURPLE + "Введите уровень яркости (0-100):");
                while (true) {
                    try {
                    brightLevel = scanner.nextInt();
                    scanner.nextLine();
                    if(brightLevel > 0 && brightLevel < 100)  break;
                    System.out.println(BOLD + BRIGHT_PURPLE + "Уровень яркости не может выходить за диапазон 0 - 100");
                    } catch (InputMismatchException e) {
                        System.out.println(BOLD + BRIGHT_PURPLE + "Вы ввели нечисловое значение, повторите попытку");
                        scanner.next();
                    }
                }
        devices.add(new SmartLight(nameSmartLight, true, serialNumber, brightLevel));
        System.out.println(BOLD + BRIGHT_PURPLE + "Устройство успешно добавлено в базу.");
        System.out.println(SEPARATOR);
        String message = String.format("""
                Устройство: %s (%s)
                Яркость: %d%%
                """, nameSmartLight, serialNumber, brightLevel);
        String event = "ДОБАВЛЕНИЕ";
        logger.writeToFile(message, event);
    }

    public void addSmartCamera(Scanner scanner) {
        String nameSmartCamera;
        String serialNumber;
        String wifiName;
        System.out.println(BOLD + BRIGHT_PURPLE + "Введите название камеры");
        while ((nameSmartCamera = scanner.nextLine()).isEmpty())
            System.out.println(BOLD + BRIGHT_PURPLE + "Имя умной камеры не может быть пустым");
        System.out.println(BOLD + BRIGHT_PURPLE + "Введите серийный номер:");
        while ((serialNumber = scanner.nextLine()).isEmpty())
            System.out.println(BOLD + BRIGHT_PURPLE + "Серийный номер не может быть пустым");
        System.out.println(BOLD + BRIGHT_PURPLE + "Введите название сети wifi");
        while ((wifiName = scanner.nextLine()).isEmpty())
            System.out.println(BOLD + BRIGHT_PURPLE + "Имя сети не может быть пустым");
        devices.add(new SmartCamera(nameSmartCamera, true, serialNumber, wifiName));
        System.out.println(BOLD + BRIGHT_PURPLE + "Устройство успешно добавлено в базу.");
        System.out.println(SEPARATOR);
        String message = String.format("""
                Устройство: %s (%s)
                Имя wifi сети: %s
                """, nameSmartCamera, serialNumber, wifiName);
        String event = "ДОБАВЛЕНИЕ";
        logger.writeToFile(message, event);
    }

    public void addThermostat(Scanner scanner) {
        String nameThermostat ;
        int currentTemperature;
        String serialNumber;
        String wifiName;

        System.out.println(BOLD + BRIGHT_PURPLE + "Введите название термостата");
        while ((nameThermostat = scanner.nextLine()).isEmpty())
            System.out.println(BOLD + BRIGHT_PURPLE + "Имя термостата не может быть пустым");
        System.out.println(BOLD + BRIGHT_PURPLE + "Введите серийный номер:");
        while ((serialNumber = scanner.nextLine()).isEmpty())
            System.out.println(BOLD + BRIGHT_PURPLE + "Серийный номер не может быть пустым");
        System.out.println(BOLD + BRIGHT_PURPLE + "Введите текущую температуру");
        while (true) {
            try {
                currentTemperature = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println(BOLD + BRIGHT_PURPLE + "Вы ввели нечисловое значение, повторите попытку");
                scanner.next();
            }
        }
        System.out.println(BOLD + BRIGHT_PURPLE + "Введите название сети wifi");
        while ((wifiName = scanner.nextLine()).isEmpty()) System.out.println(BOLD + BRIGHT_PURPLE + "Имя сети не может быть пустым");

        devices.add(new Thermostat(nameThermostat, true, serialNumber,currentTemperature, wifiName));
        System.out.println(BOLD + BRIGHT_PURPLE + "Устройство успешно добавлено в базу.");
        System.out.println(SEPARATOR);
        String message = String.format("""
                Устройство: %s (%s)
                Имя wifi сети: %s
                """, nameThermostat, serialNumber, wifiName);
        String event = "ДОБАВЛЕНИЕ";
        logger.writeToFile(message, event);
    }

    public void addSmokeDetector(Scanner scanner) {
        String location;
        int chargeLevel;
        boolean alarmActive = false;
            System.out.println(BOLD + BRIGHT_PURPLE + "Введите локацию датчика:");
            while ((location = scanner.nextLine()).isEmpty())
                System.out.println(BOLD + BRIGHT_PURPLE + "Локация датчика не может быть пустой");
            System.out.println(BOLD + BRIGHT_PURPLE + "Введите текущий уровень заряда (0-100):");
            while (true) {
                try {
                    chargeLevel = scanner.nextInt();
                    scanner.nextLine();
                    if (chargeLevel > 0 && chargeLevel < 100) break;
                    System.out.println(BOLD + BRIGHT_PURPLE + "Уровень заряда не может выходить за пределы (0-100)");
                } catch (InputMismatchException e) {
                    System.out.println(BOLD + BRIGHT_PURPLE + "Вы ввели нечисловое значение, повторите попытку");
                    scanner.next();
                }
            }
        sensors.add(new SmokeDetector(true, alarmActive, location, chargeLevel));
        System.out.println(BOLD + BRIGHT_PURPLE + "Устройство успешно добавлено в базу.");
        System.out.println(SEPARATOR);
        String message = String.format("""
                Локация: %s
                Уровень заряда батареи: %s
                Тревога: %b
                """, location, chargeLevel, alarmActive);
        String event = "ДОБАВЛЕНИЕ";
        logger.writeToFile(message, event);
    }

    public int correctInputStartChoice(Scanner scanner) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if(choice >= 0  && choice <= 9) return choice;
                System.out.println(BOLD + BRIGHT_PURPLE + "Вы ввели некорректное значение, повторите попытку");
                scanner.next();
            } catch (InputMismatchException e) {
                System.out.println(BOLD + BRIGHT_PURPLE + "Вы ввели нечисловое значение, повторите попытку");
                scanner.next();
            }
        }
    }

    public void printDevicesAndSensors() {
        System.out.println(BRIGHT_CYAN + "--- СПИСОК УСТРОЙСТВ И ДАТЧИКОВ ---");
        System.out.println("          --- Устройства ---");
        if(!devices.isEmpty()) {
            for (int i = 0; i < devices.size(); i++) {
                System.out.println(i + ". " + devices.get(i));
            }
            System.out.println(BRIGHT_CYAN + "-".repeat(30));
        } else System.out.println("В системе пока нет добавленных устройств");
        System.out.println("           --- Датчики ---");
        if(!sensors.isEmpty()) {
            for (int i = 0; i < sensors.size(); i++) {
                System.out.println(i + ". " + sensors.get(i));
            }
            System.out.println(BRIGHT_CYAN + "-".repeat(30));
        } else System.out.println("В системе пока нет добавленных датчиков");
        System.out.println(SEPARATOR);
    }


    public void remove(Scanner scanner) {
        String name = "";
        System.out.print("""
                Что вы хотите удалить?
                1 — устройство (по серийному номеру);
                2 — датчик (по локации).
                Введите номер варианта:
                """);
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1) {
                System.out.println("Введите серийный номер:");
                String serialNumber = scanner.nextLine();
                for (int i = 0; i < devices.size(); i++) {
                    if(devices.get(i).getSerialNumber().equals(serialNumber)) {
                        name = devices.get(i).getName();
                        devices.remove(i);
                        System.out.println("Устройство успешно удалено из базы.");
                        break;
                    }
                }
            } else if(choice == 2) {
                System.out.println("Введите локацию:");
                String serialNumber = scanner.nextLine();
                for (int i = 0; i < sensors.size(); i++) {
                    if(sensors.get(i).getLocation().equals(serialNumber)) {
                        sensors.remove(i);
                        System.out.println("Устройство успешно удалено из базы.");
                        break;
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Вы ввели нечисловое значение");
        }
        if(name.isEmpty())  System.out.println("Устройство не было найдено");
        else {
            String message = String.format("""
                                Устройство: %s
                                Устройство успешно удалено из базы.
                                """, name);
            String event = "УДАЛЕНИЕ";
            logger.writeToFile(message, event);
        }
        System.out.println(SEPARATOR);
    }

    public int correctInputChoice(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели нечисловое значение, повторите попытку");
                scanner.next();
            }
        }
    }

    public void deviceControl(Scanner scanner) {
        String message;
        System.out.println("Введите серийный номер устройства:");
        String serialNumber = scanner.nextLine();
        for(AbstractDevices device : devices) {
            if(serialNumber.equals(device.getSerialNumber()) && device instanceof SmartLight) {
                System.out.printf("""
                        Найдено устройство: %s
                        Доступные действия:
                        1 - включить\\выключить устройство.""", device.getName());
                while (true) {
                    int choice = correctInputChoice(scanner);
                    scanner.nextLine();
                    if(choice == 1) {
                        if(device.isOn()) {
                            device.OFF();
                            message = String.format("Устройство \"%s\" выключено\n", device.getName());
                        } else {
                            device.ON();
                            message = String.format("Устройство \"%s\" включено\n", device.getName());
                        }
                        System.out.println(message);
                        logger.writeToFile(message, "УПРАВЛЕНИЕ");
                        break;
                    } else {
                        System.out.println("Вы выбрали несуществующий вариант ответа, повторите попытку");
                        scanner.next();
                    }
                }
            }

            if(serialNumber.equals(device.getSerialNumber()) && device instanceof Thermostat) {
                System.out.printf("""
                        Найдено устройство: %s
                        Доступные действия:
                        1 - подключение к  wifi.""", device.getName());
                while (true) {
                    int choice = correctInputChoice(scanner);
                    if(choice == 1) {
                        device.connectToWiFi("Thermostat67425");
                        message = String.format("Устройство \"%s\" подключено к wifi\n", device.getName());
                        System.out.printf(message);
                        logger.writeToFile(message, "УПРАВЛЕНИЕ");
                        break;
                    } else {
                        System.out.println("Вы выбрали несуществующий вариант ответа, повторите попытку");
                        scanner.next();
                    }
                }
            }

            if(serialNumber.equals(device.getSerialNumber()) && device instanceof SmartCamera) {
                System.out.printf("""
                        Найдено устройство: %s
                        Доступные действия:
                        1 - включить\\выключить устройство
                        2 - повторное подключение к другой сети wifi.""", device.getName());
                while (true) {
                    int choice = correctInputChoice(scanner);
                    if(choice == 1) {
                        if(device.isOn()) {
                            device.OFF();
                            device.OffRecording();
                            message = String.format("Устройство \"%s\" выключено\n", device.getName());

                        } else {
                            device.ON();
                            device.OnRecording();
                            message = String.format("Устройство \"%s\" включено\n", device.getName());
                        }
                        System.out.println(message);
                        logger.writeToFile(message, "УПРАВЛЕНИЕ");
                        break;
                    } else if (choice == 2) {
                        System.out.println("Введите пароль чтобы подключиться к другой сети WIFI");
                        device.connectToAnotherWIFI(scanner.nextLine());
                        if(device.isOn()) logger.writeToFile(String.format("Устройство \"%s\" успешно подключено" +
                                "к другой сети WIFI", device.getName()), "УПРАВЛЕНИЕ");
                        else logger.writeToFile(String.format("Устройство \"%s\" не удалось подключить" +
                                "к другой сети WIFI", device.getName()), "УПРАВЛЕНИЕ");
                    } else {
                        System.out.println("Вы выбрали несуществующий вариант ответа, повторите попытку");
                        scanner.next();
                    }
                }
            }
        }
        System.out.println(SEPARATOR);
    }

    public void statisticSystem() {
        int countOnDevices = 0;
        double avgChargeBattery = 0.0;
        String message;
        for (AbstractDevices device : devices) {
            if (device.isOn()) countOnDevices++;
        }
        for(AbstractSensors sensor : sensors) {
            avgChargeBattery += sensor.getBatteryLevel();
        }
        if(sensors.isEmpty()) avgChargeBattery = 0;
        else avgChargeBattery = avgChargeBattery / sensors.size();
        message = String.format("""
                --- СТАТИСТИКА СИСТЕМЫ ---
                Всего устройств: %d
                Всего датчиков: %d
                Включено устройств: %d из %d
                Средний заряд батарей датчиков: %.2f%%
                ---------------------------
                """,
                devices.size(), sensors.size(), countOnDevices, devices.size(), avgChargeBattery);
        System.out.printf(BOLD + BRIGHT_PURPLE + """
                --- СТАТИСТИКА СИСТЕМЫ ---
                Всего устройств: %d
                Всего датчиков: %d
                Включено устройств: %d из %d
                Средний заряд батарей датчиков: %.2f%%
                ---------------------------
                """,
                devices.size(), sensors.size(), countOnDevices, devices.size(), avgChargeBattery);
        logger.writeToFile(message, "СТАТИСТИКА");
    }

    public void diagnosticSystem() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(BOLD + BRIGHT_PURPLE + "--- ДИАГНОСТИКА СИСТЕМЫ ---");
        for (AbstractDevices device : devices) {
            System.out.println(device.getStatus());
            stringBuilder.append(device.getStatus());
        }
        for(AbstractSensors sensor : sensors) {
            System.out.println(sensor.getDiagnosticSenor());
            stringBuilder.append(sensor.getDiagnosticSenor());
        }
        System.out.println(BOLD + BRIGHT_PURPLE + "Диагностика завершена");
        logger.writeToFile(stringBuilder.toString(), "ДИАГНОСТИКА");
    }

    public void exit() {
        System.out.print(BOLD + BRIGHT_PURPLE + """
                Все события сохранены в файле smart_home_log.txt.
                Завершение работы системы. До свидания!
                """);
    }

    public void startMenu() {
        System.out.print(BOLD + BRIGHT_PURPLE + """
                --- ПАНЕЛЬ УПРАВЛЕНИЯ УМНЫМ ДОМОМ ---
                1. Добавить умную лампу
                2. Добавить умную камеру
                3. Добавить термостат
                4. Добавить датчик дыма
                5. Показать список устройств и датчиков
                6. Удалить устройство или датчик
                7. Управление устройством
                8. Выполнить диагностику системы
                9. Показать статистику системы
                0. Выход
                Введите номер варианта:
                """);
    }
}
