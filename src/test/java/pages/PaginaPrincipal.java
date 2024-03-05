package pages;

public class PaginaPrincipal extends BasePage {
 
    private String searchButton = "//a[@href='/selenium-y-cucumber-java'][normalize-space()='Ver curso']";
    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String planButton = "//a[normalize-space()='Elegir Plan' and @href]";

    public PaginaPrincipal() {
        super(driver);
    }
 
    // Método para navegar a www.freerangetesters.com
    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com");
    }

    public void clicOnSectionVerCurso() {
        clickElement(searchButton);
    }
    
    public void clickOnSectionNavigationBar(String section) {
        //Reemplaza el marcador de posicion de sectionlink con el nombre
        String xpathSection = String.format(sectionLink,section);
        clickElement(xpathSection);
    }

    public void clickOnElegirPlanButton() {
        clickElement(planButton);
    }
}