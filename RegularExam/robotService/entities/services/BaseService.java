package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseService implements Service{

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if(capacity == robots.size()){
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : robots) {
            robot.eating();
        }
    }

    @Override
    public int sumHardness() {
        return supplements.stream()
                .mapToInt(Supplement::getHardness)
                .sum();
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:%n", this.name, this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Robots:");
        if(this.getRobots().isEmpty()){
            sb.append("none");
        }else{
            sb.append(this.getRobots().stream().map(Robot::getName).collect(Collectors.joining(" ")).trim());
        }
        sb.append(String.format("Supplements: %d Hardness: %d", this.getSupplements().size(), this.sumHardness()));
        return sb.toString().trim();
    }
}
