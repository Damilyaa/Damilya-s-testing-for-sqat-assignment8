package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.ExtentManager;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getExtent();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        Object instance = result.getInstance();

        if (instance instanceof BaseTest baseTest) {
            String screenshotPath = baseTest.takeScreenshot(result.getMethod().getMethodName());

            if (screenshotPath != null) {
                String relativePath = "../" + screenshotPath.replace("\\", "/");
                try {
                    test.get().addScreenCaptureFromPath(relativePath);
                } catch (Exception e) {
                    test.get().warning("Failed to attach screenshot: " + e.getMessage());
                }
            } else {
                test.get().warning("Screenshot path is null (driver may be null).");
            }
        } else {
            // Безопасно: тест не наследуется от BaseTest => не пытаемся кастить
            test.get().warning("No screenshot captured: test class does not extend BaseTest. Actual: "
                    + instance.getClass().getName());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
