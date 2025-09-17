package co.sqasa.pageObjects;

import org.openqa.selenium.By;

public class Objects {
    public static final By DEMO_IFRAME   = By.cssSelector("iframe.demo-frame");   // iframe del demo
    public static final By INPUT_DATE    = By.id("datepicker");
    public static final By BTN_NEXT_MONTH= By.cssSelector(".ui-datepicker-next");

    public static By DAY(String day) {
        return By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//a[normalize-space()='"+day+"']");
    }
}
