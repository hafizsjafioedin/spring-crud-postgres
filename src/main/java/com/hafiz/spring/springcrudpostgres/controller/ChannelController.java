package com.hafiz.spring.springcrudpostgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hafiz.spring.springcrudpostgres.entity.Channel;
import com.hafiz.spring.springcrudpostgres.repository.ChannelRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/channel") // This means URL's start with /demo (after Application path)
public class ChannelController {

	
	@Autowired
	private ChannelRepository channelRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewChannel (@RequestParam String id
		, @RequestParam String name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Channel c = new Channel();
		c.setChannelId(id);
		c.setChannelName(name);
		channelRepository.save(c);
		return "Saved";
	}	

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Channel> getAllChannel() {
		// This returns a JSON or XML with the banks
		return channelRepository.findAll();
	}		
	
}
