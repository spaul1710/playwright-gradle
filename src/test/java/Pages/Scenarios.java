package Pages;

import com.microsoft.playwright.*;

import java.io.UnsupportedEncodingException;


public class Scenarios {

    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static ThreadLocal<Page> threadLocalDriver = new ThreadLocal<>(); //For Parallel execution
    public static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();

    //Launches Browser as set by user in config file
    public static Page initDriver(String browserName) throws UnsupportedEncodingException {
        BrowserType browserType = null;

        switch (browserName) {
            case "firefox":
                browserType = Playwright.create().firefox();

                browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browserType = Playwright.create().chromium();

                browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

                break;
            case "webkit":
                browserType = Playwright.create().webkit();
                browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
        }
        if (browserType == null) throw new IllegalArgumentException("Could not Launch Browser for type" + browserType);
        context = browser.newContext();
        //Below line is used to start the trace file
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));
        page = context.newPage();
        threadLocalDriver.set(page);
        threadLocalContext.set(context);
        return page;
    }

    public static synchronized Page getPage() {
        return threadLocalDriver.get(); // Will return Initialized Thread Local Driver
    }}