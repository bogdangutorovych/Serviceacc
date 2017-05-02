package ua.com.foxminded.serviceacc.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "localDateTimeConverter")
public class LocalDateTimeConvert implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
		LocalDate date = LocalDate.parse(value, formatter);
		return date;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		LocalDate dateValue = (LocalDate) value;
		return dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
