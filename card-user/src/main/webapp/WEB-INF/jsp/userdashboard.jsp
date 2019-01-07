<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <%@include file="header.jsp" %>
<%@include file="sidebar.jsp" %>
 
 <!-- <div class="block-header">
        <div class="row">
            <div class="col-lg-5 col-md-8 col-sm-12">                        
                <h2>Anaysis</h2>
            </div>            
            <div class="col-lg-7 col-md-4 col-sm-12 text-right">
                <ul class="breadcrumb justify-content-end">
                    <li class="breadcrumb-item"><a href="index.php"><i class="icon-home"></i></a></li>                            
                    <li class="breadcrumb-item active">View</li>
                    <li class="breadcrumb-item active">Table Normal</li>
                </ul>
            </div>
        </div>
    </div> -->

    
 
		<div class="row">
	        <div class="col-lg-6 col-md-6">
	            <div class="card open_task">
	                <div class="header">
	                    <h2>Analysis of your scan card</h2>
	                    
	                </div>
	                <!-- <div class="body"> 
	                	<div id="bar-chart" class="ct-chart"></div>
	                </div> -->
	                <%-- <div class="body"> 
	                	<canvas id="myChart" width="400" height="400"></canvas>
	                </div> --%>
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

                    <table class="table display" id="exampleTable" class="dataTable" role="grid" aria-describedby="exampleTable_info">
                        <thead>
                            <tr>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >#</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >PHONE</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >IP</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >OS</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >BROWSER</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >CITY</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >STATE</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >COUNTRY</th>
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
                            
                        </tbody>
                    </table>
                </div>
                
                </div>
        </div>

   
                    
                                       
                     

     
    	<!-- <div class="col-lg-4 col-md-12">
             <div class="card">
                 <div class="body">
                     <div class="media mleft margin-0">
    
                         <div class="media-body">
                             <small class="float-right">1 hours ago</small>
                             <h4 class="media-heading">Media heading</h4>
                             Vadodara, Gujarat, India.</div>
                         <div class="media-right p-1"> <a href="javascript:void(0);"> <img class="media-object" src="http://placehold.it/64x64" width="50" height="50"> </a> </div>
                     </div>             
                 </div>
             </div>
         </div> -->
                        
          <!-- <div class="col-lg-4 col-md-12">
              <div class="card">
                  <div class="body">
                      <div class="media mright">
                          <div class="media-body align-left">
                              <small class="float-right">1 hours ago</small>                              
                              <h4 class="media-heading">windows</h4>
                              Vadodara, Gujarat, India. </div>
                          <div class="media-right align-center"> <a href="javascript:void(0);"> <img alt="" class="media-object" src="http://placehold.it/64x64" width="64" height="64">
                              <p>chrom</p> </a> </div>
                      </div>                     
                  </div>
              </div>
          </div> -->
       	 
       	<!--  <div class="col-lg-4 col-md-12">
              <div class="card">
                  <div class="body">
                      <div class="media mright">
                          <div class="media-body align-left">
                              <small class="float-right">1 hours ago</small>                              
                              <h4 class="media-heading">windows</h4>
                              Vadodara, Gujarat, India. </div>
                          <div class="media-right align-center"> <a href="javascript:void(0);"> <img alt="" class="media-object" src="http://placehold.it/64x64" width="64" height="64">
                              <p>chrom</p> </a> </div>
                      </div>                     
                  </div>
              </div>
          </div> -->
                                  
          <!-- <div class="col-lg-4 col-md-12">
              <div class="card">
                  <div class="body">
                      <ul class="right_chat list-unstyled mb-0">
                          <li class="offline">
                              <a href="javascript:void(0);">
                                  <div class="media">
                                      <img class="media-object " src="../assets/images/xs/avatar2.jpg" alt="">
                                      <div class="media-body">
                                          <span class="name">@Isabella <small class="float-right">1 hours ago</small></span>
                                          <span class="message">Contrary to popular belief, Lorem Ipsum is not simply random text</span>
                                      </div>
                                  </div>
                              </a>                            
                          </li>
                      </ul>                            
                  </div>
              </div>
          </div> -->
       	 
                       
                    


 

<script  src="assets/profileJs/timechart.js"></script>

 <script src="assets/bundles/chartist.bundle.js"></script>
 <script src="assets/js/pages/charts/chartjs.js"></script>
 
 <!-- Javascript Chart -->
<script src="assets/vendor/c3/d3.v5.min.js"></script>
<script src="assets/vendor/c3/c3.min.js"></script>

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script> 
<script src="assets/bundles/datatablescripts.bundle.js"></script>
<script src="assets/vendor/jquery-datatable/buttons/dataTables.buttons.min.js"></script>
<script src="assets/js/pages/tables/jquery-datatable.js"></script> -->




<script>
/* /* $(document).ready(function(){ */
	//$("#qrimage").attr("src","https://chart.googleapis.com/chart?chs=100x100&cht=qr&chl=http://spectaindia.in/connect_city/");
	
	/*   $('#exampleTable').DataTable({
          'elemsPerPage': 5,
          "pagingType": "full_numbers"
      });
 }); */

/* $(document).ready(function() {
    $('#exampleTable').DataTable();
} );
 */

</script> 

<%@include file="footer.jsp" %>