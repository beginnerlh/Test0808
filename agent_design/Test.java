package factory.agent_design;


interface Subject{
    void buyComputer();
}

class RealSubject implements Subject{

    @Override
    public void buyComputer() {
        System.out.println("buy Dell");
    }
}

class ProxySubject implements Subject{
    private Subject subject ;

    public ProxySubject(Subject subject){
        this.subject = subject;
    }

    public void protectComputer(){
        System.out.println("product Dell");
    }

    public void afterSale(){
        System.out.println("售后");
    }

    @Override
    public void buyComputer() {
        this.protectComputer();
        subject.buyComputer();
        this.afterSale();
    }
}

class Factory{
    public static Subject getInstance(){
        return new ProxySubject(new RealSubject());
    }
}

public class Test {

    public static void main(String[] args) {

        Subject subject = Factory.getInstance();
        subject.buyComputer();
    }
}
