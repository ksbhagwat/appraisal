package com.symphony.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "salary")
@Indexed
@XmlRootElement
public class Salary  extends BaseObject implements Serializable{

	private static final long serialVersionUID = 1006219191675691745L;

	private Long id;
	private BigDecimal basic;
	private BigDecimal hra;
	private BigDecimal medical;
	private BigDecimal conveyance;
	private BigDecimal providendFund;
	private Employee employee;
	private Date startDate;
	private Date endDate;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "basic", nullable = false)
    @Field
	public BigDecimal getBasic() {
		return basic;
	}
	/**
	 * @param basic the basic to set
	 */
	public void setBasic(BigDecimal basic) {
		this.basic = basic;
	}

	@Column(name = "hra", nullable = false)
    @Field
	public BigDecimal getHra() {
		return hra;
	}
	/**
	 * @param hra the hra to set
	 */
	public void setHra(BigDecimal hra) {
		this.hra = hra;
	}
	@Column(name = "medical", nullable = false)
    @Field
	public BigDecimal getMedical() {
		return medical;
	}
	/**
	 * @param medical the medical to set
	 */
	public void setMedical(BigDecimal medical) {
		this.medical = medical;
	}
	@Column(name = "conveyance", nullable = false)
    @Field
	public BigDecimal getConveyance() {
		return conveyance;
	}
	/**
	 * @param conveyance the conveyance to set
	 */
	public void setConveyance(BigDecimal conveyance) {
		this.conveyance = conveyance;
	}
	@Column(name = "providend_fund", nullable = false)
    @Field
	public BigDecimal getProvidendFund() {
		return providendFund;
	}
	/**
	 * @param providendFund the providendFund to set
	 */
	public void setProvidendFund(BigDecimal providendFund) {
		this.providendFund = providendFund;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	@Column(name = "start_dt", nullable = false)
    @Field
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name = "end_dt", nullable = false)
    @Field
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basic == null) ? 0 : basic.hashCode());
		result = prime * result + ((conveyance == null) ? 0 : conveyance.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((hra == null) ? 0 : hra.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medical == null) ? 0 : medical.hashCode());
		result = prime * result + ((providendFund == null) ? 0 : providendFund.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (basic == null) {
			if (other.basic != null)
				return false;
		} else if (!basic.equals(other.basic))
			return false;
		if (conveyance == null) {
			if (other.conveyance != null)
				return false;
		} else if (!conveyance.equals(other.conveyance))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (hra == null) {
			if (other.hra != null)
				return false;
		} else if (!hra.equals(other.hra))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medical == null) {
			if (other.medical != null)
				return false;
		} else if (!medical.equals(other.medical))
			return false;
		if (providendFund == null) {
			if (other.providendFund != null)
				return false;
		} else if (!providendFund.equals(other.providendFund))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Salary [id=" + id + ", basic=" + basic + ", hra=" + hra + ", medical=" + medical + ", conveyance="
				+ conveyance + ", providendFund=" + providendFund + ", employee=" + employee + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
	
	
}
