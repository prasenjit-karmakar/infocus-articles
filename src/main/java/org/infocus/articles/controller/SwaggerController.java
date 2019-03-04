/*
 * Copyright 2017, Optimal Payments PLC, 2 Place Alexis Nihon, suite 700, Westmount, Quebec, Canada
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of Optimal Payments PLC
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with Optimal
 * Payments.
 */

package org.infocus.articles.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * SwaggerController for swagger.
 *
 * @author prasenjitkarmakar 
 */
@RestController
public class SwaggerController {

  /**
   * home.
   *
   * @return String
   */
  @RequestMapping("/")
  public ModelAndView home() {

    return new ModelAndView("redirect:/swagger-ui.html");
  }

}