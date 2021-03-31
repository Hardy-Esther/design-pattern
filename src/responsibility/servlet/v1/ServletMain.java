package responsibility.servlet.v1;

import java.util.ArrayList;
import java.util.List;

public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "request";
        Response response = new Response();
        response.str = "response";

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter()).add(new SensitiveFilter());
        fc.doFilter(request,response);

        System.out.println(request.str);
        System.out.println(response.str);
    }
}

class Request{
    String str;
}

class Response{
    String str;
}

interface ServletFilter{
    void doFilter(Request request,Response response);
}

class HTMLFilter implements ServletFilter{

    @Override
    public void doFilter(Request request, Response response) {
        request.str += "--HTMLFilter";
        response.str += "--HTMLFilter";
    }
}

class SensitiveFilter implements ServletFilter{

    @Override
    public void doFilter(Request request, Response response) {
        request.str += "--SensitiveFilter";
        response.str += "--SensitiveFilter";
    }
}

class FilterChain implements ServletFilter{
    List<ServletFilter> filters = new ArrayList<>();

    public FilterChain add(ServletFilter f){
        filters.add(f);
        return this;
    }
    @Override
    public void doFilter(Request request, Response response) {
        for (ServletFilter f : filters) {
            f.doFilter(request,response);
        }
    }
}