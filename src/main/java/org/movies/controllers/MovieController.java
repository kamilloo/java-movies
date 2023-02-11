package org.movies.controllers;

import com.google.gson.Gson;
import org.movies.models.User;
import org.movies.responses.StandardResponse;
import org.movies.responses.StatusResponse;
import org.movies.services.MovieService;
import org.movies.services.MovieServiceImpl;

import static spark.Spark.*;

public class MovieController {

    static MovieService userService = new MovieServiceImpl();

    public static void main(String[] args){

        port(4567);

        post("users", (req, res) -> {
            res.type("application/json");
            User user = new Gson().fromJson(req.body(), User.class);

            userService.addUser(user);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "hello world"));
        });

        get("/users", (req,res) -> {
            res.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUsers()))
            );
        });

        options("/users/:id", (req, res) -> {
            res.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,
                    userService.userExist(req.params(":id"))? "User exists": "User does not exists"
                            )
            );
        });
    }

}
