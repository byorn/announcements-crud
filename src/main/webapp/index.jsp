<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Announcements-Code Challenge</title>

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
    
    <!-- jQuery Form component for passing form Data -->
    <script src="http://malsup.github.com/jquery.form.js"></script> 
   
    
    
    <!-- Table List of Announcements -->
    <table id="announcements-table" data-toggle="table" data-url="<%= request.getContextPath() %>/webresources/rest/get" data-id-field="id" data-click-to-select="true" data-single-select="true">
    <thead>
        
         <tr>
            <th data-field="state" data-checkbox="true"></th>
            <th data-field="title">TITLE</th>
            <th data-field="body">BODY</th>
            <th data-field="startDate">START DATE</th>
            <th data-field="expiryDate">EXPIRY DATE</th>
         </tr>
        
    </thead>
    </table>
   
    
    <!-- Buttons Edit, and Create-->
    <a href="#popup" class="open-popup-link btn btn-primary" role="button">Edit</button> &nbsp;&nbsp;
    <a id="createNewButton" href="#popup" class="open-popup-link btn btn-primary" role="button">Create New</a>
    
    
    
    <!-- The Popup Window that will show the edit and create form -->
    <div id="popup" class="white-popup mfp-hide">

        <form id="announcementForm" action="<%= request.getContextPath()%>/webresources/rest/post" method="post"> 
            <table>
                <tr>
                    <td>
                        Title
                    </td>
                    <td>
                        <input id="id" type="hidden" name="id" size="50"/>
                        <input id="title" type="text" name="title" size="50" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Body
                    </td>
                    <td>
                        <textarea id="body" rows="10" name="body" cols="50" class="form-control"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        Start Date
                    </td>
                    <td>
                        <input id="startdate" type="text" name="startdate" size="50" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Expiry Date
                    </td>
                    <td>
                        <input id="expirydate" type="text" name="expirydate" size="50" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td>
                        <input type="submit" value="Submit" class="btn btn-primary" role="button"/>
                    </td>
                </tr>
            </table>
        </form>

    </div>
    
    
    
  </body>
</html>