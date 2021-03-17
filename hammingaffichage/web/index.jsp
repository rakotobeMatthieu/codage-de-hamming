<%@page import="hammingcodage.Partition"%>
<%@page import="java.util.Vector"%>
<!--Miantsa Zo Rajaonera-->
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%
    String bytevalue = null;
    Vector<String> code = null;
    String message = null;
    String messagerecu = null;
    Vector<String> mothamming = null;
    Partition partition = null;
    Vector<String> motcodecorrige = null;
    Vector<String> mothammingcorrige = null;
    Vector<String> messagemute = null;
    Vector<Vector<Integer>> positionerreur = null;
    int n = 0;
    int erreur =0;
    if(request.getAttribute("bytevalue")!=null) bytevalue = (String)request.getAttribute("bytevalue");
    if(request.getAttribute("code")!=null) code = (Vector<String>)request.getAttribute("code");
    if(request.getAttribute("message")!=null) message = (String)request.getAttribute("message");
    if(request.getAttribute("messagerecu")!=null) messagerecu = (String)request.getAttribute("messagerecu");
    if(request.getAttribute("n")!=null) n = Integer.parseInt( String.valueOf(request.getAttribute("n")) );
    if(request.getAttribute("erreur")!=null) erreur = Integer.parseInt( String.valueOf(request.getAttribute("erreur")) );
    if(request.getAttribute("mothamming")!=null) mothamming = (Vector<String>)request.getAttribute("mothamming");
    if(request.getAttribute("motcodecorrige")!=null) motcodecorrige = (Vector<String>)request.getAttribute("motcodecorrige");
    if(request.getAttribute("mothammingcorrige")!=null) mothammingcorrige = (Vector<String>)request.getAttribute("mothammingcorrige");
    if(request.getAttribute("partition")!=null) partition = (Partition)request.getAttribute("partition");
    if(request.getAttribute("messagemute")!=null) messagemute = (Vector<String>)request.getAttribute("messagemute");
    if(request.getAttribute("positionerreur")!=null) positionerreur = (Vector<Vector<Integer>>)request.getAttribute("positionerreur");
%>

<html>
    <head>
        <title>Hamming</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>
        <div class="row">
        <div class="col-md-12">
            <form id="form2" action="Traitementhamming" metho="get">
                    <div class="container-login100">
                            <!--<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">-->
                                            <span class="login100-form-title p-b-33">Code Hamming</span>
                                            
                                            <div class="wrap-input100 validate-input" data-validate = "Insérer votre login">
                                                    <input class="input100" type="text" name="message" placeholder="Votre message" required>
                                                    <span class="focus-input100-1"></span>
                                                    <span class="focus-input100-2"></span>
                                            </div>

                                            <div class="wrap-input100 rs1 validate-input" data-validate="Donner une valeur de n" >
                                                    <input class="input100" type="number" name="n" placeholder="Valeur de n" required>
                                                    <span class="focus-input100-1"></span>
                                                    <span class="focus-input100-2"></span>
                                            </div>
                                            
                                            <div class="wrap-input100 rs1 validate-input" data-validate="Donner le nombre d'erreur">
                                                    <input class="input100" type="number" name="erreur" placeholder="Nombre d'erreurs" required>
                                                    <span class="focus-input100-1"></span>
                                                    <span class="focus-input100-2"></span>
                                            </div>

                                            <div class="container-login100-form-btn m-t-20">
                                                <input type="submit" class="login100-form-btn" Text="Valider"/>
                                            </div>
                                            
                            <!--</div>-->   
                    </div>
            </form>
        </div>
        
         
        <div class="col-md-8 2">
            <% if(partition!=null){ %>
            <br>
            <span class="login100-form-title p-b-33">Resultats suite au code</span>
            <br><br>
            <div>
                <h5>Message initial : <% out.print(message); %></h5><br>
                <h5>Valeur de n : <% out.print(n); %></h5><br>
                <h5>Nombre d'erreurs : <% out.print(erreur); %></h5><br>
                <h5>Partition : [<% out.print(partition.getLonghamming()); %>, <% out.print(partition.getLongcode()); %>]</h5><br>
            </div>
            <div>
                <br><table class="table table-striped table-bordered">
                    <tr>
                        <th>Etat</th>
                        <th>Valeur</th>
                    </tr>
                    <tr>
                        <td>Mot binaire</td>
                        <td><% out.print(bytevalue); %></td>
                    </tr>
                    <tr>
                        <td>Bloc</td>
                        <td><% for(int i=0;i<code.size();i++){
                            out.print("["+code.get(i)+"] ");
                        }%></td>
                    </tr>
                    <tr>
                        <td>Mot de hamming</td>
                        <td><% for(int i=0;i<mothamming.size();i++){
                            out.print("["+mothamming.get(i)+"] ");
                        }%></td>
                    </tr>
                    <tr>
                        <td>Mutation</td>
                        <td><% for(int i=0;i<mothammingcorrige.size();i++){
                            out.print("["+mothammingcorrige.get(i)+"] ");
                        }%></td>
                    </tr>
                    <!--<tr>
                        <td>Position des erreurs</td>
                        <td><% for(int i=0;i<positionerreur.size();i++){
                            out.print("[");
                            for(int j=0;j<positionerreur.get(i).size();j++){
                                out.print(positionerreur.get(i).get(j)+"-");
                            }
                            out.print("],");
                        }%></td>
                    </tr>-->
                    <tr>
                        <td>Correction</td>
                        <td><% for(int i=0;i<messagemute.size();i++){
                            out.print("["+messagemute.get(i)+"] ");
                        }%></td>
                    </tr>
                    <tr>
                        <td>Bloc corrige</td>
                        <td><% for(int i=0;i<motcodecorrige.size();i++){
                            out.print("["+motcodecorrige.get(i)+"] ");
                        }%></td>
                    </tr>
                    <tr>
                        <th>Message final</th>
                        <th><% out.print(messagerecu); %></th>
                    </tr>
                </table>
            </div>
            <%}%>
        </div>
        </div>

        
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="js/main.js"></script>
    </body>
    
</html>