package helpers;

public class NoSuchBrowserExpetion extends Throwable {
    public NoSuchBrowserExpetion(String browser) {
        super("Browser is not supported or it is incorrect typed. Actual name pf browser: " + browser);
    }
}
