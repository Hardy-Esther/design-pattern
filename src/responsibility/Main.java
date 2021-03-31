package responsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:),<script>alert('996')</script>");

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter())
                .add(new SensitiveFilter());
        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter());

        fc.add(fc2);
        fc.doFilter(msg);
        System.out.println(msg);
    }
}

class Msg {
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Msg msg);
}

class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace('<', '[');
        r = r.replace('>', ']');
        msg.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        //处理msg
        String r = msg.getMsg();
        r = r.replaceAll("996", "955");
        msg.setMsg(r);
        return false;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        //处理msg
        String r = msg.getMsg();
        r = r.replace(":)", "^w^");
        msg.setMsg(r);
        return true;
    }
}


class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    public void remove(Filter f){

    }

    public boolean doFilter(Msg msg){
        for (Filter f : filters) {
            if(!f.doFilter(msg)){
                return false;
            }
        }
        return true;
    }
}