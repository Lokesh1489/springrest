package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOpertion {
	@GetMapping("/report/no/name")
	public String fetchData1(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "fromfetchdata1";
	}

	@GetMapping("/report/{no}/name")
	public String fetchData2(@PathVariable(name="name",required = false) String cname, @PathVariable(required = false) Integer no) 
	{
	return "fromfetchdata2";
	}

	@GetMapping("/report/no/{name}")
	public String fetchData3(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "fromfetchdata3";
	}

	@GetMapping("/report/{no}/{name}")
	public String fetchData4(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "fromfetchdata4";
	}
}
