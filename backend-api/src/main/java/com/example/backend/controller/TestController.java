package com.example.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.domain.Testes;
import com.example.backend.service.TestService;

@RestController
@CrossOrigin
class TestController{
    @Autowired
    TestService testService;

    @GetMapping(path="/testes/{id}")
    public Testes getTestes(@PathVariable("id") Integer id){
        Testes a = testService.getTestes(id);
        System .out.println(a);
        return a;
    }

    @GetMapping(path="/itigo/{num}")
    public Testes getItigo(@PathVariable("num") Integer num){
        Testes a = testService.getTestes(num);
        System.out.println(a);
        return a;
    }

    @PostMapping(path="/api/flavors")
public ResponseEntity<String> receiveFlavors(@RequestBody Map<String, Object> requestBody) {
    List<Integer> selectedFlavors = (List<Integer>) requestBody.get("flavors");
    List<Integer> selectedPurposes = (List<Integer>) requestBody.get("purposes");
    List<Integer> selectedComponents = (List<Integer>) requestBody.get("components");
    List<Integer> selectedPrices = (List<Integer>) requestBody.get("prices");
    
    System.out.println("これは味コードだよ");
    selectedFlavors.forEach(System.out::println);
    
    System.out.println("これは目的コードだよ");
    selectedPurposes.forEach(System.out::println);

    System.out.println("これは成分コードだよ");
    selectedComponents.forEach(System.out::println);

    System.out.println("これは価格コードだよ");
    selectedPrices.forEach(System.out::println);

    List<Testes> maguro = testService.findTestes(selectedFlavors,selectedPurposes,selectedComponents,selectedPrices);
    
    maguro.forEach(System.out::println);
    
    
    // do something with selectedFlavors and selectedPurposes
    return ResponseEntity.ok("コントローラーに届いたよ");
}

// @PostMapping(path="/api/flavors")
//     public ResponseEntity<String> receiveFlavors(@RequestBody Map<String, Object> requestBody) {
//         List<Integer> selectedFlavors = (List<Integer>) requestBody.get("flavors");
//         List<Integer> selectedPurposes = (List<Integer>) requestBody.get("purposes");
//         List<Integer> selectedComponents = (List<Integer>) requestBody.get("components");
//         List<Integer> selectedPrices = (List<Integer>) requestBody.get("prices");

//         List<Testes> results = testService.findTestes(selectedFlavors, selectedPurposes, selectedComponents, selectedPrices);

//         return ResponseEntity.ok("Results: " + results);
//     }



    @GetMapping(path="/hello")
    public String hello(){
        return "hello world!!!";
    }

    

}
