package com.thoughtstreamllc.courses;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        get("/", ((request, response) -> {
            return new ModelAndView(null, "index.hbs");
        }), new HandlebarsTemplateEngine());

        post("/sign-in", ((request, response) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", request.queryParams("username"));
            return new ModelAndView(model, "sign-in.hbs");
        }), new HandlebarsTemplateEngine());
    }
}
