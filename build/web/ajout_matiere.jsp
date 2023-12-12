<%@page import="java.util.Vector"%>
<%@page import="java.sql.Connection"%>

<%@ include file="header.jsp" %>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Insertion</h1>
    </div>

    <section class="section">
        <div class="row">
            <div class="col-md-2"></div>

            <div class="col-md-8">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajout Matiere</h5>

                        <!-- General Form Elements -->
                        <form method="Post" action="MatiereServlet">
                            
                            <% if(request.getAttribute("erreur") != null) { %>
                            <div class="alert alert-danger" role="alert">
                                <%= (String)request.getAttribute("erreur") %>
                            </div>
                            <% } %>
                            <div class="row mb-3">
                                <label for="inputEmail" class="col-sm-2 col-form-label">Matiere</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="Nom du matiere" name="matiere">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary" style="margin-top: 1rem; margin-left: 8rem;">AJOUTER</button>
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
