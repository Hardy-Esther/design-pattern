package command;

public class Main {
    public static void main(String[] args) {
        Content c = new Content();
        Command insertCommand = new InsertCommand(c);
        insertCommand.doit();
        System.out.println(c.msg);
        insertCommand.undo();
        System.out.println(c.msg);
        DeleteCommand deleteCommand = new DeleteCommand(c);
        deleteCommand.doit();
        System.out.println(c.msg);
        deleteCommand.undo();
        System.out.println(c.msg);
    }
}

abstract class Command {
    public abstract void doit();

    public abstract void undo();
}

class Content {
    String msg = "abcdefg";
}

class DeleteCommand extends Command {
    Content c;
    String deleted;

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        deleted = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5, c.msg.length());
    }

    @Override
    public void undo() {
        c.msg = deleted + c.msg;
    }
}

class InsertCommand extends Command {
    Content c;
    String strToInsert = "http://www.baidu.com";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + strToInsert;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() - strToInsert.length());
    }
}