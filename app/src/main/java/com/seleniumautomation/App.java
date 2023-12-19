/**
 * This application will run Google Chrome and scrape link list and add into dictionary Array.
 */
package com.seleniumautomation;

import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Goto Website Link
        driver.get("https://mvnrepository.com/");

        // linkList Object
        List<Map<String, Object>> linkList = new ArrayList<>();

        // Get all links from html elements.
        var links = driver.findElements(By.cssSelector(".im-title > a[href*=\"/artifact/io.qtjambi\"]"));

        // Loop all links and append to linkList
        for(var link: links){
            Map<String, Object> linkData = new HashMap<>();
            linkData.put("title", link.getText());
            linkData.put("link", link.getAttribute("href"));
            linkList.add(linkData);
        }

        System.out.print("Pree any key to exit...");
        scanner.nextLine();
        scanner.close();

        driver.quit();
    }
}