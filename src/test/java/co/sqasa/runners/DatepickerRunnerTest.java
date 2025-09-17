package co.sqasa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "classpath:features",   // busca bajo test/resources/features
        glue = "co.sqasa",
        plugin = {"pretty"}
        // , tags = "@datepicker"          // déjalo comentado hasta ver tests en el reporte
)
public class DatepickerRunnerTest {}
