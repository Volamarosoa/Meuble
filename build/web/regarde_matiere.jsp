<%@page import="models.Style"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.Connection"%>

<%@ include file="header.jsp" %>
<%
    List<Style> liste = (List<Style>)request.getAttribute("liste");
%>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Insertion</h1>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-md-2"></div>

            <div class="col-md-8">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Regarde matiere</h5>

                        <!-- General Form Elements -->
                        <form method="post" action="DetailsStyleServlet">
                            <% if(request.getAttribute("erreur") != null) { %>
                            <div class="alert alert-danger" role="alert">
                                <%= (String)request.getAttribute("erreur") %>
                            </div>
                            <% } %>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Style</label>
                                <div class="col-sm-10">
                                    <select class="form-select" aria-label="Default select example" name="idStyle" required>
                                        <option >Style</option>
                                        <% for(int i=0; i<liste.size(); i++) { %>
                                        <option value="<%= liste.get(i).getId() %>"><%= liste.get(i).getStyle()%></option>
                                        <% } %>
                                    </select>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary" style="margin-top: 1rem; margin-left: 8rem;">voir</button>
                                </div>
                            </div>

                        </form>

                    </div>
                </div>

            </div>

            <div class="col-md-2"></div>
            
        </div>
    </section>

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>
