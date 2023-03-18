import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    List<String> visited;
    int current;
    int last;
    public BrowserHistory(String homepage) {
        visited = new ArrayList<>();
        visited.add(homepage);
        current = 0;
        last = 0;
    }
    
    public void visit(String url) {
        current++;
        if(visited.size()>current)
            visited.set(current,url);
        else visited.add(url);
        last = current;
    }
    
    public String back(int steps) {
        current = Math.max(0,current-steps);
        return visited.get(current);
    }
    
    public String forward(int steps) {
        current = Math.min(last,current + steps);
        return visited.get(current);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */