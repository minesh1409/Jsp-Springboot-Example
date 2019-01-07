<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
	
<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>


<!-- <div class="block-header">
    <div class="row">
        <div class="col-lg-5 col-md-8 col-sm-12">                        
            <h2>Generate Card </h2>
        </div> 

    </div>
</div> -->



    <div class="col-lg-12 col-md-12">
        <div class="card">
            <div class="header">				
                <h2>Generate Card Id </h2>
                <p></p>
                <div align="right"> 
                <form action="gencardid" method="post">
                	<div class="row">
                      <div class="col-lg-2 col-md-2">           
							<input type="number" name="GenNo" class="form-control" value="1" placeholder="No. Generator of Card"/>
							<p></p>
				      </div>
				      <div class="col-lg-2 col-md-2">    
				      	<button type="submit" class="btn btn-success"> Generate Card </button>
				      </div>
                	</div>
                </form>
                </div>
				
            </div>

            <div class="body table-responsive social_media_table">
            <% int i = 1; %>
                <table class="table table-hover" id="cardIdTable" style="text-align: center;">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>QR</th>
                            <th>LINK</th>
                            <th>MOBILE</th>
                            <th>STATUS</th>
                            <!-- <th>ACTION</th> -->
                        </tr>
                    </thead>
                    <tbody id="tbody">                    
						<c:forEach var="card" items="${cardIdList}">
							<tr>
								<td style="white-space: normal" class="sorting_1"><%=i++%></td>
								<td style="padding: 0px;"><img src="https://chart.googleapis.com/chart?chs=50x50&cht=qr&chl= ${card.cardLink}"  alt=""></td>
								<td>${card.cardLink}</td>
								<td>${card.mobile}</td>								
								<td>${card.status}</td>																	
								<%-- <td><button data-toggle="modal" data-target="#skill"
									type="button" class="btn btn-link btn-sm editSkill" title="Edit"
									name="${card.id}">
									<i class="fa fa-edit"></i>
									</button>
									<button type="button" data-type="confirm"
									class="btn btn-link btn-sm js-sweetalert" title="Delete"
									onclick="location.href='/deleteskill/${card.id}'">
									<i class="fa fa-trash-o text-danger"></i>
								</button>
								</td> --%>
							</tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
<!---->

<script src="assets/profileJs/profile.admin.js">   </script>

<%@include file="footer.jsp"%>
    