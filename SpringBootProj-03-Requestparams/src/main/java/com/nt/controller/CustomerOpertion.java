package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOpertion {
	@GetMapping("/xyz")
	public String reportData(@RequestParam Integer no, @RequestParam String cname)
	{
		return no+""+cname;
	}
}

