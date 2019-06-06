package com.udemy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.entity.Item;
import com.udemy.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	
	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkResult(){
		ContactModel model = new ContactModel(1, "firstname", "lastname", "city", "telephone");
		return new ResponseEntity<ContactModel>(model, HttpStatus.OK);
	}
	
	@PostMapping("/item")
	public ResponseEntity<Item> postItem(@RequestBody Item item){
		System.out.println("ITEM  - " + item.toString());
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
}
