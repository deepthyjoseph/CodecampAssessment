package com.pizzaHQ.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contactForm {
    private final WebDriver driver;

    public contactForm(WebDriver driver) {
        this.driver=driver;
    }

    public void fillDetails() {
        driver.findElement(By.cssSelector("a[aria-label='contact']")).click();
        driver.findElement(By.id("forename")).sendKeys("Dan");
        driver.findElement(By.id("email")).sendKeys("dan@abc.com");
        driver.findElement(By.id("message")).sendKeys("Nice Pizza");
    }

    public void clickSubmit() {
        driver.findElement(By.cssSelector("a[aria-label='submit']")).click();
    }

    public void addWait() {
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-alert__content"))));
    }
}
