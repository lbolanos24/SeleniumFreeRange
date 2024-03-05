package steps;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
//import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;

import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

public class FreeRangeSteps {

    //SoftAssert soft = New SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT(){
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to the course")
    public void navigationVerCurso(){
        landingPage.clicOnSectionVerCurso();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section){
        landingPage.clickOnSectionNavigationBar(section);

    }

    @When("^(?:I|The user|The client) selects? Elegir Plan$")
    public void selectElegirPlan(){
        landingPage.clickOnElegirPlanButton();
    }

    @And("^(?:I|The user|The client) selects? Introduction to Testing$")
    public void NavigatesToIntro(){
            cursosPage.clickFundamentosTestingLink();
            fundamentosPage.clickIntroduccionTestingLink();
        }

    @Then("^(?:I|The user|The client) can validate the options in the checkout page$")
    public void validateChecoutPlans(){
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes \u2022 12 productos","Academia: $176 / a\u00f1o \u2022 12 productos", "Free: Gratis \u2022 1 producto");
        // Cambie los caracteres especiales  • por \u2022 y ñ por \u00f1
        Assert.assertEquals(lista,listaEsperada);
    }

/*
    public void Ejemplolis(){
        //verificar dos valores iguales
        String palabraEsperada= "Pepe";
        String palabraEncontrada= "Papa";


        //no iguales
        Assert.assertNotEquals(palabraEncontrada, palabraEsperada);

        //Iguales
        Assert.assertEquals(palabraEncontrada, palabraEsperada);

        //condicion verdadera
        Assert.assertTrue(palabraEsperada.contains(palabraEncontrada));

        //condicion falsa
        Assert.assertFalse(palabraEsperada.contains(palabraEncontrada));

        // Soft Assertions: No detienen la ejecucion, indican al final

        soft.assertEquals(palabraEncontrada, palabraEsperada);
        soft.assertTrue(palabraEsperada.contains(palabraEncontrada));
        soft.assertNotEquals (palabraEncontrada, palabraEsperada);
        // al final verifica tidos los soft assert
        soft.assertAll();
    }
*/
}
