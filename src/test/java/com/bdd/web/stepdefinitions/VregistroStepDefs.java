package com.bdd.web.stepdefinitions;

import com.bdd.web.steps.VregistroSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;


public class VregistroStepDefs {
    VregistroSteps vregistroSteps = new VregistroSteps();

    @Given("que la web de orange este disponible")
    public void queLaWebDeOrangeEsteDisponible()  {
        VregistroSteps.abrirpg("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @When("ingreso mis credenciales para loguearme a la pagina")
    public void ingresoMisCredencialesParaLoguearmeALaPagina() {
        VregistroSteps.login();

    }

    @And("accedo a la sección de agregar usuarios con todo y detalle")
    public void accedoALaSecciónDeAgregarUsuariosConTodoYDetalle() {
        VregistroSteps.seccionregistro();
    }
    @And("me registro correctamente con los siguientes datos {string} {string}  {string}  {string} {string} {string}")
    public void meRegistroCorrectamenteConLosSiguientesDatos(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        VregistroSteps.registrousuario(arg0,arg1,arg2,arg3,arg4,arg5);
    }

    @Then("ingreso a la sección de los usuarios registrados buscando por mi id")
    public void ingresoALaSecciónDeLosUsuariosRegistradosBuscandoPorMiId() {
        VregistroSteps.busquedausuarioregistrado();
    }





    @And("verifico que el usuario que he registrado se visualize viendo mi  {string} {string} {string}")
    public void verificoQueElUsuarioQueHeRegistradoSeVisualizeViendoMi(String arg0, String arg1, String arg2) {
        VregistroSteps.validacionidapellido(arg0,arg1,arg2);
    }
}
