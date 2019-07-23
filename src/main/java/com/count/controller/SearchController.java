package com.count.controller;

import com.count.model.AjaxResponseBody;
import com.count.model.SearchCriteria;
import com.count.model.Word;
import com.count.services.WordCountService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    WordCountService wordCountService = WordCountService.getInstance();

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }
        
        List<Word> words = wordCountService.findWordCount(search.getSentence()); 
        
        if (words.isEmpty()) {
            result.setMsg("no sentence found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(words);

        return ResponseEntity.ok(result);

    }


    @GetMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax() {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
//        if (errors.hasErrors()) {
//
//            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
//            return ResponseEntity.badRequest().body(result);
//
//        }

        wordCountService.resetWordCount();
        result.setMsg("success");

        return ResponseEntity.ok(result);

    }

}
