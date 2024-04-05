package Teori.Tugas3;

public class NavBrowser {
    private String[] historyStack;
    private int top;
    private String currentURL;
    private int maxSize;

    public NavBrowser(int maxSize) {
        this.maxSize = maxSize;
        historyStack = new String[maxSize];
        top = -1;
        currentURL = "";
    }

    public void visitURL(String url) {
        if (!currentURL.isEmpty()) {
            if (top < maxSize - 1) {
                historyStack[++top] = currentURL;
            } else {
                for (int i = 0; i < maxSize - 1; i++) {
                    historyStack[i] = historyStack[i + 1];
                }
                historyStack[maxSize - 1] = currentURL;
            }
        }
        currentURL = url;
        System.out.println("You visited: " + url);
    }

    public void back() {
        if (top >= 0) {
            String previousURL = historyStack[top--];
            System.out.println("Going back to: " + previousURL);
            currentURL = previousURL;
        } else {
            System.out.println("No previous page available.");
        }
    }

    public void forward() {
        if (!currentURL.isEmpty()) {
            System.out.println("Cannot go forward. You are already on: " + currentURL);
        } else {
            System.out.println("No forward history available.");
        }
    }

    public void getCurrentURL() {
        if (!currentURL.isEmpty()) {
            System.out.println("\nCurrent URL: " + currentURL);
        } else {
            System.out.println("You haven't visited any page yet.");
        }
    }
    public static void main(String[] args) {
        String[] urls = {"https://www.Main.com", "https://www.Tugas3.com", 
                        "https://www.vscode.com", "https://www.NavBrowser.com"};
        NavBrowser browser = new NavBrowser(urls.length);
        
        for (String url : urls) {
            browser.visitURL(url);
        }

        browser.getCurrentURL(); 

        browser.back(); 
        browser.getCurrentURL(); 

        browser.back(); 
        browser.getCurrentURL(); 

        browser.forward(); 

        browser.visitURL("https://www.AnotherWebsite.com");
        browser.getCurrentURL(); 
    }
}

