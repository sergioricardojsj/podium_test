package br.com.jl.taskit.settings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotMaker {

    private static IInvokedMethod method;
    private static WebDriver driver = TLDriverFactory.getDriver();
    private static DateFormat format = new SimpleDateFormat("YYYYMMddHH:MM:ss");


    public static void takeScreenshot(boolean isError) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            String pathToEvidence =
                    System.getProperty("user.dir").concat("/evidences/")
                    .concat(Utils.METHOD_NAME).concat("_")
                    .concat(format.format(Calendar.getInstance().getTime()));

            String endFile = "";

            if (isError) {
                endFile = "_ERRO.png";
            } else {
                endFile = ".png";
            }

            FileUtils.copyFile(screenshotFile, new File(pathToEvidence + endFile));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));

    }

}
