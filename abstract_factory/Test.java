package factory.abstract_factory;



interface Computer{
    void printComputer();
}

interface  OperatingSystem{
    void printOperatingSystem();
}

class MacProComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("this is MacPro");
    }
}

class DellComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("this is Dell");
    }
}

class WindowsSystem implements OperatingSystem{

    @Override
    public void printOperatingSystem() {
        System.out.println("this is windows");
    }
}

class MacOsSystem implements OperatingSystem{

    @Override
    public void printOperatingSystem() {
        System.out.println("this is MacOs");
    }
}

interface ProductFactory {
    Computer creatComputer();
    OperatingSystem cteatSystem();
}


class AppleFactory implements ProductFactory{

    @Override
    public Computer creatComputer() {
        return new MacProComputer();
    }

    @Override
    public OperatingSystem cteatSystem() {
        return new MacOsSystem();
    }
}

class DellFactory implements ProductFactory{

    @Override
    public Computer creatComputer() {
        return new DellComputer();
    }

    @Override
    public OperatingSystem cteatSystem() {
        return new WindowsSystem();
    }
}

public class Test {
    public void buyComputer(Computer computer){
        computer.printComputer();
    }

    public void useOperatingSystem(OperatingSystem operatingSystem){
        operatingSystem.printOperatingSystem();

    }
    public static void main(String[] args) {

        Test test = new Test();
        ProductFactory factory = new DellFactory();
        test.buyComputer(factory.creatComputer());
        test.useOperatingSystem(factory.cteatSystem());
    }
}