package com.griddynamics.skarapuhina.steps;

import com.griddynamics.skarapuhina.model.board.createBoard.CreateBoard;
import com.griddynamics.skarapuhina.model.board.getBoardsInfo.Board;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.griddynamics.skarapuhina.core.Constants.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardSteps {
    private Response response;
    private Response updateResponse;
    private String id;

    @Given("Boards list do exist")
    public void boardsListDoExist() {
        response = given()
                .contentType(ContentType.JSON)
                .get(String.format("%s1/members/%s/boards?filter=starred&%s", URL, MEMBER_ID, KEY_AND_TOKEN));
        response.then().
                statusCode(200);
    }

    @Then("Board list contains")
    public void boardListContains(DataTable table) {
        List<String> expectedItems = table.asList(String.class);
        Set<String> actualItems = new HashSet<>(response.body().jsonPath().getList("name"));

        assertThat(actualItems).isNotNull();
        assertThat(actualItems).containsAll(expectedItems);
    }

    @Given("Board with name {string} do not exist if yes delete this board")
    public void boardWithNameDoNotExistIfYesDeleteThisBoard(String boardName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Board[] list = mapper.readValue(response.getBody().prettyPrint(), Board[].class);

        for (Board board : list) {
            if (board.name.equals(boardName)) {
                id = board.id;
                break;
            }
        }
        if (id != null) {
            deleteBoardById(id);
        }
    }

    private void deleteBoardById(String boardId) {
        response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .delete(String.format("%s1/boards/%s?%s", URL, boardId, KEY_AND_TOKEN));
        response.then().
                statusCode(200);
    }

    @When("I want to create a board with name {string}")
    public void iWantToCreateABoardWithName(String boardName) {
        response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .post(String.format("%s1/boards/?name=%s&defaultLabels=true&defaultLists=true&keepFromSource=none&prefs_permissionLevel=private&prefs_voting=disabled&prefs_comments=members&prefs_invitations=members&prefs_selfJoin=true&prefs_cardCovers=true&prefs_background=blue&prefs_cardAging=regular&%s", URL, boardName, KEY_AND_TOKEN));
    }

    @When("I stared new board")
    public void iStaredBoard() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CreateBoard boardInfo = mapper.readValue(response.getBody().prettyPrint(), CreateBoard.class);
        id = boardInfo.id;
        response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .post(String.format("%s1/members/%s/boardStars?idBoard=%s&pos&%s", URL, MEMBER_ID, id, KEY_AND_TOKEN));
        response.then().
                statusCode(200);
    }

    @Then("Board was created")
    public void boardWasCreated() {
        response.then().statusCode(200);
    }

    @Then("The board with name {string} does not exist")
    public void theBoardWithNameDoesNotExist(String boardName) {
        Set<String> actualItems = new HashSet<>(response.body().jsonPath().getList("name"));
        assertThat(actualItems).doesNotContain(boardName);
    }
}
