<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="header.jsp" %>
<%@include file="sidebar.jsp" %>

<div class="row clearfix">

                    <div class="col-lg-4" >
                        <div class="card">
                            <div class="body">
                                <button style="margin-bottom: 15px;" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#basciinfo">Add Basic Information</button>
                                <button style="margin-bottom: 15px;" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#contactinfo">Add Contact Information</button>
                                <button style="margin-bottom: 15px;" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#social">Add Social Information</button>
                                <button style="margin-bottom: 15px;" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#education">Add Education </button>
                                <button style="margin-bottom: 15px;" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#experience">Add Experience</button>
                                <button style="margin-bottom: 15px;" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#achievement">Add Achievement </button>
                                <button style="margin-bottom: 15px;" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#skill">Add Skill</button>
                            </div>
                        </div>
                    </div>


                    <div class="modal fade" id="basciinfo" tabindex="-1" role="dialog" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="title" id="defaultModalLabel">Basic Information</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" class="form-control" placeholder="First Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" class="form-control" placeholder="Last Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-line">
                                            <label>Birthdate</label>
                                            <div class="input-group mb-3">                                        
                                                <input data-provide="datepicker" data-date-autoclose="true" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Gender</label>
                                        <br>
                                        <label class="fancy-radio">
                                            <input type="radio" name="gender" value="male" required="" data-parsley-errors-container="#error-radio" data-parsley-multiple="gender">
                                            <span><i></i>Male</span>
                                        </label>
                                        <label class="fancy-radio">
                                            <input type="radio" name="gender" value="female" data-parsley-multiple="gender">
                                            <span><i></i>Female</span>
                                        </label>
                                        <p id="error-radio"></p>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary">Add</button>
                                    <button type="button" class="btn btn-simple" data-dismiss="modal">CLOSE</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="contactinfo" tabindex="-1" role="dialog" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="title" id="defaultModalLabel">Contact Information</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <input type="number"  class="form-control" placeholder="Contact Number">
                                        <span class="help-block">(999) 999-9999</span>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control"  placeholder="Email Address" required="">
                                        <span class="help-block">xyz@xyz.com</span>
                                    </div>

                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="basic-addon3">https://www.</span>
                                        </div>
                                        <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" placeholder="website">
                                    </div>
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" class="form-control" placeholder="Address">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" class="form-control" placeholder="State">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" class="form-control" placeholder="Country">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" class="form-control" placeholder="Pincode">
                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary">Add</button>
                                    <button type="button" class="btn btn-simple" data-dismiss="modal">CLOSE</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="social" tabindex="-1" role="dialog" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="title" id="defaultModalLabel">Add Social</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">       <!--style=" width: 200px; align-item:center"-->                          
                                        <select class="custom-select" id="Socialname">
                                            <option value="0">Facebook</option>
                                            <option value="1">Google Plus</option>
                                            <option value="2">Twitter</option>
                                            <option value="3">Instagram</option>
                                            <option value="4">Linked In</option>
                                            <option value="5">Skype</option>
                                            <option value="6">Youtube</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Social URL">
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary">Add</button>
                                    <button type="button" class="btn btn-simple" data-dismiss="modal">CLOSE</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="education" tabindex="-1" role="dialog" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="title" id="defaultModalLabel">Add Education Detail</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">                                 
                                        <input type="text" class="form-control" placeholder="Degree">
                                    </div>
                                    <div class="form-group">                                 
                                        <input type="text" class="form-control" placeholder="Universit">
                                    </div>
                                    <div class="form-group">                                 
                                        <input type="number" class="form-control" placeholder="Passing Year" maxlength="4" required>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary">Add</button>
                                    <button type="button" class="btn btn-simple" data-dismiss="modal">CLOSE</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="experience" tabindex="-1" role="dialog" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="title" id="defaultModalLabel">Add Experience Detail</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">                                 
                                        <input type="text" class="form-control" placeholder="Job Posation">
                                    </div>
                                    <div class="form-group">                                 
                                        <input type="text" class="form-control" placeholder="Company">
                                    </div>
                                    <div class="form-group">                                 
                                        <input type="number" class="form-control" placeholder="Duration" maxlength="2" required>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary">Add</button>
                                    <button type="button" class="btn btn-simple" data-dismiss="modal">CLOSE</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="achievement" tabindex="-1" role="dialog" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="title" id="defaultModalLabel">Add Achievement Detail</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">                                 
                                        <input type="text" class="form-control" placeholder="Achievement Name">
                                    </div>
                                    <div class="form-group">
                                        <div class="form-line">
                                            <textarea class="form-control no-resize" placeholder="Achievement Description..."></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary">Add</button>
                                    <button type="button" class="btn btn-simple" data-dismiss="modal">CLOSE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="modal fade" id="skill" tabindex="-1" role="dialog" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="title" id="defaultModalLabel">Add Skill</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Skill Name">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="0 - 100">
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary">Add</button>
                                    <button type="button" class="btn btn-simple" data-dismiss="modal">CLOSE</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>


<%@include file="footer.jsp" %>