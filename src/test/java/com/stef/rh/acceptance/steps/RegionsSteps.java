package com.stef.rh.acceptance.steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.stef.rh.acceptance.util.AbstractSteps;
import com.stef.rh.models.RegionsDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RegionsSteps extends AbstractSteps {

    private static final String TEST_REGION = "{ \"regionId\": 1 ,\"regionName\": \"Alsace\" }";

    private RegionsDto regionActual;
    private List< RegionsDto > listRegionActual;
    private RegionsDto regionExcept;

    @When("^l'utilisateur crée une région$")
    public void creerUneRegion() throws Throwable {
        post("/regions", TEST_REGION);
    }

    @Given("^les régions sont chargées$")
    public void chargeToutesLesRegions() throws Throwable {
        chargerDesRegions("/sql/createRegions.sql");
    }


    @When("^l'utilisateur obtient toutes régions$")
    public void getToutesLesRegions() throws Throwable {
        get("/regions", TEST_REGION);
    }

    @And("^la région a été créée avec succès$")
    public void regionCreeeAvecSucces() throws Throwable {
        assertThat(getStatusCode()).isEqualTo(200);
    }

    @And("la liste des regions n'est pas vide et une taille de {int}")
    public void listeRegionsNonVide(int size) throws Throwable {
        listRegionActual = deserialize(getResponseGetValue().getContentAsString(), new TypeReference< List< RegionsDto > >() {
        });
        assertThat(listRegionActual).isNotEmpty().hasSize(size);
    }

    @And("^l'utilisateur obtient la région créée")
    public void getRegionCreee() throws Throwable {
        regionExcept = deserialize(TEST_REGION, RegionsDto.class);
        regionActual = deserialize(getResponsePostValue().getContentAsString(), RegionsDto.class);
    }

    @Then("^l'utilisateur reçoit un code d'état de 200$")
    public void getStatutcreationOK() throws Throwable {
        assertThat(getStatusCode()).isEqualTo(200);
    }

    @And("^la région récupérée est correcte$")
    public void regionsRecueValide() throws Throwable {
        assertThat(regionActual).isNotNull();
        assertThat(regionActual.getRegionId()).isEqualTo(1L);
        assertThat(regionActual.getRegionName()).isEqualTo(regionExcept.getRegionName());
    }
}
