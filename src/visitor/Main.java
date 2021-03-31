package visitor;

public class Main {
    public static void main(String[] args) {
        PersonVisitor visitor = new PersonVisitor();
        new Computer().accept(visitor);
        System.out.println(visitor.totalPrice);
    }
}

class Computer {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();

    public void accept(Visitor v) {
        this.cpu.accept(v);
        this.memory.accept(v);
    }
}

interface Visitor {
    public void visitCPU(CPU cpu);

    public void visitMemory(Memory memory);
}

class PersonVisitor implements Visitor {
    double totalPrice;

    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.95;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.9;
    }
}

abstract class ComputerPart {
    abstract public void accept(Visitor v);

    abstract public double getPrice();
}

class CPU extends ComputerPart {

    @Override
    public void accept(Visitor v) {
        v.visitCPU(this);
    }

    @Override
    public double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart {

    @Override
    public void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    public double getPrice() {
        return 300;
    }
}