package ua.com.foxminded.serviceacc.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
@ManagedBean
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	private Date utilDate;
	private LocalDate locDate;

	@Override
	public Date convertToDatabaseColumn(LocalDate locDate) {
		return asUtilDate(locDate, ZoneId.systemDefault());
	}

	@Override
	public LocalDate convertToEntityAttribute(Date utilDate) {
		return asLocalDate(utilDate, ZoneId.systemDefault());
	}

	public static java.util.Date asUtilDate(Object date, ZoneId zone) {
		if (date == null)
			return null;
		if (date instanceof java.sql.Date || date instanceof java.sql.Timestamp)
			return new java.util.Date(((java.util.Date) date).getTime());
		if (date instanceof java.util.Date)
			return (java.util.Date) date;
		if (date instanceof LocalDate)
			return java.util.Date.from(((LocalDate) date).atStartOfDay(zone).toInstant());
		if (date instanceof LocalDateTime)
			return java.util.Date.from(((LocalDateTime) date).atZone(zone).toInstant());
		if (date instanceof ZonedDateTime)
			return java.util.Date.from(((ZonedDateTime) date).toInstant());
		if (date instanceof Instant)
			return java.util.Date.from((Instant) date);

		throw new UnsupportedOperationException(
				"Don't know hot to convert " + date.getClass().getName() + " to java.util.Date");
	}

	public static LocalDate asLocalDate(Date date, ZoneId zone) {
		if (date == null)
			return null;

		if (date instanceof java.sql.Date)
			return ((java.sql.Date) date).toLocalDate();
		else
			return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDate();
	}

	public Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(Date utilDate) {
		this.utilDate = utilDate;
	}

	public LocalDate getLocDate() {
		return locDate;
	}

	public void setLocDate(LocalDate locDate) {
		this.locDate = locDate;
	}

}
