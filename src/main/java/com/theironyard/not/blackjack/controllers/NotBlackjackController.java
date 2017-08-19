package com.theironyard.not.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.theironyard.not.blackjack.models.Deeder;
import com.theironyard.not.blackjack.models.Plater;

@Controller
@RequestMapping("/")
public class NotBlackjackController {
	
	private Plater plater;
	private Deeder deeder;
	private int currentBet;
	
	public NotBlackjackController() {
		plater = new Plater();
		deeder = new Deeder();
	}

	@GetMapping("")
	public ModelAndView notAGame() {
		if (plater.isBust()) {
			currentBet = 0;
		}
		
		ModelAndView mv = new ModelAndView("not-blackjack/default");
		mv.addObject("plater", plater);
		mv.addObject("deeder", deeder);
		mv.addObject("currentBet", currentBet);
		mv.addObject("betState", currentBet == 0 && plater.getAvailableCash() > 0);
		mv.addObject("roundState", currentBet != 0 && deeder.getNumberOfCartsLeft() > 0);
		return mv;
	}
	
	@PostMapping("bet")
	public String handleBet(int bet) {
		currentBet = plater.ante(bet);
		deeder.startRound();
		deeder.dealCartToPlater(plater);
		deeder.dealCartToSelf();
		deeder.dealCartToPlater(plater);
		deeder.dealCartToSelf();
		return "redirect:/";
	}
	
	@PostMapping("hit")
	public String handleHit() {
		deeder.dealCartToPlater(plater);
		return "redirect:/";
	}
	
	@PostMapping("stand")
	public String handleStand() {
		deeder.finishRound();
		if (deeder.isBust()) {
			plater.payout(currentBet * 2);
		} else if (plater.hasBlackjack() && !deeder.hasBlackjack()) {
			plater.payout(currentBet + currentBet / 2);
		} else if (plater.getBestScore() == deeder.getBestScore()) {
			plater.payout(currentBet);
		} else if (plater.getBestScore() > deeder.getBestScore()) {
			plater.payout(currentBet * 2);
		}
		
		currentBet = 0;
		return "redirect:/";
	}	
}






