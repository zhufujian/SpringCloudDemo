package com.study.demo.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.demo.bean.Person;

@RestController
public class ServerController {

	@RequestMapping(value="search/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Person searchPerson(@PathVariable Integer id,HttpServletRequest request){
		Person person = new Person();
		person.setId(id);
		person.setName("Spirit");
		person.setInfo(request.getRequestURL().toString());
		return person;
	}
}
