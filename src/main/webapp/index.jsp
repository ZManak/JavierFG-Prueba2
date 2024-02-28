<%@page import="java.util.ArrayList"%>
<%@page import="prueba2.manager.logic.Person"%>
<%@page import="prueba2.manager.logic.Turn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Turn Manager</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

    <div class="container">
        <h1>Turn Manager</h1>
        <form action="ManagerSv" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="reference">Reference</label>
                <input type="text" class="form-control" id="reference" name="reference" required>
            </div>
            // description
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" class="form-control" id="description" name="description" required>
            // date
            <div class="form-group">
                <label for="onDate">Date</label>
                <input type="date" class="form-control" id="onDate" name="onDate" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <br>
        
        <h2>Search</h2>
        <form action="ManagerSv" method="get">
            <div class="form-group">
                <label for="logEmail">Email</label>
                <input type="email" class="form-control" id="logEmail" name="logEmail" required>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
        <br>
        // List of turns
        <table class="table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Reference</th>
                    <th>Description</th>
                    <th>Date</th>
                    <th>Done</th>
                </tr>
            </thead>
            <tbody>
                //Atribute listTurns
                <%
                    ArrayList<Turn> turns = (ArrayList<Turn>) request.getAttribute("listTurns");
                    if (turns != null) {
                        for (Turn turn : turns) {
                <tr>
                    <td><%= turn.getPersonId().getName() %></td>
                    <td><%= turn.getPersonId().getEmail() %></td>
                    <td><%= turn.getReference() %></td>
                    <td><%= turn.getDescription() %></td>
                    <td><%= turn.getOnDate() %></td>
                    <td><%= turn.isDone() %></td>
                </tr>
                %>
            </tbody>
</body>
</html>

