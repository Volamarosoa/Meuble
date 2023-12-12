<%@page import="java.util.List"%>
<%@page import="models.Matiere"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.Connection"%>
<%
    List<Matiere> liste = (List<Matiere>)request.getAttribute("liste");
%>
<%@ include file="header.jsp" %>

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
                        <h5 class="card-title">Ajout Style </h5>

                        <!-- General Form Elements -->
                        <form method="Post" action="StyleServlet">>
                            <% if(request.getAttribute("erreur") != null) { %>
                            <div class="alert alert-danger" role="alert">
                                <%= (String)request.getAttribute("erreur") %>
                            </div>
                            <% } %>
                            <div class="row mb-3">
                                <label for="inputEmail" class="col-sm-2 col-form-label">Style</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="Nom du style" name="style">
                                </div>
                            </div>
                            <div class="row mb-3">
                               <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Matiere</th>
                                    </tr>
                                </thead>
                                <tbody id="line-container-fournisseur">
                                    <tr id="tbody-fournisseur">
                                        <td>
                                            <select name="idMatiere[]" class="form-control">
                                                <% for(int i=0; i<liste.size(); i++) { %>
                                                <option  value="<%= liste.get(i).getId() %>"><%= liste.get(i).getMatiere() %></option>
                                                <% } %>
                                            </select>
                                        </td>
                                    </tr>
                                </tbody>
                                </table>
                            </div>
                            <button type="button" class="btn btn-smoke" id="ajout">Ajouter nouvelle ligne</button>
                            <button type="button" class="btn btn-smoke" id="supprimer">Supprimer ligne</button>

                            <div class="row mb-3">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary" style="margin-top: 1rem; margin-left: 8rem;">Submit Form</button>
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
<script defer>
   
   document.querySelector("#ajout").addEventListener("click", () => {
        ajoutLigne();
    });

    document.querySelector("#supprimer").addEventListener("click", () => {
        supprimerLigne();
    });

    function ajoutLigne() {
        var container = document.getElementById("line-container-fournisseur");
        var lines = document.querySelectorAll("#tbody-fournisseur");
        var newLine = lines[lines.length - 1].cloneNode(true);

        container.appendChild(newLine);
    }

   function supprimerLigne(){
       document.getElementById("line-container-fournisseur").deleteRow(1);
   }

</script>



<%@ include file="footer.jsp" %>
