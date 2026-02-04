import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.Boite;
import org.example.Colis;
import org.example.Lettre;
import org.example.Publicite;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

// PROGRAMME Test (non demandé)
public class Poste {

    private static ExtentReports extent;
    private static ExtentTest test;

    // ============================================
    // INITIALISATION DU REPORT
    // ============================================
    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter reporter =
                new ExtentSparkReporter("reports/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","QA Engineer");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Application","BAL_RARY");
        extent.setSystemInfo("Environment", "Testing");
        extent.setSystemInfo("Department", "QA");
        extent.setSystemInfo("Company", "capgemini");
        extent.setSystemInfo("Build Number","1.0.0");
        extent.setSystemInfo("Sprint", "Sprint 1");
    }

    @BeforeMethod
    public void setUpTest(java.lang.reflect.Method method){
        test = extent.createTest(method.getName());
    }

    @Test
    public void testValid() {
        //Creation d'une boite-aux-lettres
        Boite boite = new Boite(30);

        //Creation de divers courriers/colis..
        Lettre lettre1 = new Lettre(200, true, "1 place de la Pyramide 92911 La Defense", "A3");

        Publicite pub1 = new Publicite(1500, true, "147 Quai du Président Roosevelt, 92130 Issy-les-Moulineaux");

        Colis colis1 = new Colis(5000, true, "18 Rue rapail, 75002 Paris", 30);

        boite.ajouterCourrier(lettre1);
        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(colis1);

        System.out.println("Le montant total d'affranchissement est de " + boite.affranchir());
        boite.afficher();

        System.out.println("La boite contient " + boite.courrierInvalides() + " courriers invalides");

        Assert.assertEquals(boite.courrierInvalides(),0,"La boite contient des courriers invalides");
    }

    @Test
    public void testInvalid() {
        //Creation d'une boite-aux-lettres
        Boite boite = new Boite(30);

        //Creation de divers courriers/colis..
        Lettre lettre1 = new Lettre(200, true, "1 place de la Pyramide 92911 La Defense", "A3");
        Lettre lettre2 = new Lettre(800, false, "", "A4"); // invalide

        Publicite pub1 = new Publicite(1500, true, "147 Quai du Président Roosevelt, 92130 Issy-les-Moulineaux");
        Publicite pub2 = new Publicite(3000, false, ""); // invalide

        Colis colis1 = new Colis(5000, true, "18 Rue rapail, 75002 Paris", 30);
        Colis colis2 = new Colis(3000, true, "7 Avenue de la poste, 59000 Lille", 70); //Colis invalide !

        boite.ajouterCourrier(lettre1);
        boite.ajouterCourrier(lettre2);
        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(pub2);
        boite.ajouterCourrier(colis1);
        boite.ajouterCourrier(colis2);

        System.out.println("Le montant total d'affranchissement est de " + boite.affranchir());
        boite.afficher();

        System.out.println("La boite contient " + boite.courrierInvalides() + " courriers invalides");

        Assert.assertEquals(boite.courrierInvalides(),0,"La boite contient des courriers invalides");
    }

    @AfterMethod
    public void logResult(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test réussi ✅");
        }
        else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test échoué ❌");
            test.fail(result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test ignoré ⚠️");
        }
    }

    @AfterSuite
    public void tearDownReport(){
        extent.flush();
    }


}