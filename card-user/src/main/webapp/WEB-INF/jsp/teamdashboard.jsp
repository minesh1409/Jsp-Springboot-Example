<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@include file="header.jsp" %>
<%@include file="sidebar.jsp" %>
 
 

		<div class="card">
				<h5 class="header" style="float: left;">
						Add/View Member's Analysis
				</h5>
				<div class="header" style="float: right;">
					Member Share Id
					<form action="/addmember" method="post">
				  		<div class="input-group" style="display: flex;">
				            <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's share id" aria-describedby="basic-addon2">
				            <div class="input-group-append">
				                <button class="btn btn-outline-secondary" type="button">Add</button>
				               <!--  <button class="btn btn-outline-secondary" type="button">View</button> -->
				            </div>
				         </div>
			        </form>
				</div>
		                  
                <div class="body table-responsive social_media_table">
		       	<% int i = 1; %>
		         <table class="table table-hover" id="cardIdTable" style="text-align: center;">
		             <thead>
		                 <tr>
		                     <th>#</th>
		                     <th>User</th>	                
		                     <th>ACTION</th>
		                 </tr>
		             </thead>
		             <tbody id="tbody">                    
						<c:forEach var="card" items="${cardIdList}">
						<tr>
						<td style="white-space: normal" class="sorting_1"><%=i++%></td>
						<td style="padding: 0px;"><img src="${card.image}"  alt=""> ${card.name}</td>
						<td>
							<%-- <button type="button" class="btn btn-link btn-sm " title="Profile" name="${member.id}"><i class="fa fa-edit"></i></button> --%>
							<button type="button" class="btn btn-link btn-sm " title="View" name="${member.id}"><i class="fa fa-2x fa-bar-chart-o text-col-green"></i></button>
							<button type="button" data-type="confirm" class="btn btn-link btn-sm js-sweetalert" title="Delete" onclick="location.href='/deletemember/${member.id}'">
							<i class="fa fa-trash-o text-danger"></i>
							</button>
						</td>
					</tr>
						</c:forEach>
						
						<tr>
						<td style="white-space: normal" class="sorting_1"><%=i++%></td>
						<td style="padding: 0px;"><img src="https://chart.googleapis.com/chart?chs=50x50&cht=qr&chl= ${card.name}"  alt="">name</td>
						<td>
							<%-- <button type="button" class="btn btn-link btn-sm " title="Profile" name="${member.id}"><i class="fa fa-edit"></i></button> --%>
							<button type="button" class="btn btn-link btn-sm " title="View" name="${member.id}"><i class="fa fa-2x fa-bar-chart-o text-col-green"></i></button>
							<button type="button" data-type="confirm" class="btn btn-link btn-sm js-sweetalert" title="Delete" onclick="location.href='/deletemember/${member.id}'">
							<i class="fa fa-trash-o text-danger"></i>
							</button>
						</td>
					</tr>
						
		             </tbody>
		         </table>
		       </div>
          
              </div> <!-- end card -->
    
 
		<%-- <div class="row">
	        <div class="col-lg-6 col-md-6">
	            <div class="card open_task">
	                <div class="header">
	                    <h2>Analysis of your scan card</h2>
	                    
	                </div>
	                
	                <div class="body">
	                    <div id="chart-time"></div>
	                </div>
	                
	            </div>
	        </div>
	        
	       <div class="col-lg-6 col-md-6">
	            <div class="card open_task">
	                <div class="header">
	                    <h2>Analysis of your download contact</h2>
	                </div>
	                
	                <div class="body">
	                    <div id="chart-time-download"></div>
	                </div>
	                
	            </div>
	        </div> 
        </div>
        
        
        <div class="col-lg-12 col-md-12">
            <div class="card open_task">
                <div class="header">
                    <h2>Scanning data of your card</h2>
                     </div>
        <div class="body table-responsive">

                    <table class="table table-hover" id="TeamAnalysisTable" style="text-align: center;">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>PHONE</th>
                                <th>IP</th>
                                <th>OS</th>
                                <th>BROWSER</th>
                                <th>CITY</th>
                                <!-- <th>STATE</th>
                                <th>COUNTRY</th> -->
                            </tr>
                        </thead>
                        <tbody id="tableBody" >
                            <!-- Dynamic Generate data for Analysis-->
                            
                           
                            <% int i = 1;%>
                           <c:forEach var="analysis" items="${analysisList}" >
                            
                            <tr role="row">
	                            <td style="white-space: normal" class="sorting_1"><%=i++%></td>
	                            <td style="white-space: normal">${analysis.mobile}</td>
	                            <td style="white-space: normal">${analysis.ip}</td>
	                            <td style="white-space: normal">${analysis.os}</td>
	                            <td style="white-space: normal">${analysis.browser}</td>
	                            <td style="white-space: normal">${analysis.city}</td>
	                            <td style="white-space: normal">${analysis.state}</td>
	                            <td style="white-space: normal">${analysis.country}</td>
                            </tr>
                            
                            </c:forEach>  
                            			<!-- <tr>
                                            <td class="sorting_1">Airi Satou</td>
                                            <td>Accountant</td>
                                            <td>Tokyo</td>
                                            <td>33</td>
                                            <td>2008/11/28</td>
                                            <td>$162,700</td>
                                        </tr> -->
                                        
                                        
                                        
                            
                        </tbody>
                    </table>
                </div>
                
                </div>
        </div>
 --%>
   
 

 <script  src="assets/profileJs/timechart.js"></script>
 
 <script src="assets/bundles/chartist.bundle.js"></script>
 <script src="assets/js/pages/charts/chartjs.js"></script>
 
 <!-- Javascript Chart -->
<script src="assets/vendor/c3/d3.v5.min.js"></script>
<script src="assets/vendor/c3/c3.min.js"></script>


<script>
 $( document ).ready(function() {
     console.log( "ready!" );
     $('#TeamAnalysisTable').DataTable({
         'elemsPerPage': 5,
         "pagingType": "full_numbers"
     });
    
 });
</script> 



<!-- Javascript  Datatable-->
<script src="assets/bundles/datatablescripts.bundle.js"></script>
<script src="assets/vendor/jquery-datatable/buttons/dataTables.buttons.min.js"></script>
<script src="assets/vendor/jquery-datatable/buttons/buttons.bootstrap4.min.js"></script>
<script src="assets/vendor/jquery-datatable/buttons/buttons.colVis.min.js"></script>
<script src="assets/vendor/jquery-datatable/buttons/buttons.html5.min.js"></script>
<script src="assets/vendor/jquery-datatable/buttons/buttons.print.min.js"></script>
<script src="assets/vendor/sweetalert/sweetalert.min.js"></script> <!-- SweetAlert Plugin Js --> 
<script src="assets/js/pages/tables/jquery-datatable.js"></script>

<%@include file="footer.jsp" %>