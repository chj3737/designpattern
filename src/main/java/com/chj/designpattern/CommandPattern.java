package com.chj.designpattern;


import javax.annotation.Resource;

class Command {
    /**
     * there may be no common Receiver interface, but just specialized handlers,
     * eg. need two or more Objects to be orchestrated to do the job,
     * like the purpose of Application Service in DDD applied with CQRS
     */
    Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        System.out.println("command 1 executing");
        receiver.doSomething();
    }
}

class Command1 extends Command {

    public Command1() {
        super(new Receiver1());
    }
}

class Command2 extends Command {

    public Command2() {
        super(new Receiver2());
    }
}



interface Command1Handler{

}

class Command1HandlerImpl implements  Command1Handler {

}

class BetterCommond extends Command {
    @Resource
    Command1Handler handler;

    // no need in reality
    public BetterCommond(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        // invoke handler method..
    }
}


interface Receiver {
    void doSomething();
}



class Receiver1 implements Receiver {

    @Override
    public void doSomething() {
        System.out.println("reveiver 1 handling command");
    }
}

class Receiver2 implements Receiver {
    @Override
    public void doSomething() {
        System.out.printf("reveiver 2 handle command");
    }
}
class  Invoker {
    void invoke(Command command) {
        command.execute();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.invoke(new Command1());
        invoker.invoke(new Command2());

    }
}
