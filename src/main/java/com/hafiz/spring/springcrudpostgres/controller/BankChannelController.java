package com.hafiz.spring.springcrudpostgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hafiz.spring.springcrudpostgres.entity.BankChannel;
import com.hafiz.spring.springcrudpostgres.repository.BankChannelRepository;
import com.hafiz.spring.springcrudpostgres.repository.BankRepository;
import com.hafiz.spring.springcrudpostgres.repository.ChannelRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/bankchannel") // This means URL's start with /demo (after Application path)
public class BankChannelController {

	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private BankRepository bankRepository;
	@Autowired
	private ChannelRepository channelRepository;	
	@Autowired
	private BankChannelRepository bankChannelRepository;	
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewBankChannel (@RequestParam String cid
		, @RequestParam String bid, @RequestParam String desc) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		BankChannel bc = new BankChannel();
		
		bc.setBankChannelStatus(true);
		bc.setDescription(desc);
		bc.setChannelId(channelRepository.findById(cid).get());
		bc.setBankId(bankRepository.findById(bid).get());

		bankChannelRepository.save(bc);
		return "Saved";
	}	

	@GetMapping(path="/all")
	public @ResponseBody Iterable<BankChannel> getAllBankChannel() {
		// This returns a JSON or XML with the banks
		return bankChannelRepository.findAll();
	}		
	
}
