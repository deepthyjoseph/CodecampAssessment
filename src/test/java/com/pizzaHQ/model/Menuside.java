package com.pizzaHQ.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menuside {
    private final WebDriver driver;
    public Menuside(WebDriver driver) {
        this.driver=driver;
    }

    public void clickSides() {
        for (var side:driver.findElements(By.cssSelector("div[role='tab']")))
        {
            if(side.findElement(By.tagName("i")).getText().equalsIgnoreCase("fastfood"))
            {
                side.click();
            }

        }
    }

    public boolean verifyNew() {
        WebElement newSide=driver.findElement(By.className("ribbon-top-left"));
         if(newSide.findElement(By.className("v-badge")).getText().equalsIgnoreCase("Korean Sticky Wings"))
         {
          //   if (newSide.findElement(By.cssSelector("img[alt='Korean Sticky Wings']"))){
                return true;
          //  }
        }
         return false;
    }

    public void addWait() {
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-badge"))));
    }
}
