package tests;

import application.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod
    public void startLogger(Method m){
        logger.info("=================================");
        logger.info("Start on test - " + m.getName());
    }
    @AfterMethod
    public void endLogger(Method m){
        logger.info("End of test - " + m.getName());
        logger.info("=================================");
    }

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
    //    app.stop();
    }
}
