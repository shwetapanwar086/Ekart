package com.MobiShop.MobiShopBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MobiShop.MobiShopBackend.Util.Util;
import com.MobiShop.MobiShopBackend.dao.SupplierDao;
import com.MobiShop.MobiShopBackend.model.Supplier;


@Controller
public class SupplierController {
	private SupplierDao supplierDAO;

	@Autowired(required = true)
	@Qualifier(value = "supplierDAO")
	public void setSupplierDAO(SupplierDao ps) {
		this.supplierDAO = ps;
	}

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public String listSuppliers(Model model) {
		System.out.println("Hello.. I'm inside /supplier list");
		model.addAttribute("isAdminClickedSuppliers", "true");
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", this.supplierDAO.list());
		return "Admin";
	}

	// For add and update supplier both
	@RequestMapping(value = "/supplier/add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier) {
		System.out.println("Hello.. I'm inside /supplier add");
		String newID = Util.removeComma(supplier.getId());
		supplier.setId(newID);
		supplierDAO.saveOrUpdate(supplier);

		return "redirect:/suppliers";

	}

	@RequestMapping("/supplier/remove/{id}")
	public String removeSupplier(@PathVariable("id") String id, ModelMap model) throws Exception {
		System.out.println("Hello.. I'm inside /supplier remove");
		try {
			supplierDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/suppliers";
	}

	@RequestMapping("/supplier/edit/{id}")
	public String editSupplier(@PathVariable("id") String id, Model model) {
		System.out.println("editSupplier");
		model.addAttribute("isAdminClickedEditSuppliers", "true");
		model.addAttribute("supplier", this.supplierDAO.get(id));
		return "Admin";
	}
}
