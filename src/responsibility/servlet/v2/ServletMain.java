package responsibility.servlet.v2;

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
        fc.doFilter(request,response,fc);

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
    void doFilter(Request request,Response response,FilterChain filterChain);
}

class HTMLFilter implements ServletFilter{

    @Override
    public void doFilter(Request request, Response response,FilterChain filterChain) {
        request.str += "--HTMLFilter";
        filterChain.doFilter(request,response,filterChain);
        response.str += "--HTMLFilter";
    }
}

class SensitiveFilter implements ServletFilter{

    @Override
    public void doFilter(Request request, Response response,FilterChain filterChain) {
        request.str += "--SensitiveFilter";
        filterChain.doFilter(request,response,filterChain);
        response.str += "--SensitiveFilter";
    }
}

class FilterChain implements ServletFilter{
    List<ServletFilter> filters = new ArrayList<>();
    int index = 0;
    public FilterChain add(ServletFilter f){
        filters.add(f);
        return this;
    }
    @Override
    public void doFilter(Request request, Response response,FilterChain filterChain) {
        if (index == filters.size()) return;
        ServletFilter f = filters.get(index);
        index++;
        f.doFilter(request,response,filterChain);
    }
}