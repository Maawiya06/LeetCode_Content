class BrowserHistory {
    Stack<String> browserStack = new Stack<>();
    Stack<String> fwdStack = new Stack<>();

    public BrowserHistory(String homepage) {
        browserStack.push(homepage);
    }

    public void visit(String url) {
        // delete all the forward history 
        while (!fwdStack.isEmpty())
            fwdStack.pop();
        browserStack.push(url);
    }

    public String back(int steps) {
        // go back 'steps' times
        while (steps-- > 0) {
            if (browserStack.size() > 1) {
                fwdStack.push(browserStack.peek());
                browserStack.pop();
            } else {
                break; // can't go back further
            }
        }
        return browserStack.peek();
    }

    public String forward(int steps) {
        while (steps-- > 0) {
            if (!fwdStack.isEmpty()) {
                browserStack.push(fwdStack.peek());
                fwdStack.pop();
            } else {
                break;
            }
        }
        return browserStack.peek();
    }
}
