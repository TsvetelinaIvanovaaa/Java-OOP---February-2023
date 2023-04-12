package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        if (type.equals("MainService")) {
            service = new MainService(name);
        } else if (type.equals("SecondaryService")) {
            service = new SecondaryService(name);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }
        services.add(service);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        if (type.equals("PlasticArmor")) {
            supplement = new PlasticArmor();
        } else if (type.equals("MetalArmor")) {
            supplement = new MetalArmor();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        supplements.addSupplement(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = this.supplements.findFirst(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                service.addSupplement(supplement);
                supplements.removeSupplement(supplement);
            }
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }
    //   Supplement supplement = this.supplements.findFirst(supplementType);
    //   if (supplement == null) {
    //        throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
    //    } else {
    //        Service service = getServiceByName(serviceName);
    //         service.getSupplements();
    //        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    //     }
    // }

    // private Service getServiceByName(String serviceName) {
    //    return this.services.stream()
    //            .filter(service -> service.getName().equals(serviceName))
    //            .findFirst()
    //            .orElse(null);
    // }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        if (robotType.equals("MaleRobot")) {
            robot = new MaleRobot(robotName, robotKind, price);
        } else if (robotType.equals("FemaleRobot")) {
            robot = new FemaleRobot(robotName, robotKind, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }

        //Service service = getServiceByName(serviceName);
        Service service = this.services.stream().filter(ser -> ser.getName().equals(serviceName))
                .findFirst().orElse(null);

        boolean checkMainService = service.getClass().getSimpleName().startsWith("Main") && robotType.startsWith("Male");
        boolean checkSecondaryService = service.getClass().getSimpleName().startsWith("Secondary") && robotType.startsWith("Female");

        if (checkMainService || checkSecondaryService) {
            service.addRobot(robot);
        } else {
            return String.format(ConstantMessages.UNSUITABLE_SERVICE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE);
    }

    @Override
    public String feedingRobot(String serviceName) {
        int countFeedingRobot = 0;

        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                Collection<Robot> robots = service.getRobots();
                for (Robot robot : robots) {
                    robot.eating();
                    countFeedingRobot++;
                }
            }
        }
        return String.format(ConstantMessages.FEEDING_ROBOT, countFeedingRobot);
    }
    //Service service = getServiceByName(serviceName);
    //service.feeding();
    //return String.format(ConstantMessages.FEEDING_ROBOT, service.getRobots().size());


    @Override
    public String sumOfAll(String serviceName) {
        Service service = this.services.stream().findFirst()
                .filter(service1 -> service1.getName().equals(serviceName)).orElse(null);

        double totalSum = 0;

        Collection<Supplement> supplements1 = service.getSupplements();

        for (Supplement supplement : supplements1) {
            totalSum += supplement.getPrice();
        }

        Collection<Robot> robots = service.getRobots();
        for (Robot robot : robots) {
            totalSum += robot.getPrice();
        }

        return String.format(ConstantMessages.VALUE_SERVICE, serviceName, totalSum);
    }
    // Service service = getServiceByName(serviceName);
    // double amountSupplements = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();
    // int amountRobots = (int) service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
    // double price = amountSupplements + amountRobots;
    // return String.format(ConstantMessages.VALUE_SERVICE,price);


    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();

        for (Service service : services) {
            statistics.append(service.getStatistics()).append(System.lineSeparator());
        }

        return statistics.toString().trim();
    }
}
