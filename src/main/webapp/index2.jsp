<%@ include file="/common/taglibs.jsp"%>

<div class="col-sm-7">
	<div id="intro">
		<h2>Introduction to Appraisal System</h2>
		<p>
			<button class="btn btn-primary" onclick="location.href='users'">View
				Demonstration</button>
		</p>

	</div>
	<div>
		<h3>Problem Statement</h3>
		<p>There is a small organization. Which has few employees [they
			can hire many and many can leave]. The employees are working at
			different designations and grade. Based on each grade they have few
			salary components e.g.
		<ul>
			<li>Basic salary</li>
			<li>House rent allowance [ a % of Basic]</li>
			<li>Medical [ Fixed ]</li>
			<li>Conveyance [ Fixed ]</li>
			<li>Provident fund [ % of basic ]</li>
		</ul>
		The components can vary, can be increased or decreased. Each year
		employee will get their increment letter and their salary will be
		processed based on the number of days they have worked during the
		month. The software should be able to have all above mentioned
		flexibility and offer generation of annual increment letter based on
		current salary structure and should keep the record of the monthly
		wages paid to each employee. The tool should have reporting
		capabilities to show up:
		<ol>
			<li>Salary of employee year on year</li>
			<li>Salary paid to all the employees in given month/year.</li>
		</ol>
		</p>
		<p>This application has made use of Appfuse as a Rapid Application
			Framework It uses Spring + Hibernate frameworks.</p>

	</div>
</div>
<div class="col-sm-3">
<!--
	<h3>Demonstration</h3>
  <form:form commandName="employees" method="post" action="employeeform" autocomplete="off"
               onsubmit="return validateUser(this)" id="employeeForm" cssClass="well">
		
	<div class="form-group">
	<form:select path="employees" items="${employeeMap}" />
	
	 <label for="salaryYoY" class="control-label"><fmt:message key="employee.getSalaryYoY"/>:</label>
		<form:input path="salaryYoY" id="salaryYoY" cssClass="form-control"/>
	
            <button type="submit" class="btn btn-primary" name="Search" id="search">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.search"/>
            </button>

            <c:if test="${not empty param.id}">
              <button type="submit" class="btn btn-danger" name="delete" id="delete">
                  <i class="icon-trash"></i> <fmt:message key="button.delete"/>
              </button>
            </c:if>

            <a href="${ctx}/users" class="btn btn-default" id="cancel">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </a> 
        </div>
	</form:form>-->

</div>


