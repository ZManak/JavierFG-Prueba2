package prueba2.manager.servlet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import jdk.jfr.internal.LogLevel;
import jdk.jfr.internal.LogTag;
import jdk.jfr.internal.Logger;
import prueba2.manager.logic.Controller;
import prueba2.manager.logic.Person;
import prueba2.manager.logic.Turn;

@WebServlet("/ManagerSv") // Esta anotación define la ruta del servlet
public class ManagerSv extends HttpServlet {
    
    private List<Person> listUsers = new ArrayList<>();
    private List<Turn> listTurns = new ArrayList<>();
    private final Controller control = new Controller();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String userName = request.getParameter("user");
        String email = request.getParameter("email");
        String ticketReference = request.getParameter("reference");
        String description = request.getParameter("description");
        String date = request.getParameter("onDate");
       
        Date onDate = formatDate(date);
        Long reference = Long.valueOf(ticketReference);
        
        Person user = new Person();
        user.setName(userName);
        user.setEmail(email);
       
        Turn turn = new Turn();
        turn.setNumber(reference);
        turn.setDescription(description);
        turn.setOnDate(onDate);
        turn.setDone(false);
        turn.setPersonId(user);
        
        listUsers = control.getAllPerson();
        if (!listUsers.contains(user)){
            control.createPerson(user);
            control.createTurn(turn);
        }        
        
        response.sendRedirect("index.jsp");
        
        } catch (ParseException ex) {
            Logger.log(LogTag.JFR_EVENT, LogLevel.TRACE, ex.getMessage());
        }
            
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               
        String email = request.getParameter("logEmail");
        
        listTurns = control.getAllTurns(email);

        request.setAttribute("userTurns", listTurns);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
                    
        }
    
    public Date formatDate(String string) throws ParseException {
       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
       Date onDate = formatter.parse(string); 
       return onDate;
    }
    
}

