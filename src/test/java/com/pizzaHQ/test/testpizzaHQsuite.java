package com.pizzaHQ.test;

import com.pizzaHQ.model.Menuside;
import com.pizzaHQ.model.contactForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testpizzaHQsuite {

    private WebDriver driver;
    @BeforeEach
    public void setup(){

        driver= new ChromeDriver();
        driver.get("https://d2tjwct0w5ff76.cloudfront.net/#/");
    }
    @Test
    public void verifyContactMessage(){

        var form=new contactForm(driver);
        form.fillDetails();
        form.clickSubmit();
        form.addWait();
        Assertions.assertEquals("Thanks Dan, we appreciate your feedback",driver.findElement(By.className("v-alert__content")).getText());

    }
    @Test
    public  void verifysidedish() {

        var menu = new Menuside(driver);
        driver.findElement(By.cssSelector("a[aria-label='menu']")).click();
        menu.clickSides();
        menu.addWait();
        Boolean flag = menu.verifyNew();
    }
    @AfterEach
    public void fin(){
        driver.quit();
    }
}
