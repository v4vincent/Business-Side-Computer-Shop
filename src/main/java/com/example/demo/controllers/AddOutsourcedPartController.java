package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddOutsourcedPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        Part part=new OutsourcedPart();
        theModel.addAttribute("outsourcedpart",part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("outsourcedpart", part);

        // Check inventory levels
        if (part.getInv() < part.getMinInv()) {
            theModel.addAttribute("errorMessage", "Inventory is less than the minimum required.");
            return "OutsourcedPartForm";
        }

        if (part.getInv() > part.getMaxInv()) {
            theModel.addAttribute("errorMessage", "Inventory exceeds the maximum limit.");
            return "OutsourcedPartForm";
        }

        if (bindingResult.hasErrors()) {
            return "OutsourcedPartForm";
        }

        OutsourcedPartService outsourcedPartService = context.getBean(OutsourcedPartServiceImpl.class);
        outsourcedPartService.save(part);
        return "confirmationaddpart";
    }




}