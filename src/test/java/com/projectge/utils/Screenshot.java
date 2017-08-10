package com.projectge.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

    public static String take(WebDriver webDriver, String fileName) throws IOException {
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        String reportPath = File.separatorChar + "Report" + File.separatorChar + "Screenshots" + File.separatorChar + fileName +".jpg";
        String filePath = System.getProperty("user.dir") + File.separatorChar + "Report" + File.separatorChar + "Screenshots" + File.separatorChar + fileName +".jpg";
        FileUtils.copyFile(scrFile, new File(filePath));
        
        System.out.println("File Saved at: " + filePath);
        
        return reportPath;
    }
}
