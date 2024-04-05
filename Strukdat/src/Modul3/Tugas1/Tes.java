package Modul3.Tugas1;

class Browser {
    private String[] historyUrls;
    private String[] forwardUrls;
    private int maxSize;
    private int historyTop;
    private int forwardTop;
    private String currentURL;

    public Browser(int maxSize) {
        this.maxSize = maxSize;
        historyUrls = new String[maxSize];
        forwardUrls = new String[maxSize];
        historyTop = -1;
        forwardTop = -1;
        currentURL = null;
    }

    public void visitURL(String url) {
        if (currentURL != null) {
            historyUrls[++historyTop] = currentURL;
            forwardUrls = new String[maxSize];
            forwardTop = -1;
        }
        currentURL = url;
        System.out.println("Visited URL: " + url);
    }

    public void back() {
        if (!isHistoryEmpty()) {
            forwardUrls[++forwardTop] = currentURL;
            currentURL = historyUrls[historyTop--];
            System.out.println("Back to: " + currentURL);
        } else {
            System.out.println("Cannot go back. History is empty.");
        }
    }

    public void forward() {
        if (!isForwardEmpty()) {
            historyUrls[++historyTop] = currentURL;
            currentURL = forwardUrls[forwardTop--];
            System.out.println("Forward to: " + currentURL);
        } else {
            System.out.println("Cannot go forward. No forward history.");
        }
    }

    public void getCurrentURL() {
        if (currentURL != null) {
            System.out.println("\nCurrent URL: " + currentURL);
        } else {
            System.out.println("No URL currently accessed.");
        }
    }

    private boolean isHistoryEmpty() {
        return historyTop == -1;
    }

    private boolean isForwardEmpty() {
        return forwardTop == -1;
    }

    
    public static void main(String[] args) { //LIFO
        String[] urls = {"https://www.Main.com", 
                        "https://www.Tugas3.com", 
                        "https://www.vscode.com", 
                        "https://www.NavStack.com"};
                        Browser browser = new Browser(urls.length);

        for (String url : urls) {
            browser.visitURL(url);
        }
        
        // NavStack browser = new NavStack(3); 
        // browser.visitURL("https://www.Main.com");
        // browser.visitURL("https://www.Tugas3.com");
        // browser.visitURL("https://www.vscode.com");
        // browser.visitURL("https://www.tes.com");

        browser.getCurrentURL(); 

        browser.back(); 
        browser.getCurrentURL(); 

        browser.back(); 
        browser.getCurrentURL(); 

        browser.forward(); 
        browser.getCurrentURL(); 
    }
}