package SOLID_Lab.DependencyInversion.Worker;

public class Manager {
    Worker worker;
    public Manager(Worker worker) {
        this.worker = worker;
        worker.work();
    }
}
