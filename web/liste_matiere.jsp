<%@page import="models.Style"%>
<%@page import="models.Matiere"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.Connection"%>

<%@ include file="header.jsp" %>

<%
    List<Matiere> liste = (List<Matiere>)request.getAttribute("liste");
    Style style = (Style)request.getAttribute("style");
%>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Liste des matieres par style</h1>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-md-2"></div>

            <div class="col-md-8">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Liste Matiere</h5>

                        <!-- General Form Elements -->
                            <h5>Style : <%= style.getStyle()%></h5>

                            <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Matiere</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for(int i=0; i<liste.size(); i++) { %>
                                <tr>
                                    <td><%= liste.get(i).getMatiere() %></td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                        

                    </div>
                </div>

            </div>

            <div class="col-md-2"></div>
            
        </div>
        <a href="DetailsStyleServlet"> <button type="submit" class="btn btn-primary" style="margin-top: 1rem; margin-left: 8rem;">Retour</button> </a>


    </section>

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>
