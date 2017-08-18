package com.theironyard.not.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.theironyard.not.blackjack.models.FaceCart;
import com.theironyard.not.blackjack.models.Handle;
import com.theironyard.not.blackjack.models.NumberCart;

@Controller
@RequestMapping("/")
public class NotBlackjackController {

	@GetMapping("")
	public ModelAndView notAGame() {
		Handle handle = new Handle();
		handle.addCart(new FaceCart("K", "Almonds"));
		handle.addCart(new NumberCart(4, "Almonds"));
		
		ModelAndView mv = new ModelAndView("not-blackjack/not-a-game");
		mv.addObject("handle", handle);
		
		return mv;
	}
	
}






