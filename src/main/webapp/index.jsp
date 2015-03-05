<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <!--Extension to bind JSon to the HTML Table -->
    <link rel="stylesheet" href="resources/bootstrap-table.css">
    <!--JQuery component to open the edit and create new form in a responsive popup window -->
    <link rel="stylesheet" href="resources/magnific-popup.css"> 
    <!-- This projects custom CSS -->
    <link rel="stylesheet" href="resources/announcement.css"> 
    
  </head>
  <body>
    <h1>Announcements</h1>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    
    <script src="resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
    
    <!--Extension to bind JSon to the HTML Table -->
    <script src="resources/bootstrap-table.js"></script>
   
    <!--JQuery component to open the edit and create new form in a responsive popup window -->
    <script src="resources/jquery.magnific-popup.min.js"></script>
    
    <!--load this project's java script work -->
    <script src="resources/announcement.js"></script>
    
    <table data-toggle="table" data-url="<%= request.getContextPath() %>/webresources/rest/get" data-cache="false" data-height="299">
    <thead>
        
         <tr>
            <th data-field="id">ID</th>
            <th data-field="title">TITLE</th>
            <th data-field="body">BODY</th>
            <th data-field="startDate">START DATE</th>
            <th data-field="expiryDate">EXPIRY DATE</th>
         </tr>
        
    </thead>
    </table>
 
    
    <a href="#popup" class="open-popup-link">Create New</a>
    
    <div id="popup" class="white-popup mfp-hide">
          
        <table>
            
            <tr>
                <td>
                    Title
                </td>
                <td>
                    <input type="text" name="title" size="50"/>
                </td>
            </tr>
            
            <tr>
                <td>
                    Body
                </td>
                <td>
                    <input type="text" name="body" size="50"/>
                </td>
            </tr>
            
            
             <tr>
                <td>
                    Start Date
                </td>
                <td>
                    <input type="text" name="startdate" size="50"/>
                </td>
            </tr>
            
              <tr>
                <td>
                    Expiry Date
                </td>
                <td>
                    <input type="text" name="expirydate" size="50"/>
                </td>
            </tr>
            
        </table>
        
        
    </div>
    
    
    
  </body>
</html>