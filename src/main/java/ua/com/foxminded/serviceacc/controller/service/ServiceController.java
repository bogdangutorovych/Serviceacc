package ua.com.foxminded.serviceacc.controller.service;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Controller;

@Controller
@ViewScoped
@ManagedBean
public class ServiceController implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text;

	private Double input2 = new Double(0);

	public Double getInput2() {
		return input2;
	}

	public void setInput2(Double input2) {
		this.input2 = input2;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
