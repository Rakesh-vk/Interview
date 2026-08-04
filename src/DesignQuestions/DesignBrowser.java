package DesignQuestions;

class BrowserHistory {
    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node np = new Node(url);

        curr.next = np;
        np.prev = curr;
        curr = np;
    }

    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }

    @Override
    public String toString() {
        return "BrowserHistory{" +
                "curr=" + curr.url +
                '}';
    }

    class Node {
        String url;
        Node next;
        Node prev;

        Node(String _data) {
            this.url = _data;
        }
    }
}

public class DesignBrowser {
    public static void main(String[] args) {
        String homepage="google.com";
        BrowserHistory obj = new BrowserHistory(homepage);
        obj.visit("leetcode.com");
        String param_2 = obj.back(1);
        String param_3 = obj.forward(2);
        System.out.println(obj.toString());
    }
}
