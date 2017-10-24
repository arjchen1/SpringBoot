package com.example.demo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.resource.Greeting;

/*
 * https://spring.io/guides/gs/rest-hateoas/
 * 
 * The most interesting part of the method implementation is how you create the link pointing to the controller 
 * method and how you add it to the representation model. Both linkTo(…) and methodOn(…) are static methods on 
 * ControllerLinkBuilder that allow you to fake a method invocation on the controller. The LinkBuilder returned 
 * will have inspected the controller method’s mapping annotation to build up exactly the URI the method is mapped to.
 */
/*
 * curl http://localhost:8080/greeting
 * curl http://localhost:8080/greeting?name=User
 */
@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!";
	
	@GetMapping("/greeting")
	//@RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") 
            String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        Link selfLink = linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel();
        greeting.add(selfLink);

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
	
}
