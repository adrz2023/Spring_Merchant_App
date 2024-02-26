package org.jsp.merchantwebapp.controller;

import org.jsp.merchantwebapp.dao.MerchantDao;
import org.jsp.merchantwebapp.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MerchantController {
	@Autowired
	private MerchantDao merchantDao;

	@RequestMapping(value = "/open-register")
	public ModelAndView openRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("register");
		modelAndView.addObject("m", new Merchant());
		return modelAndView;
	}
	
	@PostMapping(value = "/register")
	@ResponseBody
	public String saveMerchant(@ModelAttribute(name = "m") Merchant merchant) {
		merchant = merchantDao.saveMerchant(merchant);
		return "Merchant Saved with Id:" + merchant.getId();
	}
	
	
	
	@RequestMapping(value = "/open-update")
	public ModelAndView openUpdate(ModelAndView modelAndView) {
		modelAndView.setViewName("update");
		modelAndView.addObject("m", new Merchant());
		return modelAndView;
	}
	@PostMapping(value = "/update")
	@ResponseBody
	public String updateMerchant(@ModelAttribute(name = "m") Merchant merchant) {
		merchant = merchantDao.updateMerchant(merchant);
		if (merchant != null)
			return "Merchant  with Id:" + merchant.getId() + " updated succesfully";
		else
			return "Cannot Update Merchant as Id is Invalid";
	}
	
	@GetMapping(value = "/find-by-id")
	public ModelAndView verify(@RequestParam int id, ModelAndView modelAndView) {
		Merchant merchant = merchantDao.findById(id);
		if (merchant != null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("merchant", merchant);
			return modelAndView;
		} else {
			modelAndView.addObject("message", "Invalid Merchant Id");
			modelAndView.setViewName("error");
			return modelAndView;
		}
	}
	
	

	@RequestMapping(value = "/open-view")
	public String openView(@RequestParam String view) {
		return view;
	}
	
	@PostMapping(value = "/verify-by-Id")
	public ModelAndView verify(@RequestParam int id, @RequestParam String password, ModelAndView modelAndView) {
		Merchant merchant = merchantDao.verify(id, password);
		if (merchant != null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("merchant", merchant);
			return modelAndView;
		} else {
			modelAndView.addObject("message", "Invalid Merchant Id or Password");
			modelAndView.setViewName("error");
			return modelAndView;
		}
	}
	
	@PostMapping(value = "/verify-by-phone")
	public ModelAndView verify(@RequestParam long phone, @RequestParam String password, ModelAndView modelAndView) {
		Merchant merchant = merchantDao.verify(phone, password);
		if (merchant != null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("merchant", merchant);
			return modelAndView;
		} else {
			modelAndView.addObject("message", "Invalid Phone Number or Password");
			modelAndView.setViewName("error");
			return modelAndView;
		}
	}

	@PostMapping(value = "/verify-by-email")
	public ModelAndView verify(@RequestParam String email, @RequestParam String password, ModelAndView modelAndView) {
		Merchant merchant = merchantDao.verify(email, password);
		if (merchant != null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("merchant", merchant);
			return modelAndView;
		} else {
			modelAndView.addObject("message", "Invalid Email id or Password");
			modelAndView.setViewName("error");
			return modelAndView;
		}
	}
	
	@GetMapping(value = "/delete-by-id")
	public ModelAndView delete(@RequestParam int id, ModelAndView modelAndView) {
		boolean deleted = merchantDao.deleteById(id);
		modelAndView.setViewName("error");
		if (deleted) {
			modelAndView.addObject("message", "Merchant deleted");
			return modelAndView;
		} else {
			modelAndView.addObject("message", " Cannot deleted merchant as  Merchant Id is Invalid");
			return modelAndView;
		}
	}

	
}
